import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Application {

    private static final List<Point> POINT_LIST = Utils.generatePointList();

    public static void main(String [] args) throws IOException {

        // original
        System.out.println("\n\n------------------------------------------------");
        System.out.println("The original point list:");
        System.out.println("------------------------------------------------");
        POINT_LIST.stream()
                .forEach(p -> System.out.print(p + " -- "));
        Utils.keyPress();

        // filtered by x > 0
        System.out.println("\n\n------------------------------------------------");
        System.out.println("Filter for Points with positive x coordinate");
        System.out.println("------------------------------------------------");
        POINT_LIST.stream()
                .filter(p -> p.getX() > 0)
                .forEach(p -> System.out.print(p + " -- "));
        Utils.keyPress();

        // count all non white-space chars in text (from file)
        countNonSpaceCharacters();
        System.out.println("BLUB");
    }

    private static void countNonSpaceCharacters() {
        try (BufferedReader in = new BufferedReader(new FileReader("text.txt"))){
            long cnt = in.lines()
                    .flatMapToInt(String::chars)
                    .filter(((IntPredicate)Character::isSpaceChar).negate())
                    .count();
            System.out.println("Number of non-white-space chars: " + cnt);
        } catch (IOException | UncheckedIOException e) {
            e.printStackTrace();
        }
    }
}
