package convexHull;
import java.util.ArrayList;
import java.util.List;

public class convexHullImplementation {
    // Orientation method ported directly from the first case of the coursework
    public static int orientation(point A, point B, point C){
        // follows the formula provided by the coursework file for the 'cross product'
        double res = ( (B.x-A.x)*(C.y-A.y) - (B.y-A.y)*(C.x-A.x) );
        
        if (res > 0){
            return 1; // Return positive 1 if counter-clockwise
        } else if (res < 0){
            return -1; // Return negative 1 if clockwise
        } else {
            return 0; // Return 0 if collinear
        }
    }


    public static List<point> convexHull(point[] points) {
        int pointsL = points.length;
        List<point> hullkStack = new ArrayList<>();


        // find the leftmost point with a for loop, store its' index in `leftMost`
        int leftMost = 0;
        for (int i = 1; i < pointsL; i++) {
            // compare current leftMost point (defaults at 0) with each point, lowest x value becomes the new leftMost
            if (points[i].x < points[leftMost].x) {
                leftMost = i;
            }
        }
        int currentP = leftMost;
        int nextP;

        while (currentP != leftMost){
            hullkStack.add(points[currentP]);
            // using the `orientation` method we find the most counter-clockwise point from current
            nextP = 0; // default start with 0
            for (int i = 1; i < pointsL; i++) {
                // If orientation returns 1, points[i] is counter-clockwise of the line from currentP, so we add it to the stack
                // always check that the current point is not the same as the chosen 'next'
                if (nextP == currentP ||
                    orientation(points[currentP], points[nextP], points[i]) == 1) {
                    nextP = i;
                }
            }
            currentP = nextP; // advance to the next hull vertex
        }
        return hullkStack;
    }

}
