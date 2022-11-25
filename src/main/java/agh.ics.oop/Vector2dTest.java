package agh.ics.oop;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Vector2dTest {

@Parameter
Vector2d VInput = new Vector2d(2, 5);

    @Test
    public void testToString(){
        assertEquals( "(2, 5)", VInput.toString());

    }

    @Test
    public void opposite(){
        Vector2d vector2d = new Vector2d(1, 2);
        assertEquals(new Vector2d(-1, -2), vector2d.opposite());
    }



    @Test
    public void precedes(){

    }

    @Test
    public void follows(){

    }

    @Test
    public void upperRight(){

    }

    @Test
    public void lowerLeft(){

    }

    @Test
    public void add(){
        Vector2d VInput2 = new Vector2d(1, 2);
        assertEquals(new Vector2d(3, 7), VInput2.add(VInput));

    }

    @Test
    public void subtract(){
        Vector2d VInput2 = new Vector2d(1, 2);
        assertEquals(new Vector2d(-1, -3), VInput2.subtract(VInput));
    }


}
