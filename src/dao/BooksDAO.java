package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Rest.RestApi;
import Rest.Root;
import Utils.Utils;

public class BooksDAO {
    
    public static void main(String[] args) throws SQLException {
        

        Root root = RestApi.getBooks();
        Random rand = new Random();
        
        // System.out.println(Utils.randomPrice());
        try (Connection conn = Utils.mySqlConnection()){
        String QUERY_ADD = "INSERT INTO books (title,category,price,valid) VALUES (?,?,?,?)";
        String QUERY_UPDATE_PRICE = "UPDATE books SET price = ? WHERE title = ?";
        String QUERY_LIST_BOOKS = "SELECT title from books";
        String QUERY_SET_VALIDATION = "UPDATE books SET valid = ? WHERE title = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
        PreparedStatement updatePrice = conn.prepareStatement(QUERY_UPDATE_PRICE);
        PreparedStatement listBooks = conn.prepareStatement(QUERY_LIST_BOOKS);
        PreparedStatement updateValidation = conn.prepareStatement(QUERY_SET_VALIDATION);

        List<String>toBeRemoved = new ArrayList<>();
        
        
        String QUERY_LIST_CATEGORIES = "SELECT count(*) from books";
        String QUERY_IF_BOOK_IN_DATABASE = "SELECT title from books WHERE title = ?";
        PreparedStatement checkIfEmpty = conn.prepareStatement(QUERY_LIST_CATEGORIES);
        PreparedStatement checkIfBookExist = conn.prepareStatement(QUERY_IF_BOOK_IN_DATABASE);
        int size = 0;

        ResultSet rs = checkIfEmpty.executeQuery();
         while (rs.next()) {
            size = rs.getInt(1);
         }
         
        
        if(size==0){
            int i = 0;
                while(i<root.getResults().getLists().size()){
                    int j = 0;
                        while(j<root.getResults().getLists().get(i).getBooks().size()){
  
                            String title = root.getResults().getLists().get(i).getBooks().get(j).getTitle();              
                            int category = Utils.randomCategory();
                            double price = (double)root.getResults().getLists().get(i).getBooks().get(j).getBook_image_width()/100;
            
                            preparedStmt.setString(1, title);
                            preparedStmt.setInt(2, category);
                            preparedStmt.setDouble(3, price);
                            preparedStmt.setBoolean(4, true);
                            preparedStmt.execute();
                            j++;              
                        }i++;

                }
            }else{

                int i = 0;
                while(i<root.getResults().getLists().size()){
                    int j = 0;
                        while(j<root.getResults().getLists().get(i).getBooks().size()){

                            checkIfBookExist.setString(1,root.getResults().getLists().get(i).getBooks().get(j).getTitle());
                            
                            boolean itDoesExist = false;
                            ResultSet check = checkIfBookExist.executeQuery();
                            while (check.next()){
                               itDoesExist = true;
                            }
                            if(itDoesExist){

                            String title = root.getResults().getLists().get(i).getBooks().get(j).getTitle();
                            toBeRemoved.add(title);
                            double price = (double)root.getResults().getLists().get(i).getBooks().get(j).getBook_image_width()/100;

                            updatePrice.setDouble(1,price);
                            updatePrice.setString(2,title);
                            
                            
                            updatePrice.execute();

                            }else if(!itDoesExist){

                                String title = root.getResults().getLists().get(i).getBooks().get(j).getTitle();    
                                toBeRemoved.add(title);          
                                int category = Utils.randomCategory();
                                double price = (double)root.getResults().getLists().get(i).getBooks().get(j).getBook_image_width()/100;

                                preparedStmt.setString(1, title);
                                preparedStmt.setInt(2, category);
                                preparedStmt.setDouble(3, price);
                                preparedStmt.setBoolean(4, true);
                                preparedStmt.execute();
                                

                            }
                            j++;


                        }i++;
                    }
                    
                    ResultSet lB = listBooks.executeQuery();
                    while(lB.next()){                    
                        
                        if(!toBeRemoved.contains(lB.getString(1))){

                            updateValidation.setString(2,lB.getString(1));
                            updateValidation.setBoolean(1, false);
                            updateValidation.execute();
                        }              
                    }



            }
        }catch(Exception e){
            System.out.println(e);
            }






    //     int i=0;
    //     while(i<root.getResults().getLists().size()){
    //         int j = 0;
    //         while(j<root.getResults().getLists().get(i).getBooks().size()){


    //             listOfBooks.add(root.getResults().getLists().get(i).getBooks().get(j).getTitle());
    //             j++;
    //         }i++;

    //     }
        
    //     try (Connection conn = Utils.mySqlConnection()){
    //     for(String book :listOfBooks){

    //         String QUERY_ADD = "INSERT INTO books (title,category,price) VALUES (?,?,?)";
    //         PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);
    //         String title = book;
    //         double price = Utils.randomPrice();
    //         int categoryId = Utils.randomCategory();
            
    //         preparedStmt.setString(1, title);
    //         preparedStmt.setInt(2, categoryId);
    //         preparedStmt.setDouble(3, price);

    //         preparedStmt.execute();
    //     }
    //     }catch(Exception e){
    //     System.out.println(e);
    //     }
        

        

    }

    
    }

