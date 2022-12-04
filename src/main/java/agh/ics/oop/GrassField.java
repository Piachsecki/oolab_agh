package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorld {
    private int numberOfGrassFields;

    public GrassField(int numberOfGrassFields){
        this.numberOfGrassFields = numberOfGrassFields;
        for (int i =0 ; i< numberOfGrassFields; i++){
            createGrass();
        }

    }

    private void createGrass() {
        Random random = new Random();
        int x = random.nextInt((int) Math.sqrt(numberOfGrassFields*10)+1);
        int y = random.nextInt((int) Math.sqrt(numberOfGrassFields*10)+1);
        Vector2d grassPosition = new Vector2d(x, y);
        if (!isOccupied(grassPosition)){
            grassOnField.add(new Grass(grassPosition));
        }
    }

    @Override
    public Vector2d findUpperRightBound() {
        Vector2d upperRight = animalsOnField.get(1).getPosition();
        for (Animal animal: animalsOnField){
            upperRight=animal.getPosition().upperRight(upperRight);
        }

        for (Grass grass: grassOnField){
            upperRight=grass.getPosition().upperRight(upperRight);
        }
        return upperRight;
    }

    @Override
    public Vector2d findLowerLeftBound() {
        Vector2d lowerLeft = animalsOnField.get(1).getPosition();
        for (Animal animal: animalsOnField){
            lowerLeft=animal.getPosition().lowerLeft(lowerLeft);
        }

        for (Grass grass: grassOnField){
            lowerLeft=grass.getPosition().lowerLeft(lowerLeft);
        }
        return lowerLeft;    }

    @Override
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
    public void moveOnMap(Vector2d position) {
        for (Grass grass : grassOnField) {
            if(grass.getPosition() == position){
                grassOnField.remove(grass);
                createGrass();
            }

        }
    }

}
