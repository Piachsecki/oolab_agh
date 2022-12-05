package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorld implements IWorldMap, IPositionChangeObserver {

    protected Map<Animal, Vector2d> animalsOnField = new HashMap<>();

    public abstract Vector2d findLowerLeftBound();

    public abstract Vector2d findUpperRightBound();


    public boolean canMoveTo(Vector2d position) {
        Object obj = objectAt(position);
        return !(obj instanceof Animal);

    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animalsOnField.put(animal, animal.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animalsOnField.keySet()) {
            if (animal.isAt(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animalsOnField.keySet()) {
            if (animal.isAt(position))
                return animal;
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
        for (Animal animal : animalsOnField.keySet()) {
            if(animal.isAt(oldPosition)){
                animalsOnField.remove(animal);
                animalsOnField.put(new Animal(), newPosition);
            }
        }
    }
}
