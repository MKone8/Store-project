package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
        String QUERY_ADD = "SELECT id, title, category, price FROM games";
        PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);       
        ResultSet resultSet = preparedStmt.executeQuery();
        while(resultSet.next()){

            Game games = new Game(resultSet.getInt("id"),resultSet.getString("title"),resultSet.getString("category"),resultSet.getDouble("price"));
            listOfGames.add(games);           
            }
        return listOfGames;
             
    }
        catch(Exception e){
            System.out.println(e);
    }   return null;
    }

    public List<Game> setPromoPrice(List<Game> promoList, String category){
        List<Game>discountedGames = new ArrayList<Game>();
        for(Game u :  promoList){
            if(u.getCategory().contains(category)){
                u.setPrice(((u.getPrice()*0.5)));
                discountedGames.add(u);
                            
            }                         
    }  
    return discountedGames;
    
}

public void updatePromos(List<Game> discountedGames){
    try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
        String QUERY_PUT_PROMO_PRICES = "UPDATE games SET dscd_price = ? WHERE id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(QUERY_PUT_PROMO_PRICES);
        for (Game dscG: discountedGames){
            
            preparedStmt.setDouble(1,dscG.getPrice());
            preparedStmt.setInt(2,dscG.getId());
            
            System.out.println(dscG.getPrice());
            System.out.println(dscG.getId());
            preparedStmt.execute();
        }


    }catch(Exception e){
        System.out.println(e);
    }
}

public void getDayNumber(){
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    System.out.println(dtf.format(now));
    System.out.println(now.getDayOfWeek());
    
    
}   

}