import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Utils {
    private static int[] years = {2000,2001,2002,2003,2004,2005,2006,2007,2007,2008,2009,2010,2011,2012,2013,2014,2015};

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

    public static List<CreditNote> generateCreditNotes(int num) {
        List<CreditNote> creditNoteList = new ArrayList<>();
        for(int i = 0; i < num; i++) {

            CreditNote c = new CreditNote();
            c.setYear(years[(int) ((Math.random()) * years.length)]);
            c.setAmount(Math.random()*10000);
            c.setStatus(CreditNoteStatus.values()[(int) ((Math.random()) * CreditNoteStatus.values().length)]);
            creditNoteList.add(c);
        }
        return creditNoteList;
    }
}
