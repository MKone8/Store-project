import java.sql.*;




public class User {

    protected Double gamePrice;
    private String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private String MYSQL_USER = "root";
    private String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";

    boolean loginVer(String email, String password ){

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

    public void addProduct(String title, String category, Double price){
        Connection conn = null;
        try {      
            conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
            Statement statement = conn.createStatement();
            // ResultSet resultSet;

        statement.executeUpdate("INSERT INTO gamesStore_games (game_title, game_category, game_price) VALUES('"+title+"', '"+category+"', '"+price+"')");
        // resultSet = statement.executeQuery("SELECT * FROM gamesStore_games ORDER BY game_id DESC LIMIT 1");

        // while (resultSet.next()) {
        //     int gameId = resultSet.getInt("game_id");
        //     String gameTitle = resultSet.getString("game_title");
        //     String gameCategory = resultSet.getString("game_category");
        //     gamePrice = resultSet.getDouble("game_price");
        //     // System.out.println("Dodany produkt [id]="+gameId+" [title]= "+gameTitle+" [category]= "+gameCategory+" [price]= "+gamePrice);        
        // }
        // resultSet.close();
        statement.close();
        conn.close();       
    }
    catch(Exception e){
        System.out.println(e);
    }}

    public void removeProduct(String title){

        Connection conn = null;
        try {          
            conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);           
            Statement statement = conn.createStatement();

            statement.executeUpdate("DELETE FROM gamesStore_games WHERE game_title = '"+title+"'");          
            statement.close();
            conn.close();            
        }
        catch(Exception e){
            System.out.println(e);

        }}
        public void removeProduct(int id){
    
            Connection conn = null;
            try {
                
                conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);  
                
                Statement statement = conn.createStatement();             
                statement.executeUpdate("DELETE FROM gamesStore_games WHERE game_id = '"+id+"'");
                    
                statement.close();
                conn.close();               
            }
            catch(Exception e){
                System.out.println(e);
            }
}
            String showInfo(String game){

                Connection conn = null;
                try{
                conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD); 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * FROM gamesStore_games WHERE game_title = '"+game+"'");

                if(resultSet.next()){
                    int gameId = resultSet.getInt("game_id");
                    String gameTitle = resultSet.getString("game_title");                    
                    String gameCategory = resultSet.getString("game_category");                    
                    this.gamePrice = resultSet.getDouble("game_price");
                    String infos = "[ID] = "+gameId+", [title] = "+gameTitle+", [category] = "+gameCategory+", [price] = "+gamePrice;
                    return infos;
                    
                }

                }catch(Exception e){
                    System.out.println(e);
                } return null;
            }
            String showInfo(int id){

                Connection conn = null;
                try{
                conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD); 
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * FROM gamesStore_games WHERE game_id = '"+id+"'");

                if(resultSet.next()){
                    int gameId = resultSet.getInt("game_id");
                    String gameTitle = resultSet.getString("game_title");                    
                    String gameCategory = resultSet.getString("game_category");                    
                    this.gamePrice = resultSet.getDouble("game_price");                  
                    String infos = "[ID]= "+gameId+",[title]= "+gameTitle+",[category]= "+gameCategory+",[price]= "+gamePrice;
                    return infos;
                    
                }

                }catch(Exception e){
                    System.out.println(e);
                } return null;
            }

            public void sortAlph(){
                Connection conn = null;
                try{
                    conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT game_title, game_price FROM gamesStore_games ORDER BY game_title ASC LIMIT 10");

                    while(resultSet.next()){
                        String gameTitle = resultSet.getString("game_title");
                        gamePrice = resultSet.getDouble("game_price");
                        System.out.println("Produkt: "+gameTitle+" Cena:"+gamePrice);
      
                    }
                    resultSet.close();
                    statement.close();
                    conn.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }

            public void updatePrice(int id, double price){
                Connection conn = null;
                try{
                    conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
                    Statement statement = conn.createStatement();
                    statement.executeUpdate("UPDATE gamesStore_games SET game_price ='"+price+"' WHERE game_id ='"+id+"'");
                  
                    statement.close();
                    conn.close();

                }catch (Exception e){
                    System.out.println(e);
                }

            }
            public void updatePrice(String title, double price){
                Connection conn = null;
                try{
                    conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
                    Statement statement = conn.createStatement();
                    statement.executeUpdate("UPDATE gamesStore_games SET game_price ='"+price+"' WHERE game_title ='"+title+"'");
                  
                    statement.close();
                    conn.close();

                }catch (Exception e){
                    System.out.println(e);
                }

            }
            public void searchForGame(String game){
                Connection conn = null;
                try{
                    conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select * From GamesStore_games WHERE game_title LIKE '%"+game+"%' LIMIT 10");
                    
                    while(resultSet.next()){
                        String title = resultSet.getString("game_title"); 
                        String category = resultSet.getString("game_category"); 
                        String price = resultSet.getString("game_price"); 
                        System.out.println("Tytuł: "+title+", Kategoria: " +category+" Cena: "+price);
                    }
                    statement.close();
                    conn.close();

                }catch (Exception e){
                    System.out.println(e);
                }}

                public void searchForCategory(String cat){
                    Connection conn = null;
                    try{
                        conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD);
                        Statement statement = conn.createStatement();
                        ResultSet resultSet = statement.executeQuery("Select * From GamesStore_games WHERE game_category LIKE'%"+cat+"%' LIMIT 10");
                        
                        while(resultSet.next()){
                            String title = resultSet.getString("game_title"); 
                            String category = resultSet.getString("game_category"); 
                            String price = resultSet.getString("game_price"); 
                            System.out.println("Tytuł: "+title+", Kategoria: " +category+" Cena: "+price);
                        }
                        statement.close();
                        conn.close();
    
                    }catch (Exception e){
                        System.out.println(e);
                    }
            }
}
