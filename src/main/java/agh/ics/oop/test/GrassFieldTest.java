package agh.ics.oop.test;

import agh.ics.oop.Animal;
import agh.ics.oop.GrassField;
import agh.ics.oop.IWorldMap;
import agh.ics.oop.Vector2d;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class GrassFieldTest {


    @Test
    void GrassFieldMapTest(){
        IWorldMap map = new GrassField(10);
        Vector2d pos=new Vector2d(2,2);
        Animal animal = new Animal(map,pos);
        Animal animal2 = new Animal(map,pos);
        assertTrue(map.place(animal));
        assertEquals(map.objectAt(pos), animal);
        assertTrue(map.isOccupied(pos));
        assertFalse(map.canMoveTo(pos));
        assertFalse(map.place(animal2));

    }

}
