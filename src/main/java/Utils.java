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
}
