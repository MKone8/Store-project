package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import model.Game;


public class gameDAO {
    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private static String MYSQL_USER = "root";
    private static String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    private String MYSQL_TABLE = "games"; //games, books, films // Tworze obiekt GamesDAO i w konstruktorze ustawiam wartość (możliwe, ze trzeba będize użyć settera)

    // Game games = new Game(title, category, price);
    public List<Game> findAll(){

        
        try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
        List<Game>listOfGames = new ArrayList<Game>();
        String QUERY_ADD = "SELECT title, category, price FROM games";
        PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);

        // preparedStmt.setString(1, title);
        
        ResultSet resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){
            // String title = resultSet.getString("title");
            // String category = resultSet.getString("category");
            // double price = resultSet.getDouble("price");
            Game games = new Game(resultSet.getString("title"),resultSet.getString("category"),resultSet.getDouble("price"));
            listOfGames.add(games);
            // System.out.println(games.getPrice());
            
            
        }
        // System.out.println(listOfGames.get(4));
        return listOfGames;
             
    }
    catch(Exception e){
        System.out.println(e);
    } return null;
    }

    public void setPromo(List<Game> promoList){
        // try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
        //     String QUERY_ADD = "SELECT games, category FROM games WHERE category = ?";
        //     PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
        //     preparedStmt.setString(1, category);

            
        
        for(Game u :  promoList){
            if(u.getCategory().contains("FPS")){
                u.setPrice(u.getPrice()*0.9);
                System.out.println("nowa cena to: "+u.getPrice());
            } else System.out.println("cena to: "+u.getPrice());
            
            // System.out.println(u.getPrice());
            // String title = u.toString();
            // if(title.contains("category=FPS")){
            //     System.out.println("Jestem FPS");
            // } else {System.out.println("Nie jestem FPS");}
            
            
        // }

    }

    
}}