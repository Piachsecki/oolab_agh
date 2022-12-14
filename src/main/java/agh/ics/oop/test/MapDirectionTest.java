package agh.ics.oop.test;

import agh.ics.oop.MapDirection;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MapDirectionTest {

    @Test
    public void checkEastNext(){
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, MapDirection.valueOf(mapDirection.next().toString()));

    }

    @Test
    public void checkSouthNext(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, MapDirection.valueOf(mapDirection.next().toString()));
    }

    @Test
    public void checkWestNext(){
        MapDirection mapDirection = MapDirection.WEST;
        assertEquals(MapDirection.NORTH, MapDirection.valueOf(mapDirection.next().toString()));
    }

    @Test
    public void checkNorthNext(){
        MapDirection mapDirection = MapDirection.NORTH;
        assertEquals(MapDirection.EAST, MapDirection.valueOf(mapDirection.next().toString()));
    }

    @Test
    public void checkEastPrevious(){
        MapDirection mapDirection = MapDirection.EAST;
        assertEquals(MapDirection.NORTH, MapDirection.valueOf(mapDirection.previous().toString()));
    }

    @Test
    public void checkSouthPrevious(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, MapDirection.valueOf(mapDirection.previous().toString()));
    }

    @Test
    public void checkWestPrevious(){
        MapDirection mapDirection = MapDirection.WEST;
        assertEquals(MapDirection.SOUTH, MapDirection.valueOf(mapDirection.previous().toString()));
    }

    @Test
    public void checkNorthPrevious(){
        MapDirection mapDirection = MapDirection.NORTH;
        assertEquals(MapDirection.WEST, MapDirection.valueOf(mapDirection.previous().toString()));
    }

}
