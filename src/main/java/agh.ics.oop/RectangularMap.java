package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final int height;

    private final int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public static List<Animal> animals = new ArrayList<>();



    @Override
    public boolean canMoveTo(Vector2d position) {
        if(
                this.getWidth() < position.getX() ||
                this.getHeight() < position.getY()
        ){
            return false;
        }

        for (Animal animal : animals) {
            if (animal.getPosition() == position)
                return false;
        }

        return true;

    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            return false;
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
