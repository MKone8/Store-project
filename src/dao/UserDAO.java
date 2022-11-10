package dao;

import java.sql.*;

import model.User;

public class UserDAO {
    
    private String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private String MYSQL_USER = "root";
    private String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    
    public User create(User newUser){
        
        Connection conn = null;

        try{           
            conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO User (user_email, user_password) VALUES ('maciek@ok.com', 'jeju')");

        } catch (SQLException e){
            System.out.println(e);
        }

        return newUser;
    }

    public boolean loginVer(String email, String password ){

        Connection conn = null;
        try{
            conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
            
            resultSet = statement.executeQuery("SELECT * FROM gamesStore_admins WHERE admin_email = '"+email+"' AND admin_password ='"+password+"'");
            
            if (resultSet.next()){ 
                    return true;      
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
        }
}
