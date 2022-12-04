package agh.ics.oop.test;


import agh.ics.oop.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SimulationEngineTest {
    @Test
    void AnimalOccuppiedTest() {
        String[] args= {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 0)));


    }



    @Test
    void addToTab(){
        String[] args= {"r", "r","l","b","b","b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(2,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 2)));


    }

    @Test
    void nullMap(){
        String[] args= {"f", "r","l","b","f","b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(2, 4);
        Vector2d[] positions = { new Vector2d(2,1), new Vector2d(2,2),new Vector2d(2,3) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertFalse(map.isOccupied(new Vector2d(2, 1)));


    }

    @Test
    void threeAnimal(){
        String[] args= {"f", "r","l","b","f","b"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = { new Vector2d(2,1), new Vector2d(2,2),new Vector2d(2,3) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 3)));


    }
}
