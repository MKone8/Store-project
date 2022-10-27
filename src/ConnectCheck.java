import java.sql.*;


public class ConnectCheck {
    public static void main (String [] args){
        Connection conn = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");

            Statement statement;
            statement = conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from gamesstore_games");
            int code;
            String title, category;
            while (resultSet.next()) {
                code = resultSet.getInt("game_id");
                title = resultSet.getString("game_title");
                category = resultSet.getString("game_category");
                System.out.println(code+", "+title +", "+category);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    
    }}


