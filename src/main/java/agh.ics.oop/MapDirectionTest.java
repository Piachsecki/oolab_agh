package agh.ics.oop;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MapDirectionTest {

    @Test
    public void checkEastNext(){
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, MapDirection.valueOf(mapDirection.next()));

    }

    @Test
    public void checkSouthNext(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, MapDirection.valueOf(mapDirection.next()));
    }

    @Test
    public void checkWestNext(){
        MapDirection mapDirection = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, MapDirection.valueOf(mapDirection.next()));
    }

    @Test
    public void checkNorthNext(){
        MapDirection mapDirection = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, MapDirection.valueOf(mapDirection.next()));
    }

    @Test
    public void checkEastPrevious(){
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, MapDirection.valueOf(mapDirection.previous()));
    }

    @Test
    public void checkSouthPrevious(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, MapDirection.valueOf(mapDirection.previous()));
    }

    @Test
    public void checkWestPrevious(){
        MapDirection mapDirection = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, MapDirection.valueOf(mapDirection.previous()));
    }

    @Test
    public void checkNorthPrevious(){
        MapDirection mapDirection = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, MapDirection.valueOf(mapDirection.previous()));
    }

}
