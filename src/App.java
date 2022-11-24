import java.sql.Date;

import dao.*;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // MenuController menuCon = new MenuController();
        // menuCon.mainMenu();
        // ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        // gameDAO test = new gameDAO();
        
        // categoryDAO.findAllCategories();
        System.out.println(categoryDAO.findAllCategories());
        // System.out.println(productDAO.listCategory());
        // test.updatePromos(test.setPromoPrice(test.findAll(),"FPS"));
        // test.findAll();
        // test.updateWeekendPromo(test.setPromoPrice("FPS",0.9));
        // test.finishPromoSale();
        // test.checkIfFinished();

        
    }
}