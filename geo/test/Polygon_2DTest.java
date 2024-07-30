package ex2.geo.test;

import ex2.geo.Point_2D;
import ex2.geo.Polygon_2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Polygon_2DTest {
    /**
     * Test class for Polygon_2D.
     */
    private Point_2D p1 = new Point_2D(0, 0);
    private Point_2D p2 = new Point_2D(3, 4);
    private Point_2D p3 = new Point_2D(6, 8);


    @Test
    /**
     * Tests the contains method for a point inside the polygon.
     */
    void contains() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(p1);
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        Assertions.assertTrue(polygon.contains(p2));
        Assertions.assertFalse(polygon.contains(p3));
    }
    /**
     * Tests the area calculation of the polygon.
     */
    @Test
    void area() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

        Assertions.assertEquals(25, polygon.area());
    }
    /**
     * Tests the perimeter calculation of the polygon.
     */
    @Test
    void perimeter() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

        Assertions.assertEquals(20, polygon.perimeter());
    }
    /**
     * Tests the translation of the polygon.
     */
    @Test
    void translate() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

        polygon.translate(new Point_2D(1, 1));
        Point_2D[] points = polygon.getAllPoints();
        Assertions.assertEquals(new Point_2D(1, 1), points[0]);
        Assertions.assertEquals(new Point_2D(1, 6), points[1]);
        Assertions.assertEquals(new Point_2D(6, 6), points[2]);
    }
    /**
     * Tests the copying of the polygon.
     */
    @Test
    void copy(){
    Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

    Polygon_2D copy = (Polygon_2D) polygon.copy();
    Point_2D[] originalPoints = polygon.getAllPoints();
    Point_2D[] copyPoints = copy.getAllPoints();
        for (int i = 0; i < originalPoints.length; i++) {
            Assertions.assertEquals(originalPoints[i], copyPoints[i]);}
    }
    /**
     * Tests the scaling of the polygon.
     */
    @Test
    void scale() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

        polygon.scale(new Point_2D(0, 0), 2);
        Point_2D[] points = polygon.getAllPoints();
        Assertions.assertEquals(new Point_2D(0, 0), points[0]);
        Assertions.assertEquals(new Point_2D(0, 10), points[1]);
        Assertions.assertEquals(new Point_2D(10, 10), points[2]);
    }

    /**
     * Tests the rotation of the polygon.
     */
    @Test
    void rotate() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(0, 5));
        polygon.add(new Point_2D(5, 5));
        polygon.add(new Point_2D(5, 0));

        polygon.rotate(new Point_2D(0, 0), 90);
        Point_2D[] points = polygon.getAllPoints();
        Assertions.assertEquals(new Point_2D(0, 0), points[0]);

    }
}