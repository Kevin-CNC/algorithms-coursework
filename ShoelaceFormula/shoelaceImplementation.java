package ShoelaceFormula;

public class shoelaceImplementation {

    // polygonArea calculation method; Takes in an array of points denominated `vertices` assuming they are in order. Performs the shoelace formula
    public static double polygonArea(point[] vertices) {
        double resultArea = 0; // Double value where the resulting area will be stored
        int stepVertice = 0; // Track the position of current point being targeted

        for (point vertice : vertices) {
            int targetIndex = (stepVertice+1) % vertices.length; // Ensures that the last point is multiplied with the first point in order to make the formula achievable.
            
            point targetVertice = vertices[targetIndex];

            // Calculate the current step's Main & counter diagonal counterparts, subtract from each other
            // then add it to `resultArea` in order to not loop again to calculate the counter diagonals. 
            double mainDiagonal = vertice.x * targetVertice.y;
            double counterDiagonal = targetVertice.x * vertice.y;

            resultArea += (mainDiagonal - counterDiagonal);

            stepVertice += 1;
        }
        return Math.abs(resultArea) / 2;
    }

    public static void main(String[] args) {

        // Case 1: Right angle with a known area of 7.5 units squared.
        // 7.5 = (3*5) / 2
        point c1_P1 = new point(1, 1);
        point c1_P2 = new point(1, 6);
        point c1_P3 = new point(4, 1);
        point[] c1_Vertices = {c1_P1, c1_P2, c1_P3};

        System.out.println("Area of Case 1: " + polygonArea(c1_Vertices));


        // Case 2: Unit Square with a known area of 9 units squared.
        // 3*3 = 9
        point c2_P1 = new point(0, 0);
        point c2_P2 = new point(1, 0);
        point c2_P3 = new point(1, 1);
        point c2_P4 = new point(0, 1);
        point[] c2_Vertices = {c2_P1, c2_P2, c2_P3, c2_P4};

        System.out.println("Area of Case 2: " + polygonArea(c2_Vertices));


        // Case 3: Irregular polygon.
        // Following the forumula (1*2 + 2*3 + 4*3 + 0 + 0 + 1) - (2*1 + 4*2 + 5*3 + 5*3 + 0 + 0) = 11 - 29 = -18 => 18/2 = 9 units squared.
        point c3_P1 = new point(1, 1);
        point c3_P2 = new point(2, 2);
        point c3_P3 = new point(4, 3);
        point c3_P4 = new point(5, 3);
        point c3_P5 = new point(5, 0);
        point c3_P6 = new point(1, 0);
        point[] c3_Vertices = {c3_P1, c3_P2, c3_P3, c3_P4, c3_P5, c3_P6};

        System.out.println("Area of Case 3: " + polygonArea(c3_Vertices));
    }
}
