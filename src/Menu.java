import java.util.Scanner;

public class Menu extends User {
    public void displayMainMenu (){
    User user = new User();
    
    System.out.println("Witaj w naszym sklepie!");
    System.out.println("----------------------");
    System.out.println("1. Zaloguj się!");
    System.out.println("2. Kontynuuj jako gość");
    System.out.println("9. Wyjdź");
    Scanner sc = new Scanner(System.in);
    int menu_nr = sc.nextInt();
    System.out.println("Wybrana liczba to:"+menu_nr);
    switch(menu_nr){
        case 1:
        Admin admin = new Admin();
        admin.loginVerficiation();
        
        break;
        case 2:
        System.out.println("1. Wyszukaj gre");
        System.out.println("2. Wyszukaj kategorie");
        int x = sc.nextInt();
        switch(x){            
            case 1:        
            user.searchByGame();
            sc.close();
            break;
            case 2:
            user.searchByCategory();
            sc.close();
            break;

        }
        break;
        case 9:
        System.out.println("Ciao bella!");
        sc.close();
        System.exit(0);
    }
}}
