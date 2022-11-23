import java.util.Scanner;

public class Testy {
    
    public static void main(String[]args){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Tytuł gry: ");
        String title = scan.nextLine();
        System.out.println("Kategoria produktu: "); // tu powinna rozwijać się lista kategorii do wyboru
        String category = zbieramDane();
        System.out.println(category);

        int i = 5;



        
    }

    
    public static String zbieramDane(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Wybierz nazwe:");
        String costam = scan.nextLine();
        scan.close();
        return costam;
        
}
}