import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank.vogel on 09.06.2015.
 */
public class Utils {
    public static List<Point> generatePointList() {
        List<Point> pointList = new ArrayList<Point>();
        int max = 3;
        int x = 0;
        int y = 0;
        for(x = -max; x < max; x++) {
            for(y = -max; y < max; y++) {
                pointList.add(new Point(x, y));
            }
        }
/*
        pointList.add(new Point(1,1));
        pointList.add(new Point(2,2));
        pointList.add(new Point(3,3));
        pointList.add(new Point(1,-1));
        pointList.add(new Point(2,-2));
        pointList.add(new Point(3,-3));
        pointList.add(new Point(-1,-1));
        pointList.add(new Point(-2,-2));
        pointList.add(new Point(-3,-3));
        pointList.add(new Point(-1,1));
        pointList.add(new Point(-2,2));
        pointList.add(new Point(-3,3));
*/
        return pointList;
    }

    public static void keyPress() throws IOException {
        System.out.println("\n\n" +
                "KEY?");
        System.in.read();
    }
}
