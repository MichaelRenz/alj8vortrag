import java.io.IOException;
import java.util.List;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Application {

    public static void main(String [] args) throws IOException {
        long startTime = 0;
        long estimatedTime = 0;
        long count = 0;
        //        startTime = System.nanoTime();
        //        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Creating list of randomized users");
        List<User> userList = Utils.generateUserList(100);
        System.out.println("Number of random users created = " + userList.size());
        List<Integer> integerList = Utils.generateIntegerList(10);
        System.out.println("Number of random Integers created = " + integerList.size());


        userList.stream().forEach(System.out::println);

        double sum = userList.stream()
            .filter(u -> u.getUserStatus() == UserStatus.ACTIVE)
            .flatMap(u -> u.getCreditNotes().stream())
            .filter(c -> c.getStatus() == CreditNoteStatus.PAID)
            .filter(c -> c.getYear() == 2015)
            .mapToDouble(c -> c.getAmount())
            .sum();
        System.out.println("Sum of all payments for the year 2015 = " + sum);
            //.forEach(c -> System.out.println(c.getAmount()));
/*
        System.out.println("--------------------------------------------------");
        System.out.println("Reduce - Find the oldest person");

        int maxAge = 0;
        User oldestUser = null;
        for(User u : userList) {
            if(u.getAge() > maxAge) {
                maxAge = u.getAge();
                oldestUser = u;
            }
        }
        System.out.println(oldestUser + " - oldsch00l...");

        userList.stream()
                .reduce((u1, u2) -> u1.getAge() > u2.getAge() ? u1 : u2)
                .ifPresent(System.out::print);
        System.out.println(" - with streams...");

        System.out.println("--------------------------------------------------");

        System.out.println("Filter - Filter by age >= 18");

        List<User> usersOfAgeX = new ArrayList<>();
        int usersOfAgeCount = 0;
        int threshold = 18;
        for(User u : userList) {
            if(u.getAge() >= threshold) {
                usersOfAgeX.add(u);
                usersOfAgeCount++;
            }
        }
        System.out.println(usersOfAgeCount + " are 18 years or older. - oldsch00l...");
        System.out.println(usersOfAgeX.size() + " are 18 years or older. - oldsch00l...");

        threshold = 18;
        List<User> usersOfAge = userList.stream()
            .filter(u -> u.getAge() >= 18)
            .collect(Collectors.toList());
        System.out.println(usersOfAge.size() + " are 18 years or older. - with streams...");

        long numUsersOfAge = userList.stream()
                .filter(u -> u.getAge() >= 18)
                .count();
        System.out.println(numUsersOfAge + " are 18 years or older. - with streams...");

        integerList.stream()
                .filter(n -> n % 2!= 0)
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------------------------------------------");
        List<String> firstNamesWithA2 = userList.stream()
                .filter(u -> u.getFirstName().startsWith("A"))
                //.peek(u -> System.out.println("BEFORE MAP: " + u))
                .map(u -> u.getFirstName())
                //.peek(u -> System.out.println("AFTER MAP: " + u))
                .collect(Collectors.toList());
        System.out.println(firstNamesWithA2.size() + " Persons have a first name starting with a. - with streams...");


        System.out.println("--------------------------------------------------");
        System.out.println("Collectors - average age");
        Double averageAge = userList.stream()
                .collect(Collectors.averagingInt(u -> u.getAge()));
        System.out.println(averageAge);

        System.out.println("--------------------------------------------------");
        System.out.println("Collectors - summary stats for age");
        IntSummaryStatistics ageSummary = userList.stream()
                .collect(Collectors.summarizingInt(u -> u.getAge()));
        System.out.println(ageSummary);
*/

    }
}


