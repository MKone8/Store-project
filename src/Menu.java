import java.util.Scanner;

public class Menu {
    public void display (){

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
        
        System.out.println("Podaj login: ");
        String login = sc.next();             
        System.out.println("Podaj hasło: "+sc.nextLine());
        String password = sc.next();
        
        break;
        case 2:
        System.out.println("Przejdzie do opcji wyszukiwania");
        break;
        case 9:
        System.out.println("Ciao bella!");
        sc.close();
        System.exit(0);
    }
}}
