package dao;

import java.sql.*;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import model.User;

public class UserDAO {
    
    private String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private String MYSQL_USER = "root";
    private String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    Scanner scan = new Scanner(System.in);
    
    public String create(String email, String password){
        
        Connection conn = null;
        

        try{           
            conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);

            
            String query = "INSERT INTO User (user_email, user_password)"+" VALUES (?,?)";
            String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());


            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,email);
            preparedStmt.setString(2,pw_hash);

            preparedStmt.execute();
            conn.close();

            
            return pw_hash;
            }
            catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Użytkownik istnieje");
            return null;
            }
            catch (SQLException e){
            System.out.println(e);
            return null;
        } 
        

       
    }

    public boolean loginVer(String email, String password){

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
