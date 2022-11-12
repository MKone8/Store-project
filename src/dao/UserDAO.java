package dao;

import java.sql.*;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import model.User;

public class UserDAO {
    
    private String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private String MYSQL_USER = "root";
    private String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    private static final String CREATE_USER_QUERY = "INSERT INTO User (user_email, user_password)"+" VALUES (?,?)";
    private static final String LOGIN_USER_QUERY = "SELECT user_password FROM user WHERE user_email = ?";
    Scanner scan = new Scanner(System.in);
    
    public boolean create(String email, String password){
        
        try           
            (Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
   
            String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
            PreparedStatement preparedStmt = conn.prepareStatement(CREATE_USER_QUERY);
            preparedStmt.setString(1,email);
            preparedStmt.setString(2,pw_hash);
            preparedStmt.execute();
            conn.close();    
            return true;
            }
            catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Użytkownik istnieje");
            return false;
            }
            catch (SQLException e){
            System.out.println(e);
            return false;
        } 
        

       
    }

    public boolean loginVer(String email, String password){

        try
            (Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){         
            PreparedStatement preparedStatement = conn.prepareStatement(LOGIN_USER_QUERY);
            preparedStatement.setString(1,email);
            ResultSet hashedPassword = preparedStatement.executeQuery();

            if(hashedPassword.next()){
                String check_pw = hashedPassword.getString(1);
                if(BCrypt.checkpw(password,check_pw)){                
                        System.out.println("Witamy z powrotem!");
                        return true;
                    } else System.out.println("Hasło jest nieprawidłowe!");          
                    
                } else System.out.println("Uzytkownik nie istnieje w bazie danych");               
                 } catch (Exception e){
                    System.out.println(e);
                    } return false;                                                  
        }
        
}
