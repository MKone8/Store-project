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
    }
}
