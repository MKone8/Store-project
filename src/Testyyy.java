import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class Testyyy {
    
    public static void main(String[]args){
                    
        Scanner scan = new Scanner(System.in);
        
        // String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
        String glowa = "head";
        String ramiona = "shoulders";
        String rece = "hands";

        System.out.println("Podaj maila: ");
        String em = scan.nextLine();
        System.out.println("Podaj hasło: ");
        String psw1 = scan.nextLine();

        String pw_hash = BCrypt.hashpw(psw1, BCrypt.gensalt());
        System.out.println("Powtórz hasło:");
        String psw2 = scan.nextLine();
        
        if (BCrypt.checkpw(psw2, pw_hash)){
            System.out.println(pw_hash);
            System.out.println("Zgodne hasła");
        }else {
            System.out.println("Won");
        }
        scan.close();
    }
}
