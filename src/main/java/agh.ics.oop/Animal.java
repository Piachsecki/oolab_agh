package agh.ics.oop;

public class Animal {
    private MapDirection mapDirection;
    private Vector2d position;

    private IWorldMap map;


    public Animal(IWorldMap map){
    }

    public Animal(IWorldMap map, Vector2d initialPosition ){
        this.position = initialPosition;
    }

    public Animal(){

        this.mapDirection = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }
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
        switch (this.getMapDirection()){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
            case WEST:
                return "W";
        }
        return null;
    }

    public boolean isAt(Vector2d position) {
        return this.getPosition().equals(position);
    }

    public IWorldMap getMap() {
        return map;
    }

    public void move(MoveDirection direction) {

        MapDirection mapDirectionTemp = this.getMapDirection();
        if (direction == MoveDirection.LEFT) {
            this.setMapDirection(MapDirection.valueOf(mapDirectionTemp.previous()));
        }
        if (direction == MoveDirection.RIGHT) {
            this.setMapDirection(MapDirection.valueOf(mapDirectionTemp.next()));
        }

        if (direction == MoveDirection.FORWARD) {
            Vector2d movedNorth = this.getPosition().add(new Vector2d(0, 1));
            Vector2d movedSouth = this.getPosition().add(new Vector2d(0, -1));
            Vector2d movedEast = this.getPosition().add(new Vector2d(1, 0));
            Vector2d movedWest = this.getPosition().add(new Vector2d(-1, 0));
            forwardAndBackwardMovement(mapDirectionTemp, movedNorth, movedSouth, movedEast, movedWest);
        }

        if (direction == MoveDirection.BACKWARD) {

            Vector2d movedNorth = this.getPosition().subtract(new Vector2d(0, 1));
            Vector2d movedSouth =this.getPosition().subtract(new Vector2d(0, -1));
            Vector2d movedEast =this.getPosition().subtract(new Vector2d(1, 0));
            Vector2d movedWest =this.getPosition().subtract(new Vector2d(-1, 0));
            forwardAndBackwardMovement(mapDirectionTemp, movedNorth, movedSouth, movedEast, movedWest);
        }
    }

    private void forwardAndBackwardMovement(MapDirection mapDirectionTemp, Vector2d movedNorth, Vector2d movedSouth, Vector2d movedEast, Vector2d movedWest) {
        switch (mapDirectionTemp) {
            case NORTH:
                if (this.getMap().canMoveTo(movedNorth)) {
                    this.setPosition(movedNorth);
                    break;
                }
            case SOUTH:
                if (this.getMap().canMoveTo(movedSouth)) {
                    this.setPosition(movedSouth);
                }
                break;
            case EAST:
                if (this.getMap().canMoveTo(movedEast)) {
                    this.setPosition(movedEast);
                }
                break;
            case WEST:
                if (this.getMap().canMoveTo(movedWest)) {
                    this.setPosition(movedWest);
                    break;
                }

        }
    }


}
