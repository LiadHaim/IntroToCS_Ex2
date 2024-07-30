package ex2.gui;

import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GUIShapeTest {
    /**
     * Test for the toString method of GUIShape with a Rectangle.
     */
    @Test
    void testGUIShapeToStringWithRect() {
        Rect_2D rect = new Rect_2D(new Point_2D(0, 0), new Point_2D(2, 2));

        GUIShape guiShape = new GUIShape(rect, false, Color.BLUE, 2);

        String expected = "GUIShape,java.awt.Color[r=0,g=0,b=255],false,2,Rect_2D,0.0,0.0,2.0,2.0,0.0,2.0,2.0,0.0";
        Assertions.assertEquals(expected, guiShape.toString());
    }
    /**
     * Test for the isFilled method of GUIShape.
     */
    @Test
    void testIsFilled() {
        GUIShape guiShape = new GUIShape(null, true, Color.RED, 1);
        Assertions.assertTrue(guiShape.isFilled());
    }
    /**
     * Test for the isSelected method of GUIShape.
     */
    @Test
    void testIsSelected() {
        GUIShape guiShape = new GUIShape(null, true, Color.RED, 1);
        Assertions.assertFalse(guiShape.isSelected());
    }
    /**
     * Test for the setSelected method of GUIShape.
     */
    @Test
    void testSetSelected() {
        GUIShape guiShape = new GUIShape(null, true, Color.RED, 1);
        guiShape.setSelected(true);
        Assertions.assertTrue(guiShape.isSelected());
    }
}

