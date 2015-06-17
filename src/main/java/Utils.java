import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Utils {
    public static List<User> generateUserList(int num) {
        List<User> userList = new ArrayList<User>();
        for(int i=0; i< num; i++) {
            User u = new User();
            userList.add(u);
            //System.out.println(u);
        }
        return userList;
    }
    public static List<Integer> generateIntegerList(int num) {
        List<Integer> integerList = new ArrayList<Integer>();
        int n = 0;
        for (int i = 0; i < num; i++) {
            n = (int) (Math.random()*999999);
            integerList.add(n);
            //System.out.println(u);
        }
        return integerList;
    }

    public static int mapTimeInMillisToYears(long timeInMs) {
        int years = 0;
        return years;
    }
}
