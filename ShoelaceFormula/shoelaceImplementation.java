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

    }
}
