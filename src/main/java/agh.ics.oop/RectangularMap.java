package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class RectangularMap implements IWorldMap {
    private final int height;
    private final int width;
    public List<Animal> animals = new ArrayList<>();

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return
                new MapVisualizer(this)
                        .draw(
                                new Vector2d(0, 0),
                                new Vector2d(this.getHeight() - 1, this.getWidth() - 1));
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0, 0))
                && position
                .precedes(new Vector2d(width - 1, height - 1))
                && !isOccupied(position);

    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position))
                return animal;
        }

        return null;
    }
}
