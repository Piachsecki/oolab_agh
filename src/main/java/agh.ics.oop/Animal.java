package agh.ics.oop;

public class Animal {
    private MapDirection mapDirection = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public MapDirection getMapDirection() {
        return mapDirection;
    }

    public void setMapDirection(MapDirection mapDirection) {
        this.mapDirection = mapDirection;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setPosition(Vector2d position) {

        this.position = position;
    }

    @Override
    public String toString() {
        return "mapDirection=" + mapDirection +
                ", position=" + position;
    }

    public boolean isAt(Vector2d position) {
        return this.getPosition().equals(position);
    }

    public void move(MoveDirection direction) {
        MapDirection mapDirectionTemp = this.getMapDirection();
        if(direction == MoveDirection.LEFT){
            this.setMapDirection(MapDirection.valueOf(mapDirectionTemp.previous()));
        }
        if(direction == MoveDirection.RIGHT){
            this.setMapDirection(MapDirection.valueOf(mapDirectionTemp.next()));
        }
        if(direction == MoveDirection.FORWARD){
            if
            (
            this.getPosition().getX() >= 4 || this.getPosition().getY() >= 4 ||
            this.getPosition().getX() <= 0 || this.getPosition().getY() <= 0
            ){
                return;
            }
            switch (mapDirectionTemp){
                case NORTH -> this.setPosition(this.getPosition().add(new Vector2d(0, 1)));
                case SOUTH -> this.setPosition(this.getPosition().add(new Vector2d(0, -1)));
                case EAST -> this.setPosition(this.getPosition().add(new Vector2d(1, 0)));
                case WEST -> this.setPosition(this.getPosition().add(new Vector2d(-1, 0)));
            }
        }

        if(direction == MoveDirection.BACKWARD){
            if
            (
                    this.getPosition().getX() >= 4 || this.getPosition().getY() >= 4 ||
                            this.getPosition().getX() <= 0 || this.getPosition().getY() <= 0
            ){
                return;
            }
            switch (mapDirectionTemp){
                case NORTH -> this.setPosition(this.getPosition().subtract(new Vector2d(0, 1)));
                case SOUTH -> this.setPosition(this.getPosition().subtract(new Vector2d(0, -1)));
                case EAST -> this.setPosition(this.getPosition().subtract(new Vector2d(1, 0)));
                case WEST -> this.setPosition(this.getPosition().subtract(new Vector2d(-1, 0)));
            }
        }
    }



}
