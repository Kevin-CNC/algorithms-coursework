package raycastingTest;

public class raycastTest {

    public static boolean isInsidePolygon(point q, point[] polygon) {
        // A polygon needs at least 3 points to form a region
        if (polygon == null || polygon.length < 3) {
            return false;
        }

        int crossings = 0; // Count ray intersections; odd means inside, even means outside
        int pointsNumbers = polygon.length;

        // Cast a horizontal ray to the right from q and count edges
        for (int i = 0; i < pointsNumbers; i++) {
            point startPoint = polygon[i];
            point endPoint = polygon[(i + 1) % pointsNumbers]; // Wrap to close the polygon

            // Half-open interval on y: count an edge only if it straddles the ray
            // This avoids double-counting when the ray passes through a vertex
            boolean straddles = (startPoint.y <= q.y && endPoint.y > q.y) ||
                                (endPoint.y <= q.y && startPoint.y > q.y);

            if (straddles) {
                double xIntersect = startPoint.x + (q.y - startPoint.y) * (endPoint.x - startPoint.x) / (endPoint.y - startPoint.y);

                if (q.x < xIntersect) {
                    crossings++;
                }
            }
        }

        // Odd number of crossings => inside. Even => outside.
        return (crossings % 2) == 1;
    }


    public static void main(String[] args) {
        point[] polygon = {
            new point(0, 0),
            new point(5, 0),
            new point(5, 5),
            new point(0, 5)
        };
        point q = new point(2, 2);
        System.out.println("Point is " + (isInsidePolygon(q, polygon) ? "inside" : "outside") + " the polygon.");
    }
}
