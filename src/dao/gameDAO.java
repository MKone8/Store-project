package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Utils.Utils;
import model.Game;

public class GameDAO {
    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private static String MYSQL_USER = "root";
    private static String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    private String MYSQL_TABLE = "games"; // games, books, films // Tworze obiekt GamesDAO i w konstruktorze ustawiam
                                          // wartość (możliwe, ze trzeba będize użyć settera)

    // Game games = new Game(title, category, price);
    public List<Game> findAll() {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            List<Game> listOfGames = new ArrayList<Game>();
            String QUERY_ADD = "SELECT games.id, games.title, category.id, games.price FROM "+MYSQL_TABLE+" LEFT JOIN category ON games.categoryID = category.id";
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                Game games = new Game(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getInt("category.id"), resultSet.getDouble("price"));
                listOfGames.add(games);
            }
            return listOfGames;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Game> setPromoPrice(int categoryId, Double discountPercentage) {
        List<Game> listOfGames = findAll();
        List<Game> discountedGames = new ArrayList<Game>();
        for (Game toBePromoted : listOfGames) {
            if (toBePromoted.getCategory() == categoryId) {               
                toBePromoted.setPrice(((toBePromoted.getPrice() * discountPercentage)));
                discountedGames.add(toBePromoted);
            }
        }
        return discountedGames;
    }

    public void updateWeekendPromo(List<Game> discountedGames) {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_PUT_PROMO_PRICES = "UPDATE games SET dscd_price = ROUND(?,2) WHERE id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_PUT_PROMO_PRICES);
            if(Utils.ifWeekend()){
            for (Game discountedGame : discountedGames) {
                preparedStmt.setDouble(1, discountedGame.getPrice());
                preparedStmt.setInt(2, discountedGame.getId());
                preparedStmt.execute();
            }} else{
                System.out.println("Poczekajmy na weekend!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void finishPromoSale(){
        List<Game>regularPrice = findAll();
        
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)){
            String QUERY_FINISH_PROMO_PRICES = "UPDATE games SET dscd_price = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_FINISH_PROMO_PRICES);
            for(Game of : regularPrice){
                preparedStmt.setNull(1,Types.DOUBLE);
                preparedStmt.execute();              
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}