import java.util.Scanner;

public class Menu extends User {
    // public void displayMainMenu (){
    
    
    // // System.out.println("Witaj w naszym sklepie!");
    // // System.out.println("----------------------");
    // // System.out.println("1. Zaloguj się!");
    // // System.out.println("2. Kontynuuj jako gość");
    // // System.out.println("9. Wyjdź");



    // // Scanner sc = new Scanner(System.in);
    // // int menu_nr = sc.nextInt();
    // // System.out.println("Wybrana liczba to:"+menu_nr);
    // // switch(menu_nr){
    // //     case 1:
    // //     Admin admin = new Admin();
    // //     admin.loginVerficiation();
        
    // //     break;
    // //     case 2:
    // //     System.out.println("1. Wyszukaj gre");
    // //     System.out.println("2. Wyszukaj kategorie");
    // //     int x = sc.nextInt();
    // //     switch(x){            
    // //         case 1:        
    // //         user.searchByGame();
    // //         sc.close();
    // //         break;
    // //         case 2:
    // //         user.searchByCategory();
    // //         sc.close();
    // //         break;
    // //     }
    // //     break;
    // //     case 9:
    // //     System.out.println("Ciao bella!");
    // //     sc.close();
    // //     System.exit(0);
    // }

    public void mainMenu(){
        System.out.println("Witaj w naszym sklepie!");
        System.out.println("----------------------");
        System.out.println("1. Zaloguj się!");
        System.out.println("2. Kontynuuj jako gość");
        System.out.println("9. Wyjdź");
        mainMenuChoice();
}

    public void mainMenuChoice(){
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);
        int menu_nr = sc.nextInt();
        switch(menu_nr){           
            case 1: 
            admin.loginVerficiation();
            sc.close();
            break;
            case 2: bothMenuOptions();
            sc.close();
            break;
            case 9: 
            System.out.println("Żegnaj");
            System.exit(0);
        }
    }

    public void adminMenu(){
       
        System.out.println("1. Dodaj produkt!");
        System.out.println("2. Zaktualizuj cenę");
        System.out.println("3. Ukryj produkt");
        System.out.println("4. Usuń produkt");
        System.out.println("5. Wyświetl alfabetycznie");
        System.out.println("9. Wyjdź");
        adminMenuChoice();

    }
    public void adminMenuChoice(){
        Admin admin = new Admin();
        Scanner sc = new Scanner(System.in);
        int menu_nr = sc.nextInt();
            switch(menu_nr){
            case 1:
            bothMenuOptions(); 
            admin.addProduct();
            sc.close();
            break;
            case 2:
            bothMenuOptions(); 
            // admin.updateProduct();
            sc.close();
            break;
            case 3: 
            bothMenuOptions(); 
            // admin.hideProduct();
            sc.close();
            break;
            case 4:
            bothMenuOptions(); 
            admin.removeProduct();
            sc.close();
            break;
            case 5:
            admin.sortAlph();
            sc.close();
            break;
            default: System.out.println("Podaj prawidłową nazwę");
            adminMenuChoice();
            sc.close();
            break;
    }}

    public void bothMenuOptions(){
        System.out.println("1. Wyszukaj po tytule");
        System.out.println("2. Wyszukaj po kategorii");
        System.out.println("9. Wyjdź");
        bothSearchBy();        
    }

    public void bothSearchBy(){
        User admin = new User();
        Scanner sc = new Scanner(System.in);
        int menu_nr = sc.nextInt();
        switch(menu_nr){
            case 1:
            admin.searchByCategory();
            sc.close();
            break;
        
            case 2:
            admin.searchByGame();
            sc.close();
            break;
        }
    }

}


    
    