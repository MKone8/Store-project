import dao.*;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // MenuController menuCon = new MenuController();
        // menuCon.mainMenu();

        gameDAO test = new gameDAO();
        

        // test.updatePromos(test.setPromoPrice(test.findAll(),"FPS"));
        // test.findAll();
        test.getDayNumber();
        
    }
}