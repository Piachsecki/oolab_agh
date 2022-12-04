package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorld implements IWorldMap{
    protected List<Animal> animalsOnField = new ArrayList<>();

    @Override
    public void moveOnMap(Vector2d position) {}

    protected List<Grass> grassOnField = new ArrayList<>();

    protected Vector2d upperRight;
    protected Vector2d lowerLeft;

    public abstract Vector2d findLowerLeftBound();
    public abstract Vector2d findUpperRightBound();


    public boolean canMoveTo(Vector2d position) {
        Object obj = objectAt(position);
        return !(obj instanceof Animal);

    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animalsOnField.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animalsOnField) {
            if (animal.isAt(position))
                return true;
        }

        for (Grass grass : grassOnField) {
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animalsOnField) {
            if (animal.isAt(position))
                return animal;
        }

        for (Grass grass : grassOnField) {
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(findLowerLeftBound(), findUpperRightBound());
    }

}
