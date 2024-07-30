package ex2.gui;

import ex2.ex2.Ex2_Const;
import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the Ex2 class.
 */
public class Ex2Test {
    private Ex2_GUI ex2Gui;
    private GUI_Shape_Collection shapes;
    private Ex2 ex2;
    /**
     * Initializes a new instance of Ex2 before each test.
     */
    @BeforeEach
    void setUp() {
        ex2 = Ex2.getInstance();
        ex2.init(new ShapeCollection());
    }
    /**
     * Tests the initialization of Ex2.
     */
    @Test
    void testInit() {
        Assertions.assertNotNull(ex2);
        GUI_Shape_Collection shapes = ex2.getShape_Collection();
        Assertions.assertNotNull(shapes);
        Assertions.assertEquals(0, shapes.size());
    }
    /**
     * Tests the show method of Ex2.
     */
    @Test
    void testShow() {
        ex2.show(Ex2_Const.DIM_SIZE);
    }

    /**
     * Tests the getInstance method of Ex2.
     */
    @Test
    void testGetInstance() {
        Ex2 ex2_2 = Ex2.getInstance();
        Assertions.assertNotNull(ex2_2);
        Assertions.assertEquals(ex2, ex2_2);
    }
    @Test
    public void testGetInfo() {
        Ex2 ex2 = Ex2.getInstance();
        String expectedInfo = ""; // Set the expected info string here
        Assertions.assertEquals(expectedInfo, ex2.getInfo());
    }
    @Test
    public void testGetShapeCollection() {
        Ex2 ex2 = Ex2.getInstance();
        // Assuming _shapes is initialized with some shapes
        GUI_Shape_Collection expectedCollection = ex2.getShape_Collection();
        Assertions.assertEquals(expectedCollection, ex2.getShape_Collection());
    }
}
