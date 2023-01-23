import model.Books;
import model.Game;
import model.Product;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // MenuController menuCon = new MenuController();
        // menuCon.mainMenu();
        Product obj2 = new Game(5,"nowiutka");
        Product obj = new Books(5,"Nowa");
        System.out.println(obj);
        
        System.out.println(obj2.getTitle());
    }
}