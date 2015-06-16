import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Application {

    public static void main(String [] args) throws IOException {
        long startTime = 0;
        long estimatedTime = 0;

        System.out.println("---------- INTEGERS -------------------");
        List<Integer> INTEGER_LIST = Utils.generateIntegerList(10_000_000);
        startTime = System.nanoTime();
        long n = INTEGER_LIST.stream()
                .filter(i -> i > 50000)
                .count();
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("found: " + n + " ints > 50000.");
        System.out.println("processing took: " + estimatedTime + " ns.");

        startTime = System.nanoTime();
        n = INTEGER_LIST.stream()
                .parallel()
                .filter(i -> i > 50000)
                .count();
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("found: " + n + " ints > 50000.");
        System.out.println("processing took: " + estimatedTime + " ns.");

        System.exit(13);

        List<User> USER_LIST = Utils.generateUserList(50000);


        System.out.println("---------- TOTAL USERS -------------------");
        System.out.println("count = " + USER_LIST.size());

        System.out.println("----------- FILTERED BY STATUS --------------------");
        startTime = System.nanoTime();

        n = USER_LIST.stream()
            .filter(u -> u.getUserStatus() == UserStatus.ACTIVE)
            .count();
            //.forEach(u -> System.out.println(u));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("found: " + n + " users with status active.");
        System.out.println("processing took: " + estimatedTime + " ns.");

        System.out.println("----------- FILTERED BY STATUS (PARALLEL) --------------------");
        startTime = System.nanoTime();
        n = USER_LIST.stream()
            .parallel()
            .filter(u -> u.getUserStatus() == UserStatus.ACTIVE)
            .count();
            //.forEach(u -> System.out.println(u));
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("found: " + n + " users with status active.");
        System.out.println("processing took: " + estimatedTime + " ns.");

        System.out.println("----------- FILTERED /w PREDICATE (reusable) --------------------");
        // using predicate
        Predicate<User> simplePredicate = u -> u.getUserStatus() == UserStatus.ACTIVE;
        USER_LIST.stream()
                .filter(simplePredicate)
                .count();
                //.forEach(u -> System.out.println(u));




        Consumer<User> changeStatus = u -> {
            if (u.getUserStatus() == UserStatus.REJECTED) {
                u.setUserStatus(UserStatus.SUPERUSER);
            }
           // System.out.println(u);
        };


        USER_LIST.stream().forEach(changeStatus);

    }
}
