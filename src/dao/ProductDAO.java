package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;

import java.sql.*;

public class ProductDAO {

    Scanner scan = new Scanner(System.in);
    public Double price;
    private static String MYSQL_URL = "jdbc:mysql://localhost:3306/gamesStore?useSSL=false&characterEncoding=utf8";
    private static String MYSQL_USER = "root";
    private static String MYSQL_PASSWORD = "xvpVPoWbop8Mf3y";
    private String MYSQL_TABLE = "games"; // games, books, films // Tworze obiekt GamesDAO i w konstruktorze ustawiam
                                          // wartość (możliwe, ze trzeba będize użyć settera)

    public void addProduct(String title, int categoryId, Double price) {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {

            String QUERY_ADD = "INSERT INTO " + MYSQL_TABLE + " (title, categoryId, price) VALUES (?,?,?)";
            PreparedStatement preparedStmt = conn.prepareStatement(QUERY_ADD);

            preparedStmt.setString(1, title);
            preparedStmt.setInt(2, categoryId);
            preparedStmt.setDouble(3, price);

            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeProduct(String title) {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_REMOVE_BY_TITLE = "DELETE FROM " + MYSQL_TABLE + " WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_REMOVE_BY_TITLE);
            preparedStatement.setString(1, title);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void removeProduct(int id) {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_REMOVE_BY_ID = "DELETE FROM " + MYSQL_TABLE + " WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_REMOVE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String showInfo(String title) {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_SHOWINFO_BY_TITLE = "Select games.id, games.title, category.category, games.price FROM "
                    + MYSQL_TABLE + " LEFT JOIN category ON games.categoryID = category.id WHERE games.title = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SHOWINFO_BY_TITLE);
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titl = resultSet.getString("title");
                String category = resultSet.getString("category");
                this.price = resultSet.getDouble("price");
                String infos = "[ID] = " + id + ", [title] = " + titl + ", [category] = " + category + ", [price] = "
                        + price;
                return infos;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public String showInfo(int id) {

        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_SHOWINFO_BY_ID = "Select games.id, games.title, category.category, games.price FROM "
                    + MYSQL_TABLE + " LEFT JOIN category ON games.categoryID = category.id WHERE games.id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SHOWINFO_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int prodId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String category = resultSet.getString("category.category");
                this.price = resultSet.getDouble("price");
                String infos = "[ID]= " + prodId + ",[title]= " + title + ",[category]= " + category + ",[price]= "
                        + price;
                return infos;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void sortAlph() {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT title, price FROM " + MYSQL_TABLE + " ORDER BY title ASC LIMIT 10");

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                price = resultSet.getDouble("price");
                System.out.println("Produkt: " + title + " Cena:" + price);

            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updatePrice(int id, double price) {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_UPDATE_PRICE_BY_ID = "UPDATE " + MYSQL_TABLE + " SET price = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_UPDATE_PRICE_BY_ID);
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updatePrice(String title, double price) {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_UPDATE_PRICE_BY_TITLE = "Update " + MYSQL_TABLE + " SET price = ? WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_UPDATE_PRICE_BY_TITLE);
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, title);

            preparedStatement.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void searchForGame(String tit) {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_SEARCH_FOR_GAME = "Select * FROM " + MYSQL_TABLE + " WHERE title LIKE ? LIMIT 10";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SEARCH_FOR_GAME);
            preparedStatement.setString(1, "%" + tit + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                String price = resultSet.getString("price");
                System.out.println("Tytuł: " + title + ", Kategoria: " + category + " Cena: " + price);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchForCategory(int cat) {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String QUERY_SEARCH_FOR_CATEGORY = " Select * From " + MYSQL_TABLE + " WHERE categoryId LIKE ? LIMIT 10";
            PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SEARCH_FOR_CATEGORY);
            preparedStatement.setInt(1, cat);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String category = resultSet.getString("category");
                String price = resultSet.getString("price");
                System.out.println("Tytuł: " + title + ", Kategoria: " + category + " Cena: " + price);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
