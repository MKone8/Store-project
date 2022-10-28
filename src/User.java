import java.sql.*;
import java.util.Scanner;

public class User{
    public void searchByGame(){

        Connection conn = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");
            Scanner scanner = new Scanner(System.in);
            Statement statement;
            ResultSet resultSet;
            
            statement = conn.createStatement();
            System.out.print("Podaj nazwę gry:");           
            String game = scanner.next();
            resultSet = statement.executeQuery("SELECT * FROM gamesstore_games WHERE game_title LIKE '%"+game+"%'");
            
            int code;
            String title, categoryCatalog;
            while (resultSet.next()) {
                code = resultSet.getInt(1);
                title = resultSet.getString("game_title");
                categoryCatalog = resultSet.getString("game_category");
                System.out.println("ID produktu: "+code+", Tytuł: "+title +", Kategoria: "+categoryCatalog);
            
            }
            resultSet.close();
            statement.close();
            conn.close();
            scanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }
    public void searchByCategory(){
        Connection conn = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");
            Scanner scanner = new Scanner(System.in);
            Statement statement;
            ResultSet resultSet;
            statement = conn.createStatement();
            
            System.out.print("Podaj nazwę kategorii:");           
            String category = scanner.next();
            resultSet = statement.executeQuery("SELECT * FROM gamesstore_games WHERE game_category LIKE '%"+category+"%'");
            int code;
            String title, categoryCatalog;
            while (resultSet.next()) {
                code = resultSet.getInt(1);
                title = resultSet.getString("game_title");
                categoryCatalog = resultSet.getString("game_category");
                System.out.println("ID produktu: "+code+", Tytuł: "+title +", Kategoria: "+categoryCatalog);            
            }
            resultSet.close();
            statement.close();
            conn.close();
            scanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }

    }




