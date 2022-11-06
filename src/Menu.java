import java.util.Scanner;

public class Menu {
    
    
    public static void main (String []args){

        
        userFunction user = new userFunction();
        

        Scanner scan = new Scanner(System.in);
        System.out.println("1. Zaloguj się");
        System.out.println("2. Kontynuuj jako gość");
        System.out.println("9. Wyjdź");
        int mainMenu_nr = scan.nextInt();
        scan.nextLine();
        
        switch(mainMenu_nr){
            case 1: 
            System.out.println("Podaj email: ");
            String email = scan.nextLine();
            System.out.println("Podaj hasło: ");
            String password = scan.nextLine();
            
            if (!user.loginVer(email,password)){
                System.out.println("Witamy na pokładzie");
                
                System.out.println("1. Dodaj nową gre");
                System.out.println("2. Zaktualizuj cene");
                System.out.println("3. Ukryj produkt");
                System.out.println("4. Usuń produkt");
                System.out.println("5. Wyświetl alfabetycznie");
                int adminMenu_nr = scan.nextInt();
                scan.nextLine();
                switch(adminMenu_nr){
                    case 1:
                    
                    {    
                    System.out.println("Okej, dodajemy nową gre!");                   
                    System.out.println("Tytuł gry: ");
                    String title = scan.nextLine();
                    System.out.println("Kategoria produktu: ");
                    String category = scan.nextLine();
                    System.out.println("Podaj cenę: ");
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Potwierdź, że chcesz dodać produkt: "+title+" z kategorią: "+category+" oraz ceną: "+newPrice);
                    System.out.print("Y/n: ");
                    String choice = scan.nextLine().toUpperCase();
                        if(choice.equals("Y")){
                            user.addProduct(title,category,newPrice);
                            System.out.println(user.showInfo(title));                        
                            System.out.println("Czy chcesz dodać kolejny produkt?");
                            System.out.print("Y/n");
                            String Yn = scan.nextLine().toUpperCase();
                            if(Yn.equals("Y")){
                                System.out.println("Tu załaduje się case 1:"); // to czeka na opakowanie
                            }else {
                                System.out.println("Żegnam.");
                                System.exit(0);
                            } // zamyka program i tak
                        }else System.out.println("Produkt nie został dodany");  
                                 
                     
                    }
                    break;
                    case 2:
                    {
                    System.out.println("Okej będziemy aktualizować cene!");
                    System.out.println("1. Wyszukaj produkt po tytule");
                    System.out.println("2. Wyszukaj produkt po id");
                    int x = scan.nextInt();
                    scan.nextLine();
                    switch(x){
                        case 1: {
                        System.out.println("Podaj tytuł gry");
                        String title = scan.nextLine();
                        System.out.println("Aktualizujemy cenę dla: "+user.showInfo(title)); // <-- działa 
                        System.out.println("Podaj nową cene: ");
                        double newPrice = scan.nextDouble();
                        scan.nextLine();
                        
                        System.out.println("Stara cena to: "+user.gamePrice+", nowa cena to: "+newPrice+", czy chcesz zaakceptować nową cene?");
                        System.out.print("Y/n: ");
                        String choice = scan.nextLine().toUpperCase();                     
                        if(choice.equals("Y")){
                            user.updatePrice(title,newPrice);
                            System.out.println(user.showInfo(title));                         
                            System.out.println("Cena została zaktualizowana");
                            System.out.println("Czy chcesz zaktualizować kolejną cene?");
                            System.out.print("Y/n: ");
                            String Yn = scan.nextLine().toUpperCase();                      
                            if(Yn.equals("Y")){
                                System.out.println("Tu załaduje się case 1:");
                            }else System.out.println("Tu zakończy się program."); 
                        }else System.out.println("Cena nie została zaktualizowana");  
                        break;
                        }
                        case 2: {
                            System.out.println("Podaj ID gry");
                            int id = scan.nextInt(); 
                            scan.nextLine();               
                            System.out.println("Aktualizujemy cenę dla: "+user.showInfo(id)); // tutaj zapytanie Portal / Kategoria / Cena
                            System.out.println("Podaj nową cene: ");
                            double newPrice = scan.nextDouble();                         
                            System.out.println("Stara cena to"+user.gamePrice+", nowa cena to: "+newPrice+", czy chcesz zaakceptować nową cene?");
                            System.out.print("Y/n: ");                        
                            scan.nextLine();
                        String choice = scan.nextLine().toUpperCase();                        
                        if(choice.equals("Y")){
                            user.updatePrice(id,newPrice);
                            System.out.println(user.showInfo(id));
                            System.out.println("Cena została zaktualizowana");
                            System.out.println("Czy chcesz zaktualizować kolejną cene?");
                            System.out.print("Y/n: ");
                            String Yn = scan.nextLine().toUpperCase();                           
                            if(Yn.equals("Y")){
                                System.out.println("Tu załaduje się case 1:");
                            }else System.out.println("Tu zakończy się program."); 
                        }else System.out.println("Cena nie została zaktualizowana");         
                        break;
                        }             
                    }
                    }
                    break;
                    case 3:{
                    System.out.println("Okej będziemy ukrywać produkt!");
                    System.out.println("1. Wyszukaj produkt po tytule");
                    System.out.println("2. Wyszukaj produkt po ID");
                    int x = scan.nextInt();
                    scan.nextLine();
                    switch(x){
                        case 1: {
                        System.out.println("Podaj tytuł gry");
                        String title = scan.nextLine();
                        System.out.println("Ukrywamy produkt: "+title);
                        System.out.println("Nic sie nie dzieje, nie wiem o co chodzi z chowaniem");
                        break; 
                        }
                        case 2: {
                        System.out.println("Podaj ID produktu ");
                        int id = scan.nextInt();
                        System.out.println("Ukrywamy produkt o ID: "+id); 
                        System.out.println("Nic sie nie dzieje, nie wiem o co chodzi z chowaniem");
                        break; 
                        }
                    }
                    }
                    break;
                    case 4:{                   
                    System.out.println("Okej będziemy usuwamy produkt!");
                    System.out.println("1. Wyszukaj produkt po tytule");
                    System.out.println("2. Wyszukaj produkt po ID");
                    int x = scan.nextInt();
                    scan.nextLine();
                    switch(x){
                        case 1: {
                        System.out.println("Podaj tytuł gry");
                        String title = scan.nextLine();
                        System.out.println("Chcesz usunąć: "+user.showInfo(title));
                        System.out.print("Y/n: ");
                        String choice = scan.nextLine().toUpperCase();                        
                        if(choice.equals("Y")){
                            user.removeProduct(title);
                            // user.showInfo(title);
                            System.out.println("Produkt został usunięty");
                            System.out.println("Czy chcesz usunąć kolejny produkt?");
                            System.out.println("Y/n: ");
                            String Yn = scan.nextLine().toUpperCase();                           
                            if(Yn.equals("Y")){
                                System.out.println("Tu załaduje się case 1:");
                            }else System.out.println("Tu zakończy się program."); 
                        }else System.out.println("Produkt nie został usunięty"); 
                        break; }
                        case 2: {
                        System.out.println("Podaj ID produktu ");
                        int id = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Chcesz usunąć: "+user.showInfo(id));
                        System.out.print("Y/n: "); 
                        String choice = scan.nextLine().toUpperCase();                        
                        if(choice.equals("Y")){
                            user.removeProduct(id);
                            user.showInfo(id);
                            System.out.println("Produkt został usunięty");
                            System.out.println("Czy chcesz usunąć kolejny produkt?");
                            System.out.print("Y/n: ");
                            String Yn = scan.nextLine().toUpperCase();                           
                            if(Yn.equals("Y")){
                                System.out.println("Tu załaduje się case 1:");
                            }else System.out.println("Tu zakończy się program."); 
                        }else System.out.println("Produkt nie został usunięty"); 
                        break;
                    }
                    }
                    }
                    break;
                    case 5:{
                        System.out.println("Posortowane produkty:");
                        user.sortAlph();
                    }break;

                }
                
            } else { 
                System.out.println("Hasło jest nieprawidłowe");
            }        
            break;
            case 2:{
            System.out.println("Witaj gościu!");
            System.out.println("1. Wyszukaj grę");
            System.out.println("2. Wyszukaj kategorie");
            int x = scan.nextInt();
            scan.nextLine();
            switch(x){
                case 1:{
                    System.out.println("Podaj tytuł:");
                    String title = scan.nextLine();
                    System.out.println("Wyszukałeś produkt: "+title);
                    user.searchForGame(title);
                    System.out.println("1. Dodaj do koszyka"); // brak funkcjonalności
                    System.out.println("2. Cofnij"); // brak funkcjonalności
                break;
                }
                case 2:{
                    System.out.println("Podaj kategorię:");
                    String category = scan.nextLine();
                    System.out.println("Wyszukałeś kategorię: "+category);
                    user.searchForCategory(category);
                    System.out.println("1. Dodaj do koszyka"); // brak funkcjonalności
                    System.out.println("2. Cofnij"); // brak funkcjonalnosci
                break;
                }
            } 
            break;
        }
            case 9:{
            System.out.println("Won stąd");
            System.exit(0);

            break;
            }
        }
        scan.close();
        

        }
}

