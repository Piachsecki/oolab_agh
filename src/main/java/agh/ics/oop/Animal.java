package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    private static final Vector2d UPPER_BOUND = new Vector2d(4,4);
    private MapDirection mapDirection;
    private Vector2d position;

    private IWorldMap map;

    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map){
        this.mapDirection = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition ){
        this.mapDirection = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public Animal() {
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
    public String toString(){
        return switch (this.getMapDirection()){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public IWorldMap getMap() {
        return map;
    }


    void move(MoveDirection direction){
        Vector2d temp_position;
        switch (direction) {
            case RIGHT -> mapDirection = mapDirection.next();
            case LEFT -> mapDirection = mapDirection.previous();
            case FORWARD-> {

                temp_position = this.position.add(mapDirection.toUnitVector());
                if(map.canMoveTo(temp_position)){
                    positionChanged(this.position, temp_position);
                    this.position=temp_position;

                }

            }
            case BACKWARD -> {
                temp_position = this.position.subtract(mapDirection.toUnitVector());
                if(map.canMoveTo(temp_position)){
                    positionChanged(this.position, temp_position);
                    this.position=temp_position;

                }

            }
        }


    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }


}
