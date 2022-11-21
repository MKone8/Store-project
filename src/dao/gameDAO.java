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

public class gameDAO {
    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private static String MYSQL_USER = "root";
    private static String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    private String MYSQL_TABLE = "games"; // games, books, films // Tworze obiekt GamesDAO i w konstruktorze ustawiam
                                          // wartość (możliwe, ze trzeba będize użyć settera)

    // Game games = new Game(title, category, price);
    public List<Game> findAll() {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            List<Game> listOfGames = new ArrayList<Game>();
            String QUERY_ADD = "SELECT id, title, category, price FROM "+MYSQL_TABLE+"";
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                Game games = new Game(resultSet.getInt("id"), resultSet.getString("title"),
                        resultSet.getString("category"), resultSet.getDouble("price"));
                listOfGames.add(games);
            }
            return listOfGames;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Game> setPromoPrice(String category, Double discountPercentage) {
        List<Game> promoList = findAll();
        List<Game> discountedGames = new ArrayList<Game>();
        for (Game toBePromoted : promoList) {
            if (toBePromoted.getCategory().contains(category)) {
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
            if(!Utils.ifWeekend()){
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
    public void checkIfFinished(){
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)){
            String CHECK_IF_FINISHED = "SELECT * FROM games ORDER BY dscd_price DESC LIMIT 10;";
            PreparedStatement preparedStmt = conn.prepareStatement(CHECK_IF_FINISHED);
            ResultSet resultSet = preparedStmt.executeQuery();
            while(resultSet.next()){
                System.out.print(resultSet.getString(1));
                System.out.print(resultSet.getString(2));
                System.out.print(resultSet.getString(3));
                System.out.print(resultSet.getString(4));
                System.out.print(resultSet.getString(5));
                System.out.println();
            }
            

        }catch (Exception e){
            System.out.println(e);
        }
    }
    

    

}