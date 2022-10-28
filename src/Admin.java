import java.sql.*;
import java.util.Scanner;

public class Admin {
     void loginVerficiation(){
        
        

        Connection conn = null;
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");
            Scanner scanner = new Scanner(System.in);
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
            
           
            System.out.print("Podaj email: ");           
            String email = scanner.nextLine();
            System.out.print("Podaj hasło: ");
            String password = scanner.nextLine();
            resultSet = statement.executeQuery("SELECT EXISTS (SELECT 1 FROM gamesStore_admins WHERE admin_email = '"+email+"' AND admin_password ='"+password+"')");
            

            int code;           
            if (resultSet.next()) {
                code = resultSet.getInt(1);
                System.out.println(code);

                if (code!=0){
                    System.out.println("Witaj Jan, miło Cie widzieć!");
                    sortAlph1();
                    
                }else{
                    System.out.println("Nieprawidłowy email lub hasło.");
                }
                
            
            }
            resultSet.close();
            statement.close();
            conn.close();
            scanner.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    } public void sortAlph1(){
        
        Connection conn = null;
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");
            
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
                   
            resultSet = statement.executeQuery("SELECT game_title FROM gamesStore_games ORDER BY game_title ASC");
            

            String title;           
            while (resultSet.next()) {
                title = resultSet.getString("game_title");
                System.out.println(title);
            
            }
            resultSet.close();
            statement.close();
            conn.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    } public void remove2(){
        System.out.println("hej");

        Connection conn = null;
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");
            Scanner sc = new Scanner(System.in);
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;

            System.out.println("Co usuwamy kolego?");
            String title = sc.nextLine();

                   
            resultSet = statement.executeQuery("DELETE FROM gameStore_games WHERE game_title = '"+title+"'");

            resultSet.close();
            statement.close();
            conn.close();
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    
}
public void add3(){
    System.out.println("hej");

    Connection conn = null;
    try {
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
        ,"root"
        ,"xvpVPoWbop8Mf3y");
        Scanner sc = new Scanner(System.in);
        Statement statement = conn.createStatement();
        
        System.out.println("Podaj tytuł");
        String gettitle = sc.nextLine();
        System.out.println("Podaj kategorie:");
        String getcategory = sc.nextLine();
        ResultSet resultSet;
        
        
        statement.executeUpdate("INSERT INTO gamesStore_games (game_title, game_category) VALUES('"+gettitle+"', '"+getcategory+"')");
        resultSet = statement.executeQuery("SELECT * FROM gamesStore_games ORDER BY game_id DESC LIMIT 1");

        while (resultSet.next()) {
            int id = resultSet.getInt("game_id");
            String title = resultSet.getString("game_title");
            String category = resultSet.getString("game_category");
            System.out.println("Ostatnio dodany: "+id+" "+title+" "+category);
        
        }
        resultSet.close();
        statement.close();
        conn.close();
        sc.close();
    }
    catch(Exception e){
        System.out.println(e);
    }

}
public void update4(){
    System.out.println("hej");

    Connection conn = null;
    try {
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
        ,"root"
        ,"xvpVPoWbop8Mf3y");
        Scanner sc = new Scanner(System.in);
        Statement statement = conn.createStatement();
        
        System.out.println("Podaj tytuł");
        String gettitle = sc.nextLine();
        System.out.println("Podaj kategorie:");
        String getcategory = sc.nextLine();
        ResultSet resultSet;
        
        
        statement.executeUpdate("INSERT INTO gamesStore_games (game_title, game_category) VALUES('"+gettitle+"', '"+getcategory+"')");
        resultSet = statement.executeQuery("SELECT * FROM gamesStore_games ORDER BY game_id DESC LIMIT 1");

        while (resultSet.next()) {
            int id = resultSet.getInt("game_id");
            String title = resultSet.getString("game_title");
            String category = resultSet.getString("game_category");
            System.out.println("Ostatnio dodany: "+id+" "+title+" "+category);
        
        }
        resultSet.close();
        statement.close();
        conn.close();
        sc.close();
    }
    catch(Exception e){
        System.out.println(e);
    }

}}
