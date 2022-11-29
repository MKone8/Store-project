package dao;
import java.sql.*;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;
import Utils.Utils;


public class UserDAO {
    
    private static final String CREATE_USER_QUERY = "INSERT INTO User (email, password)"+" VALUES (?,?)";
    private static final String LOGIN_USER_QUERY = "SELECT password FROM user WHERE email = ?";
    // private static final String USER_EXISTENCE_CHECK = "SELECT email FROM USER WHERE email = ?";
    Scanner scan = new Scanner(System.in);
    
    public void create(String email, String password){
                        
        try(Connection conn = Utils.mySqlConnection()){
   
            String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            PreparedStatement preparedStmt = conn.prepareStatement(CREATE_USER_QUERY);
            preparedStmt.setString(1,email);
            preparedStmt.setString(2,pw_hash);
            preparedStmt.execute();              
       }

            catch (SQLException e){
            System.out.println(e);
            
        } 

    }
        
    public boolean isCreated(String email){
        try(Connection conn = Utils.mySqlConnection()){
            PreparedStatement preparedStmt = conn.prepareStatement(LOGIN_USER_QUERY);
            preparedStmt.setString(1,email);
            ResultSet resultSet = preparedStmt.executeQuery();
        
            if(resultSet.next()){
                return true;
                }else return false;
            }
            catch (SQLIntegrityConstraintViolationException e){
                System.out.println("Uzytkownik istnieje.");
            }catch (SQLException e){
                System.out.println(e);
            }return false;
        } 
            
             
    
       

    public boolean loginVer(String email, String password){
     
        try(Connection conn = Utils.mySqlConnection()){         
            PreparedStatement preparedStatement = conn.prepareStatement(LOGIN_USER_QUERY);
            preparedStatement.setString(1,email);
            ResultSet hashedPassword = preparedStatement.executeQuery();

            if(hashedPassword.next()){
                String check_pw = hashedPassword.getString(1);
                if(BCrypt.checkpw(password,check_pw)){                
                        System.out.println("Witamy z powrotem!");
                        return true;
                    }else System.out.println("Hasło jest nieprawidłowe!");          
                    
                } else System.out.println("Uzytkownik nie istnieje w bazie danych");               
                 } catch (Exception e){
                    System.out.println(e);
                    } return false;                                                  
        }
        
}
