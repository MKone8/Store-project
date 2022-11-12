package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class ProductDAO {


    public Double gamePrice;
    private String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private String MYSQL_USER = "root";
    private String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";

    public void addProduct(String title, String category, Double price){
        
        try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
           
        String QUERY_ADD = "INSERT INTO gamesStore_games (game_title, game_category, game_price)"+ " VALUES (?,?,?)";
        PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);

        preparedStmt.setString(1, title);
        preparedStmt.setString(2, category);
        preparedStmt.setDouble(3, price);
        
        preparedStmt.execute();
             
    }
    catch(Exception e){
        System.out.println(e);
    }}

    public void removeProduct(String title){

        try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){         
            String QUERY_REMOVE_BY_TITLE = "DELETE FROM gamesStore_games WHERE game_title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_REMOVE_BY_TITLE);
            preparedStatement.setString(1,title);
            preparedStatement.execute();                      
        }
        catch(Exception e){
            System.out.println(e);

        }}

        public void removeProduct(int id){
    
            try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){ 
                String QUERY_REMOVE_BY_ID = "DELETE FROM gamesStore_games WHERE game_id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY_REMOVE_BY_ID);
                preparedStatement.setInt(1,id);
                preparedStatement.execute();                            
            }
            catch(Exception e){
                System.out.println(e);
            }
}
            public String showInfo(String game){

                try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                String QUERY_SHOWINFO_BY_TITLE = "Select * FROM gamesStore_games WHERE game_title = ?";

                PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SHOWINFO_BY_TITLE);
                preparedStatement.setString(1,game);
                             
                ResultSet resultSet = preparedStatement.executeQuery();
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
            public String showInfo(int id){

                try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                String QUERY_SHOWINFO_BY_ID = "Select * FROM gamesStore_games WHERE game_id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SHOWINFO_BY_ID);
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();

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
                try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT game_title, game_price FROM gamesStore_games ORDER BY game_title ASC LIMIT 10");

                    while(resultSet.next()){
                        String gameTitle = resultSet.getString("game_title");
                        gamePrice = resultSet.getDouble("game_price");
                        System.out.println("Produkt: "+gameTitle+" Cena:"+gamePrice);
      
                    }
                    resultSet.close();
                    statement.close();
                    
                }catch(Exception e){
                    System.out.println(e);
                }
            }

            public void updatePrice(int id, double price){
                try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                    String QUERY_UPDATE_PRICE_BY_ID = "UPDATE gamesStore_games SET game_price = ? WHERE game_id = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(QUERY_UPDATE_PRICE_BY_ID);
                    preparedStatement.setDouble(1,price);
                    preparedStatement.setInt(2,id);
                    
                    preparedStatement.execute();
                    
                }catch (Exception e){
                    System.out.println(e);
                }

            }
            public void updatePrice(String title, double price){
                try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                    String QUERY_UPDATE_PRICE_BY_TITLE = "Update gamesStore_games SET game_price = ? WHERE game_title = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(QUERY_UPDATE_PRICE_BY_TITLE);
                    preparedStatement.setDouble(1,price);
                    preparedStatement.setString(2,title);
                    
                    preparedStatement.execute();

                }catch (Exception e){
                    System.out.println(e);
                }

            }
            public void searchForGame(String game){
                try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                    String QUERY_SEARCH_FOR_GAME = "Select * FROM GamesStore_games WHERE game_title LIKE ? LIMIT 10";
                    PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SEARCH_FOR_GAME);
                    preparedStatement.setString(1,"%"+game+"%");
                    
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while(resultSet.next()){
                        String title = resultSet.getString("game_title"); 
                        String category = resultSet.getString("game_category"); 
                        String price = resultSet.getString("game_price"); 
                        System.out.println("Tytuł: "+title+", Kategoria: " +category+" Cena: "+price);
                    }
                    

                }catch (Exception e){
                    System.out.println(e);
                }}

                public void searchForCategory(String cat){
                    try(Connection conn = DriverManager.getConnection(MYSQL_URL,MYSQL_USER,MYSQL_PASSWORD)){
                        String QUERY_SEARCH_FOR_CATEGORY = " Select * From GamesStore_games WHERE game_category LIKE ? LIMIT 10";
                        PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SEARCH_FOR_CATEGORY);
                        preparedStatement.setString(1,cat);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        
                        while(resultSet.next()){
                            String title = resultSet.getString("game_title"); 
                            String category = resultSet.getString("game_category"); 
                            String price = resultSet.getString("game_price"); 
                            System.out.println("Tytuł: "+title+", Kategoria: " +category+" Cena: "+price);
                        }                       
                    }catch (Exception e){
                        System.out.println(e);
                    }
            }
    
}
