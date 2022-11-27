package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class Utils {

    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private static String MYSQL_USER = "root";
    private static String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    private String MYSQL_TABLE = "category"; // games, books, films // Tworze obiekt GamesDAO i w konstruktorze ustawiam
                                             // wartość (możliwe, ze trzeba będize użyć settera)

    
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
}
