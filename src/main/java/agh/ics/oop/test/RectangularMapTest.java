package agh.ics.oop.test;

import agh.ics.oop.Animal;
import agh.ics.oop.IWorldMap;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.Vector2d;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


public class RectangularMapTest {

    @Test
    void IWorldMapTest(){
        IWorldMap map = new RectangularMap(5,5);
        Vector2d pos=new Vector2d(1,1);
        Vector2d pos2=new Vector2d(2,3);
        Vector2d pos3=new Vector2d(1,3);
        Animal animal = new Animal(map,pos);
        Animal animal2 = new Animal(map,pos2);
        Animal animal3=new Animal(map,pos3);
        Animal animal4=new Animal(map,pos);
        assertTrue(map.canMoveTo(new Vector2d(2,10)));
        assertTrue(map.place(animal));
        assertTrue(map.place(animal2));
        assertTrue(map.place(animal3));
        assertEquals(map.objectAt(pos), animal);
        assertTrue(map.isOccupied(pos2));
        assertFalse(map.canMoveTo(pos2));
        assertFalse(map.place(animal4));
        System.out.println(map.toString());

    }
}
