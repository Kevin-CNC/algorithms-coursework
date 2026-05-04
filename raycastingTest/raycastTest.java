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

        // Case 1: Point inside a square
        point[] square1 = {new point(1, 1),new point(4, 4),new point(1, 4),new point(4, 1)};
        point c1OriginPoint = new point(2, 2);
        System.out.println("Case 1: The point is " + (isInsidePolygon(c1OriginPoint, square1) ? "inside" : "outside"));


        // Case 2: Point inside a square
        point[] square2 = {
            new point(1, 1),
            new point(4, 4),
            new point(1, 4),
            new point(4, 1)
        };
        point c2OriginPoint = new point(7, 7);
        System.out.println("Case 2: The point is " + (isInsidePolygon(c2OriginPoint, square2) ? "inside" : "outside"));


        // Case 3: Point on an edge
        point[] square3 = {
            new point(1, 1),
            new point(5, 5),
            new point(5,1),
            new point(1, 5)
        };
        point c3OriginPoint = new point(5, 4);
        System.out.println("Case 3: The point is " + (isInsidePolygon(c3OriginPoint, square3) ? "inside" : "outside"));

         // Case 4: Point in a concave polygon
        point[] polygon4 = {
            new point(3, 5),
            new point(3, 3),
            new point(1,3),
            new point(3, 1),
            new point(5, 1),
            new point(5, 3)
        };
        point c4OriginPoint = new point(2, 2);
        System.out.println("Case 4: The point is " + (isInsidePolygon(c4OriginPoint, polygon4) ? "inside" : "outside"));
    }
}
