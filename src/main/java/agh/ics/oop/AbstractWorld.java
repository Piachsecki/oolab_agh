package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorld implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> animalsOnField = new HashMap<>();

    public abstract Vector2d findLowerLeftBound();

    public abstract Vector2d findUpperRightBound();


    public boolean canMoveTo(Vector2d position) {
        Object obj = objectAt(position);
        return !(obj instanceof Animal);

    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (this.canMoveTo(animal.getPosition())) {
            animalsOnField.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("method: place(Animal animal) -> This field is already taken");
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Vector2d animalPosition : animalsOnField.keySet()) {
            if (animalPosition.equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Vector2d animalPosition : animalsOnField.keySet()) {
            if (animalPosition.equals(position))
                return animalsOnField.get(animalPosition);
        }

        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(findLowerLeftBound(), findUpperRightBound());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
                animalsOnField.put(newPosition, animalsOnField.get(oldPosition) );
                animalsOnField.remove(oldPosition);
        }
    }

