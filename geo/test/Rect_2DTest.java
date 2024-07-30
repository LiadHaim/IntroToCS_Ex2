package ex2.geo.test;

import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * Test class for Rect_2D.
 */
class Rect_2DTest {
   private Point_2D p1 = new Point_2D(0, 0);
   private Point_2D p2 = new Point_2D(3, 4);
    private Point_2D p3 = new Point_2D(6, 8);

    /**
     * Tests the contains method for points inside and outside the rectangle.
     */
    @Test
    void contains() {
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5));
        Assertions.assertTrue(rect.contains(new Point_2D(2, 2)));
        Assertions.assertFalse(rect.contains(new Point_2D(6, 6)));
    }
    /**
     * Tests the area calculation of the rectangle.
     */
    @Test
    void area() {
        Rect_2D rect1 = new Rect_2D(p1, new Point_2D(2, 2));
        Assertions.assertEquals(4, rect1.area());
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5));
        Assertions.assertEquals(25, rect.area());
    }
    /**
     * Tests the perimeter calculation of the rectangle.
     */
    @Test
    void perimeter() {
        Rect_2D rect = new Rect_2D(p1, new Point_2D(2, 2));
        Assertions.assertEquals(8, rect.perimeter());
    }
    /**
     * Tests the translation of the rectangle.
     */
    @Test
    void translate() {
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5));
        rect.translate(new Point_2D(1, 1));
        Assertions.assertEquals(new Point_2D(1, 1), rect.get_p1());
        Assertions.assertEquals(new Point_2D(6, 6), rect.get_p2());
    }
    /**
     * Tests the copying of the rectangle.
     */
    @Test
    void copy() {
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5));
        Rect_2D copy = (Rect_2D) rect.copy();
        Assertions.assertEquals(rect.get_p1(), copy.get_p1());
        Assertions.assertEquals(rect.get_p2(), copy.get_p2());
    }
    /**
     * Tests the scaling of the rectangle.
     */
    @Test
    void scale() {
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(5, 5));
        rect.scale(new Point_2D(0, 0), 2);
        Assertions.assertEquals(new Point_2D(0, 0), rect.get_p1());
        Assertions.assertEquals(new Point_2D(10, 10), rect.get_p2());
    }
//    @Test
//    void rotate(Point_2D point2D, int i) {
//       Rect_2D r1 = new Rect_2D(5,0)()
//        Rect_2D r1.rotate(new Point_2D(-1,0),180);
//        assertEquals(-2,r1.get_p1().x(),0.00001);
//        assertEquals(-5,r1.get_p1().y(),0.00001);
//        assertEquals(-7,r1.get_p2().x(),0.00001);
//        assertEquals(0,r1.get_p2().y(),0.00001);}
}