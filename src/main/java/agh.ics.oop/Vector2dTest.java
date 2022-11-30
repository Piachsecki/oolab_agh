package agh.ics.oop;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;

public class Vector2dTest {


    Vector2d VInput = new Vector2d(2, 5);
    Vector2d vector = new Vector2d(1, 2);
    Vector2d vector2 = new Vector2d(-1, 2);
    Vector2d vector3 = new Vector2d(1, 2);
    Vector2d vector4 = new Vector2d(4, 5);
    Vector2d vector5 = new Vector2d(0, 8);
    Vector2d vector6 = new Vector2d(0, 0);
    Vector2d vector7 = new Vector2d(-4, -2);

    @Test
    public void testToString() {
        assertEquals("(2, 5)", VInput.toString());

    }

    @Test
    public void opposite() {
        Vector2d vector2d = new Vector2d(1, 2);
        assertEquals(new Vector2d(-1, -2), vector2d.opposite());
    }


    @Test
    void testForPrecedes(){
        assertTrue(vector.precedes(vector4));
        assertFalse(vector4.precedes(vector5));
    }
    @Test
    void testForFollows(){
        assertTrue(vector4.follows(vector));
        assertFalse(vector4.follows(vector5));
    }
    @Test
    void testForUpperRight(){
        assertEquals(vector4.upperRight(vector),new Vector2d(4,5));
        assertEquals(vector7.upperRight(vector6),new Vector2d(0,0));
        assertNotEquals(vector5.upperRight(vector2),new Vector2d(2,5));

    }
    @Test
    void testForLowerLeft(){
        assertEquals(vector5.lowerLeft(vector6),new Vector2d(0,0));
        assertEquals(vector7.lowerLeft(vector6),new Vector2d(-4,-2));
        assertNotEquals(vector3.lowerLeft(vector2),new Vector2d(7,2));
    }

    @Test
    public void add() {
        Vector2d VInput2 = new Vector2d(1, 2);
        assertEquals(new Vector2d(3, 7), VInput2.add(VInput));

    }

    @Test
    public void subtract() {
        Vector2d VInput2 = new Vector2d(1, 2);
        assertEquals(new Vector2d(-1, -3), VInput2.subtract(VInput));
    }


}
