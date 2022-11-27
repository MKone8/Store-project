package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Utils.Utils;
import model.Category;

public class CategoryDAO {

    Scanner scan = new Scanner(System.in);
    public Double price;

    public int listCategory() {

        try (Connection conn = Utils.mySqlConnection()) {
            int nextPage = 0;

            for (;;) {
                String QUERY_LIST_CATEGORIES = "SELECT * FROM category LIMIT ?,?";
                String QUERY_COUNT_CATEGORIES = "SELECT COUNT(*) FROM category";
                PreparedStatement preparedStmt = conn.prepareStatement(QUERY_LIST_CATEGORIES);
                PreparedStatement preparedStmt2 = conn.prepareStatement(QUERY_COUNT_CATEGORIES);
                int size = 0;
                ResultSet rs = preparedStmt2.executeQuery();
                while(rs.next()){
                    size = rs.getInt(1);                   
                }
                
                
                
                preparedStmt.setInt(1, nextPage);
                preparedStmt.setInt(2, nextPage + 5);

                ResultSet resultSet = preparedStmt.executeQuery();
                
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String category = resultSet.getString("category");
                    System.out.println("ID: " + id + " Kategoria: " + category);
                    
                }
                System.out.println(
                        "[-----Wpisz 'dalej' aby szukać dalej wpisz 'cofnij' cofnąć, wpisz ID kategorii aby wybrać-----]");
                String option = scan.nextLine().toLowerCase();
                if (option.equals("dalej")) {
                    nextPage = +5;
                } else if (option.equals("cofnij")) {
                    if (nextPage == 5) {
                        nextPage = 0;
                    } else
                        nextPage = -5;
                } else {
                    int optionInt = Integer.parseInt(option);
                    if (optionInt < size) { // to jest do poprawy, tymczasowe rozwiazanie
                        return optionInt;
                    } else System.out.println("Brak kategorii, spróbuj ponownie!");
                }
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Category> findAllCategories() {

        String QUERY_FIND_ALL_CATEGORIES = "Select * FROM category";

        try (Connection conn = Utils.mySqlConnection()) {
            List<Category> categories = new ArrayList<Category>();
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_FIND_ALL_CATEGORIES);

            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                Category product = new Category(resultSet.getInt("id"), resultSet.getInt("category"));
                categories.add(product);
            }
            return categories;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
