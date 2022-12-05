package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private AbstractWorld map;
    private Vector2d[] positions;

    private List<Animal> animals;

    public SimulationEngine(
            MoveDirection[] directions,
            AbstractWorld map,
            Vector2d[] positions
    ) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
        this.animals = new ArrayList<>();

        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)){
                this.animals.add(animal);
            }
        }
    }

    public MoveDirection[] getDirections() {
        return directions;
    }

    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }


    public Vector2d[] getPositions() {
        return positions;
    }

    public void setPositions(Vector2d[] positions) {
        this.positions = positions;
    }

    @Override
    public void run() {
        int tabLength=animals.size();
        Animal[] tabAnimals= new Animal[tabLength];

        animals.toArray(tabAnimals);
        int i=0;
        if(tabLength!=0){
            for (MoveDirection x : directions ) {
                tabAnimals[i%tabLength].move(x);
                i++;
            }
        }
    }



}

