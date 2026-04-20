package orientationTest;

import orientationTest.point;

public class orientationTest{
    // Method to find the cross product of  3  points
    public static int orientation(point A, point B, point C){
        // follows the formula provided by the coursework file for the 'cross product'
        return( (B.x-A.x)*(C.y-A.y) - (B.y-A.y)*(C.x-A.x) ); 
    }
    
    public static void main(String[] args){
        // Case 1: Counter Clockwise
        // scenario: a line from the origin (0,0) going towards the negative X axis 
        point c1_A = new point(0, 0);
        point c1_B = new point(0, 1);
        point c1_C = new point(-3, 2);

        System.out.println("Case 1: " + orientation(c1_A, c1_B, c1_C));

        // Case 2: Clockwise
        // scenario: a line from the origin (0,0) going towards the positive X axis 
        point c2_A = new point(0, 0);
        point c2_B = new point(1, 1);
        point c2_C = new point(2, 4);

        System.out.println("Case 2: " + orientation(c2_A, c2_B, c2_C));

        // Case 3: Collinear
        // scenario: all points are in a diagonal line, without any shift in trajectory
        point c3_A = new point(1, 1);
        point c3_B = new point(2, 2);
        point c3_C = new point(3, 3);

        System.out.println("Case 3: " + orientation(c3_A, c3_B, c3_C));

        // Case 3: Experiment with jagged line
        // scenario: all points are scattered at different points of the carthesian plane
        point c4_A = new point(1, 4);
        point c4_B = new point(-6, 7);
        point c4_C = new point(4, -5);

        System.out.println("Case 4: " + orientation(c4_A, c4_B, c4_C));

    }
}