package Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private static String MYSQL_USER = "root";
    private static String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    
    public static int getDayNumber() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return day;

    }

    public static boolean ifWeekend() {
        if (getDayNumber() == 6 || getDayNumber() == 1) {
            return true;
        } else{
            return false;
        }
        
    }
    public static Connection mySqlConnection() throws SQLException{
       Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
       return conn;
    }

    public static double randomPrice(){
        SecureRandom rand = new SecureRandom();
        int upperbound = 15; 
        double double_random = rand.nextInt(upperbound)+rand.nextFloat(); 
        BigDecimal big = BigDecimal.valueOf(double_random).setScale(2,RoundingMode.HALF_UP);
        double dob = big.doubleValue();  
        return dob;
        
    }
    public static int randomCategory(){
        SecureRandom rand = new SecureRandom();
        int upperbound = 9;
        int randomCat = rand.nextInt(upperbound);
        return randomCat;

    }

    
}
