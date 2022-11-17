import dao.*;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // MenuController menuCon = new MenuController();
        // menuCon.mainMenu();

        // Testy test = new Testy(5);

        gameDAO test = new gameDAO();
        
        // System.out.println(test.findAll());
        test.setPromo(test.findAll());
        
    }
}