package ex2.geo.test;

import ex2.geo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ex2.ex2.Ex2_Const.EPS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Tests for the Circle_2D class.
 */
class Circle_2DTest {
    private Point_2D p1 = new Point_2D(1,10);
    private Point_2D p2 = new Point_2D(1,5);
    private Segment_2D seg1= new Segment_2D(p1,p2);

    private Segment_2D seg2= new Segment_2D(new Point_2D(0,0),new Point_2D(2,2));
    /**
     * Tests the contains method.
     */
    @Test
    void contains() {
        assertTrue(seg1.contains(p1));
        Point_2D z = new Point_2D(2,6);
        assertFalse(seg1.contains(z));
    }
    /**
     * Tests the contains method with different points.
     */
    @Test
    void testContains() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 4);
        Point_2D p3 = new Point_2D(6, 8);

        Circle_2D circle = new Circle_2D(p1, 5);
        assertTrue(circle.contains(p2));
        assertFalse(circle.contains(p3));
    }
    /**
     * Tests the area method.
     */
    @Test
    void area() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1, 5);
        Assertions.assertEquals(25 * Math.PI, circle.area());


    }
    /**
     * Tests the perimeter method.
     */
    @Test
    void perimeter() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1, 5);
        Assertions.assertEquals(10 * Math.PI, circle.perimeter());

    }
    /**
     * Tests the translate method.
     */
    @Test
    void translate() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1, 5);

        circle.translate(new Point_2D(1, 2));
        Assertions.assertEquals(new Point_2D(1, 2), circle.getCenter());
    }
    /**
     * Tests the copy method.
     */
    @Test
    void copy() {
        Point_2D p1 = new Point_2D(0, 0);
        Circle_2D circle = new Circle_2D(p1, 5);

        Circle_2D copy = (Circle_2D) circle.copy();
        Assertions.assertEquals(circle.getCenter(), copy.getCenter());
        Assertions.assertEquals(circle.getRadius(), copy.getRadius());
    }
    /**
     * Tests the scaling of the circle.
     */
    @Test
    void scale() {
        Point_2D center = new Point_2D(1, 1);
        Circle_2D circle = new Circle_2D(center, 5);

        circle.scale(center, 2);
        Assertions.assertEquals(10, circle.getRadius());
    }
    /**
     * Tests the rotation of the circle.
     */
    @Test
    void rotate() {
        Circle_2D c1 = new Circle_2D(new Point_2D(1,0),1);
        c1.rotate(new Point_2D(0,0),180);
        Assertions.assertEquals(-1,c1.getCenter().x(),EPS);
        Assertions.assertEquals(0,c1.getCenter().y(),EPS);

    }
}

