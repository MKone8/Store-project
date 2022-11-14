import java.util.Scanner;
import dao.*;


public class MenuController {
    
    UserDAO userDAO = new UserDAO();
    ProductDAO productDAO = new ProductDAO();
    Scanner scan = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("1. Zaloguj się");
        System.out.println("2. Kontynuuj jako gość");
        System.out.println("3. Zarejestruj się");
        System.out.println("9. Wyjdź");
        int mainMenu_nr = scan.nextInt();
        scan.nextLine();

        switch (mainMenu_nr) {
            case 1:
                if (logIn())  showMenuAdmin();             
                break;
            case 2:
                showGuestMenu();
                break;
            case 3:
                signIn();
                break;
            case 9:
                closeProgram();
                break;
        }
    }

    public boolean logIn() {
        System.out.println("Podaj email: ");
        String email = scan.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scan.nextLine();
        if (!userDAO.loginVer(email, password))            
            return true;
         else {           
            return false;
        }
    }

    public void signIn(){
        System.out.println("---REJESTRACJA---");
        System.out.println("Podaj email: ");
        String email = scan.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scan.nextLine();
        if(!userDAO.isCreated(email)){  
            userDAO.create(email,password);
            System.out.println("Konto założone poprawnie, witamy!");       
            showGuestMenu();
        }else System.out.println("Użytkownik istnieje.");    
    }


    public void showMenuAdmin() {
        System.out.println("1. Dodaj nową gre");
        System.out.println("2. Zaktualizuj cene");
        System.out.println("3. Ukryj produkt");
        System.out.println("4. Usuń produkt");
        System.out.println("5. Wyświetl alfabetycznie");
        System.out.println("9. Zakończ program");
        int adminMenu_nr = scan.nextInt();
        scan.nextLine();
        switch (adminMenu_nr) {
            case 1:
                menuAddProduct();
                break;
            case 2:
                menuUpdatePrice();
                break;
            case 3:
                menuHideProduct();
                break;
            case 4:
                menuRemoveProduct();
                break;
            case 5:
                menuSortAplh();
                break;
            case 9:
                closeProgram();
                break;
        }
    }

    public void showGuestMenu() {
        System.out.println("Witaj gościu!");
        System.out.println("1. Wyszukaj grę");
        System.out.println("2. Wyszukaj kategorie");
        int x = scan.nextInt();
        scan.nextLine();
        switch (x) {
            case 1:
                guestSearchForGame();
                break;
            case 2:
                guestSearchForCategory();
                break;
        }
    }

    public void menuAddProduct() {
        System.out.println("Okej, dodajemy nową gre!");
        System.out.println("Tytuł gry: ");
        String title = scan.nextLine();
        System.out.println("Kategoria produktu: ");
        String category = scan.nextLine();
        System.out.println("Podaj cenę: ");
        double newPrice = scan.nextDouble();
        scan.nextLine();
        System.out.println("Potwierdź, że chcesz dodać produkt: " + title + " z kategorią: " + category + " oraz ceną: "
                + newPrice);
        System.out.print("Y/n: ");
        String choice = scan.nextLine().toUpperCase();
        if (choice.equals("Y")) {
            productDAO.addProduct(title, category, newPrice);
            System.out.println(productDAO.showInfo(title));
            System.out.println("Czy chcesz dodać kolejny produkt?");
            System.out.print("Y/n: ");
            String Yn = scan.nextLine().toUpperCase();
            if (Yn.equals("Y")) {
                menuAddProduct();
                
            } else {
                showMenuAdmin();              
            }
        } else {
            System.out.println("[Produkt nie został dodany]");
            showMenuAdmin();
        }
    }

    public void menuUpdatePrice() {
        System.out.println("Okej będziemy aktualizować cene!");
        System.out.println("1. Wyszukaj produkt po tytule");
        System.out.println("2. Wyszukaj produkt po id");
        int x = scan.nextInt();
        scan.nextLine();
        switch (x) {
            case 1: {
                System.out.println("Podaj tytuł gry");
                String title = scan.nextLine();
                System.out.println("Aktualizujemy cenę dla: " + productDAO.showInfo(title)); 
                System.out.println("Podaj nową cene: ");
                double newPrice = scan.nextDouble();
                scan.nextLine();

                System.out.println("Stara cena to: " + productDAO.price + ", nowa cena to: " + newPrice
                        + ", czy chcesz zaakceptować nową cene?");
                System.out.print("Y/n: ");
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    productDAO.updatePrice(title, newPrice);
                    System.out.println(productDAO.showInfo(title));
                    System.out.println("Cena została zaktualizowana");
                    System.out.println("Czy chcesz zaktualizować kolejną cene?");
                    System.out.print("Y/n: ");
                    String Yn = scan.nextLine().toUpperCase();
                    if (Yn.equals("Y")) {
                        menuUpdatePrice();
                    } else
                        showMenuAdmin();
                } else {
                    System.out.println("[Cena nie została zaktualizowana]");
                    showMenuAdmin();
                }
            }
                break;
            case 2: {
                System.out.println("Podaj ID gry");
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Aktualizujemy cenę dla: " + productDAO.showInfo(id));                                                                                   
                System.out.println("Podaj nową cene: ");
                double newPrice = scan.nextDouble();
                System.out.println("Stara cena to: " + productDAO.price + ", nowa cena to: " + newPrice
                        + ", czy chcesz zaakceptować nową cene?");
                System.out.print("Y/n: ");
                scan.nextLine();
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    productDAO.updatePrice(id, newPrice);
                    System.out.println(productDAO.showInfo(id));
                    System.out.println("Cena została zaktualizowana");
                    System.out.println("Czy chcesz zaktualizować kolejną cene?");
                    System.out.print("Y/n: ");
                    String Yn = scan.nextLine().toUpperCase();
                    if (Yn.equals("Y")) {
                        menuUpdatePrice();
                    } else
                        showMenuAdmin();
                } else {
                    System.out.println("[Cena nie została zaktualizowana]");
                    showMenuAdmin();
                }
                break;
            }
        }
    }

    public void menuHideProduct() {
        System.out.println("Okej będziemy ukrywać produkt!");
        System.out.println("1. Wyszukaj produkt po tytule");
        System.out.println("2. Wyszukaj produkt po ID");
        int x = scan.nextInt();
        scan.nextLine();
        switch (x) {
            case 1: {
                System.out.println("Podaj tytuł gry");
                String title = scan.nextLine();
                System.out.println("Ukrywamy produkt: " + title);
                System.out.println("Nic sie nie dzieje, nie wiem o co chodzi z chowaniem");
                break;
            }
            case 2: {
                System.out.println("Podaj ID produktu ");
                int id = scan.nextInt();
                System.out.println("Ukrywamy produkt o ID: " + id);
                System.out.println("Nic sie nie dzieje, nie wiem o co chodzi z chowaniem");
                break;
            }
        }
    }

    public void menuRemoveProduct() {
        System.out.println("Okej będziemy usuwamy produkt!");
        System.out.println("1. Wyszukaj produkt po tytule");
        System.out.println("2. Wyszukaj produkt po ID");
        int x = scan.nextInt();
        scan.nextLine();
        switch (x) {
            case 1: {
                System.out.println("Podaj tytuł gry");
                String title = scan.nextLine();
                System.out.println("Chcesz usunąć: " + productDAO.showInfo(title));
                System.out.print("Y/n: ");
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    productDAO.removeProduct(title);
                    // user.showInfo(title);
                    System.out.println("Produkt został usunięty");
                    System.out.println("Czy chcesz usunąć kolejny produkt?");
                    System.out.println("Y/n: ");
                    String Yn = scan.nextLine().toUpperCase();
                    if (Yn.equals("Y")) {
                        menuRemoveProduct();
                    } else
                        showMenuAdmin();
                } else {
                    System.out.println("[Produkt nie został usunięty]");
                    showMenuAdmin();
                }
                break;
            }
            case 2: {
                System.out.println("Podaj ID produktu ");
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Chcesz usunąć: " + productDAO.showInfo(id));
                System.out.print("Y/n: ");
                String choice = scan.nextLine().toUpperCase();
                if (choice.equals("Y")) {
                    productDAO.removeProduct(id);
                    productDAO.showInfo(id);
                    System.out.println("Produkt został usunięty");
                    System.out.println("Czy chcesz usunąć kolejny produkt?");
                    System.out.print("Y/n: ");
                    String Yn = scan.nextLine().toUpperCase();
                    if (Yn.equals("Y")) {
                        menuRemoveProduct();
                    } else
                        showMenuAdmin();
                } else {
                    System.out.println("[Produkt nie został usunięty]");
                    showMenuAdmin();
                }
                break;
            }
        }
    }

    public void menuSortAplh() {
        System.out.println("Posortowane produkty:");
        productDAO.sortAlph();
        System.out.println("");
        showMenuAdmin();
    }

    public void guestSearchForGame() {
        System.out.println("Podaj tytuł:");
        String title = scan.nextLine();
        System.out.println("Wyszukałeś produkt: " + title);
        productDAO.searchForGame(title);
        System.out.println("1. Dodaj do koszyka"); // brak funkcjonalności
        System.out.println("2. Cofnij"); // brak funkcjonalności
        scan.nextLine();

    }

    public void guestSearchForCategory() {
        System.out.println("Podaj kategorię:");
        String category = scan.nextLine();
        System.out.println("Wyszukałeś kategorię: " + category);
        productDAO.searchForCategory(category);
        System.out.println("1. Dodaj do koszyka"); // brak funkcjonalności
        System.out.println("2. Cofnij"); // brak funkcjonalnosci
        scan.nextLine();
    }

    public void closeProgram() {
        System.exit(0);
    }
 

}
