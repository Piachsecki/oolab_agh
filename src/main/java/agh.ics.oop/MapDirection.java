package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;


    public String toString() {
        switch (this) {
            case NORTH:
                return "NORTH";
            case SOUTH:
                return "SOUTH";
            case EAST:
                return "EAST";
            case WEST:
                return "WEST";
        }
        return null;

    }


    public String next(){
        switch(this){
            case EAST:
                return "SOUTH";
            case SOUTH:
                return "WEST";
            case WEST:
                return "NORTH";
            case NORTH:
                return "EAST";
        }
        return null;
    }

    public String previous(){
        switch(this){
            case EAST:
                return "NORTH";
            case SOUTH:
                return "EAST";
            case WEST:
                return "SOUTH";
            case NORTH:
                return "WEST";
        }
        return null;
    }

    public Vector2d toUnitVector(){
        switch(this){
            case EAST:
                return new Vector2d(1, 0);
            case SOUTH:
                return new Vector2d(0, -1);
            case WEST:
                return new Vector2d(-1, 0);
            case NORTH:
                return new Vector2d(0, 1);
        }
        return null;
    }







}
