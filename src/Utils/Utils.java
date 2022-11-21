package Utils;

import java.util.Calendar;

public class Utils {
    
    public static int getDayNumber() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return day;

    }

    public static boolean ifWeekend() {
        if (getDayNumber() == 6 || getDayNumber() == 1) {
            return true;
        } else{
            return false;
        }
        
    }
}
