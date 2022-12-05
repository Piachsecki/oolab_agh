package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorld {
    private int numberOfGrassFields;
    protected HashMap<Vector2d,Grass> grassOnField = new HashMap<>();


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
            grassOnField.put(grassPosition, new Grass());
        }
    }

    @Override
    public Vector2d findUpperRightBound() {
        Animal firstKey = (Animal) animalsOnField.keySet().toArray()[0];
        Vector2d upperRight = firstKey.getPosition();

        for (Animal animal: animalsOnField.keySet()){
            upperRight=animal.getPosition().upperRight(upperRight);
        }

        for(Vector2d grassPosition: grassOnField.keySet()){
            upperRight=grassPosition.upperRight(upperRight);
        }
        return upperRight;
    }

    @Override
    public Vector2d findLowerLeftBound() {
        Animal firstKey = (Animal) animalsOnField.keySet().toArray()[0];
        Vector2d lowerLeft = firstKey.getPosition();
        for (Animal animal: animalsOnField.keySet()){
            lowerLeft=animal.getPosition().lowerLeft(lowerLeft);
        }

        for (Vector2d grassPosition: grassOnField.keySet()){
            lowerLeft=grassPosition.lowerLeft(lowerLeft);
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

        for (Vector2d grassPosition : grassOnField.keySet()) {
            if (grassPosition.equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animalsOnField.keySet()) {
            if (animal.isAt(position))
                return animal;
        }

        for (Vector2d grass : grassOnField.keySet()) {
            if (grass.equals(position)){
                return grassOnField.get(grass);
            }
        }

        return null;
    }



}
