import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Application {




    public static void main(String [] args) throws IOException {

        List<User> USER_LIST = Utils.generateUserList(25);

        System.out.println("---------- ALL USERS -------------------");
        USER_LIST.stream().forEach(u -> System.out.println(u));

        System.out.println("----------- FILTERED BY STATUS --------------------");
        USER_LIST.stream()
            .filter(u -> u.getUserStatus() == UserStatus.ACTIVE)
            .forEach(u -> System.out.println(u));

        System.out.println("----------- FILTERED /w PREDICATE (reusable) --------------------");
        // using predicate
        Predicate<User> simplePredicate = u -> u.getUserStatus() == UserStatus.ACTIVE;
        USER_LIST.stream()
                .filter(simplePredicate)
                .forEach(u -> System.out.println(u));




        Consumer<User> changeStatus = u -> {
            if (u.getUserStatus() == UserStatus.REJECTED) {
                u.setUserStatus(UserStatus.SUPERUSER);
            }
            System.out.println(u);
        };


        USER_LIST.stream().forEach(changeStatus);

    }
}
