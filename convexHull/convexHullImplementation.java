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

        // use a 'do-while' loop to ensure the leftmost point is added and the loop is ran at LEAST once
        do {
            hullkStack.add(points[currentP]);
            nextP = 0;
            for (int i = 1; i < pointsL; i++) {
                // check if the orientation given is 1 (counter-clockwise) if so, update the nextP to be the current point being checked
                if (nextP == currentP || orientation(points[currentP], points[nextP], points[i]) == 1) {
                    nextP = i;
                }
            }
            currentP = nextP;

        } while (currentP != leftMost);
        return hullkStack;
    }


    public static void main(String[] args) {

        // Case 1: Triangle set
        point c1P1 = new point(0,0);
        point c1P2 = new point(7,0);
        point c1P3 = new point(7,7);
        
        point[] points = {c1P1, c1P2, c1P3};

        List<point> case1Hull = convexHull(points);
        System.out.println("Case 1 Convex Hull:");
        for (point p : case1Hull) {
            System.out.print("(" + p.x + ", " + p.y + ") ");
        }

        
        System.out.println();


        // Case 2: 9-Points set
        point c2P1 = new point(1, 1);
        point c2P2 = new point(8, 2);
        point c2P3 = new point(7, 3);
        point c2P4 = new point(8, 4);
        point c2P5 = new point(5, 5);
        point c2P6 = new point(6, 4);
        point c2P7 = new point(2, 4);
        point c2P8 = new point(3, 3);
        point c2P9 = new point(6, 1);

        point[] points2 = {c2P1, c2P2, c2P3, c2P4, c2P5, c2P6, c2P7, c2P8, c2P9};

        List<point> case2Hull = convexHull(points2);
        System.out.println("Case 2 Convex Hull:");
        for (point p : case2Hull) {
            System.out.print("(" + p.x + ", " + p.y + ") ");
        }
    }

}
