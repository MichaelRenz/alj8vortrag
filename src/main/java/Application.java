import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by elshotodore on 09.06.2015.
 */
public class Application {

    public static void main(String [] args) throws IOException {
        long startTime = 0;
        long estimatedTime = 0;
        long count = 0;
        //        startTime = System.nanoTime();
        //        estimatedTime = System.nanoTime() - startTime;
        System.out.print("Creating list of randomized users...........");
        List<User> userList = Utils.generateUserList(50);
        System.out.println("Number of random users created = " + userList.size() + ".");

        System.out.print("Creating list of random integers............");
        List<Integer> integerList = Utils.generateIntegerList(10);
        System.out.println("Number of random Integers created = " + integerList.size() + ".");

        System.out.println("--------------------------------------------------------------------------------------------------");
        // filter(), count(), collect()
        final int threshold = 18;
        List<User> usersOfAge = new ArrayList<>();
        long usersOfAgeCount = 0;

        System.out.println("Determine users of age (" + threshold + ")");

        for(User u : userList) {
            if(u.getAge() >= threshold) {
                usersOfAge.add(u);
                usersOfAgeCount++;
            }
        }
        System.out.println("oldsch00l count:      " + usersOfAgeCount);
        System.out.println("oldsch00l list:       " + usersOfAge.size());

        usersOfAgeCount = userList.stream()
                .filter(u -> u.getAge() >= threshold)
                .count();
        System.out.println("filter() + count():   " + usersOfAgeCount);


        usersOfAge = userList.stream()
                .filter(u -> u.getAge() >= threshold)
                .collect(Collectors.toList());
        System.out.println("filter() + collect(): " + usersOfAge.size());

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("filter for active users, age > 33, first name starts with A, last name starts with T");
        userList = Utils.generateUserList(5000);
        //List<User> resultList =
         userList.stream()
        .filter(u -> u.getUserStatus() == UserStatus.ACTIVE)
        .filter(u -> u.getAge() > 33)
        .filter(u -> (u.getFirstName().startsWith("A") && u.getLastName().startsWith("T")))
        .forEach(u -> System.out.println(u));
        //.collect(Collectors.toList());
        //System.out.println(resultList.get(0));

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("average age");
        Double averageAge = userList.stream()
                .collect(Collectors.averagingInt(u -> u.getAge()));
        System.out.println("Average age: " + averageAge);

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("age stats");
        IntSummaryStatistics ageSummary = userList.stream()
                .collect(Collectors.summarizingInt(u -> u.getAge()));
        System.out.println("Age summary statistic: " + ageSummary);

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("filter(), sorted(), map(), collect()/join to build a phrase");

        userList = Utils.generateUserList(10);
        String phrase = userList
            .parallelStream()
            .filter(u -> u.getAge() >= 18)
            //.sorted((u1, u2) -> u1.getAge() - u2.getAge())
            .sorted((u1,u2) -> u1.getFirstName().compareToIgnoreCase(u2.getFirstName()))
            .map(u -> u.getFirstName() + " (" + u.getAge() + ")")
            .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(phrase);

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("filter(), flatMap() and calculate the sum of all payments for a specific year");
        userList = Utils.generateUserList(500);
        double sum = userList.stream()
                .filter(u -> u.getUserStatus() == UserStatus.ACTIVE)
                .flatMap(u -> u.getCreditNotes().stream())
                .filter(c -> c.getStatus() == CreditNoteStatus.PAID)
                .filter(c -> c.getYear() == 2015)
                .mapToDouble(c -> c.getAmount())
                .sum();
        System.out.println("Sum of all payments for the year 2015 = " + sum);



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


