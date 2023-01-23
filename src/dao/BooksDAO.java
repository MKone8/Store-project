package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Rest.RestApi;
import Rest.Root;
import Utils.Utils;

public class BooksDAO {
    
    public static void main(String[] args) throws SQLException {
        

        Root root = RestApi.getBooks();
        Random rand = new Random();
        
        // System.out.println(Utils.randomPrice());
        // try (Connection conn = Utils.mySqlConnection()){
        // String QUERY_ADD = "INSERT INTO books (title,category,price) VALUES (?,?,?)";
        // PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
        
        List<String>listOfBooks = new ArrayList<>();
        // while(i<root.getResults().getLists().size()){
        //     int j = 0;
        //     while(j<root.getResults().getLists().get(i).getBooks().size()){
        //         // String isbn_number = root.getResults().getLists().get(i).getBooks().get(j).getPrimary_isbn10();
        //         String title = root.getResults().getLists().get(i).getBooks().get(j).getTitle();
        //         // double price = Utils.randomPrice();
        //         int category = Utils.randomCategory();
        //         double price = root.getResults().getLists().get(i).getBooks().get(j).getBook_image_width();

        //         preparedStmt.setString(1, title);
        //         preparedStmt.setInt(2, category);
        //         preparedStmt.setDouble(3, price);

        //         preparedStmt.execute();

                
        //         j++;
        //     }i++;

        // }
        // }catch(Exception e){
        //     System.out.println(e);
        //     }






        int i=0;
        while(i<root.getResults().getLists().size()){
            int j = 0;
            while(j<root.getResults().getLists().get(i).getBooks().size()){


                listOfBooks.add(root.getResults().getLists().get(i).getBooks().get(j).getTitle());
                j++;
            }i++;

        }
        
        try (Connection conn = Utils.mySqlConnection()){
        for(String book :listOfBooks){

            String QUERY_ADD = "INSERT INTO books (title,category,price) VALUES (?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
            String title = book;
            double price = Utils.randomPrice();
            int categoryId = Utils.randomCategory();
            
            preparedStmt.setString(1, title);
            preparedStmt.setInt(2, categoryId);
            preparedStmt.setDouble(3, price);

            preparedStmt.execute();
        }
        }catch(Exception e){
        System.out.println(e);
        }
        System.out.println(listOfBooks);

        

    }

    
    
}
