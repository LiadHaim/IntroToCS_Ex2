package ex2.geo.test;

import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {
    private Point_2D p1 = new Point_2D(1,10);
    private Point_2D p2 = new Point_2D(1,5);
    private Segment_2D seg1= new Segment_2D(p1,p2);
    private Segment_2D seg2= new Segment_2D(new Point_2D(0,0),new Point_2D(2,2));

    @Test
    void contains() {
        // Creating a point P at coordinates (1, 6)
        // Checking that seg1 contains point P
        // Creating a point z at coordinates (2, 6)
        // Checking that seg1 does not contain point z
        Point_2D P = new Point_2D(1,6);
        assertTrue(seg1.contains(P));
        Point_2D z = new Point_2D(2,6);
        assertFalse(seg1.contains(z));
    }

    @Test
    void perimeter() {
        // Creating points point1 at (0, 0) and point2 at (3, 4)
        // Creating a segment with points point1 and point2
        // Calculating the expected perimeter as the distance between point1 and point2 multiplied by 2
        // Calling the perimeter method on the segment and comparing the result with the expected perimeter with a precision of 0.001
        Point_2D point1 = new Point_2D(0, 0);
        Point_2D point2 = new Point_2D(3, 4);
        Segment_2D segment = new Segment_2D(point1, point2);
        double expectedPerimeter = point1.distance(point2)*2;
        double actualPerimeter = segment.perimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.001);
    }

    @Test
    void translate() {
        // Creating points point1 at (1, 1) and point2 at (4, 4)
        // Creating a segment with points point1 and point2
        // Creating a translation vector with coordinates (2, 3)
        // Translating the segment by the translation vector
        // Creating expected points after translation
        // Getting actual points after translation
        // Checking that the translated points match the expected points
        Point_2D point1 = new Point_2D(1, 1);
        Point_2D point2 = new Point_2D(4, 4);
        Segment_2D segment = new Segment_2D(point1, point2);
        Point_2D translationVector = new Point_2D(2, 3);
        segment.translate(translationVector);
        Point_2D expectedPoint1 = new Point_2D(3, 4);
        Point_2D expectedPoint2 = new Point_2D(6, 7);
        Point_2D actualPoint1 = segment.get_p1();
        Point_2D actualPoint2 = segment.get_p2();
        assertEquals(expectedPoint1, actualPoint1);
        assertEquals(expectedPoint2, actualPoint2);

    }

    @Test
    void copy() {
        // Creating points a at (1, 1), b at (2, 2), and c at (3, 3)
        // Creating a triangle with points a, b, and c
        // Copying the triangle
        // Checking that the copy is an instance of Triangle_2D
        // Getting the original points of the triangle and the copied triangle
        // Checking that each pair of points in the original triangle matches the corresponding pair of points in the copied triangle
        Point_2D a = new Point_2D(1, 1);
        Point_2D b = new Point_2D(2, 2);
        Point_2D c = new Point_2D(3, 3);
        Triangle_2D triangle = new Triangle_2D(a, b, c);
        GeoShape copy = triangle.copy();
        assertEquals(Triangle_2D.class, copy.getClass());
        Point_2D[] originalPoints = triangle.getAllPoints();
        Point_2D[] copyPoints = ((Triangle_2D) copy).getAllPoints();
        for (int i = 0; i < originalPoints.length; i++) {
            assertEquals(originalPoints[i], copyPoints[i]);
        }
    }

    @Test
    void scale(){
        // Creating points p1 at (0, 0) and p2 at (3, 4)
        // Creating a segment with points p1 and p2
        // Creating a center point at (1, 1) and a scaling ratio of 2.0
        // Scaling the segment around the center point with the scaling ratio
        // Creating expected points after scaling
        // Checking that the scaled points match the expected points
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 4);
        Segment_2D segment = new Segment_2D(p1, p2);
        Point_2D center = new Point_2D(1, 1);
        double ratio = 2.0;
        segment.scale(center, ratio);
        Point_2D expectedP1 = new Point_2D(-1, -1);
        Point_2D expectedP2 = new Point_2D(5, 7);
        assertEquals(expectedP1, segment.get_p1());
        assertEquals(expectedP2, segment.get_p2());

    }
    @Test
    void rotate(){

    }


}