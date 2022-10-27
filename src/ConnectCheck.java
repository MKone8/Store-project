import java.sql.*;



public class ConnectCheck {
    public static void main (String [] args){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8"
            ,"root"
            ,"xvpVPoWbop8Mf3y");
            
            }catch(Exception e){
                System.out.println(e);
                    
            }finally {
                if (conn!=null){
                    
                    try{
                        System.out.println();
                        conn.close();
                        System.out.println();
                    } catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
    }}
    
    


