import org.mindrot.jbcrypt.BCrypt;

public class BCryptExample {
    public static void main(String[] args) throws Exception {
        String plain_password = "admin";
        String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt(12));

        if (BCrypt.checkpw("admin1", pw_hash)){
            System.out.println("It matches");
        }else{
            System.out.println("It does not match");
        }
    }
}
