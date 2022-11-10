import dao.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        MenuController menuCon = new MenuController();
        menuCon.mainMenu();

        // UserDAO userDAO = new UserDAO();
        // userDAO.create("jan@dupa.pl","haslocienzkie");
    }
}