package agh.ics.oop;


public class World {

    public static void main(String[] args) {
        System.out.println("Start");

        Animal animal = new Animal();
        String[] arr = {"f", "f", "l"};
        OptionsParser optionsParser = new OptionsParser();
        MoveDirection[] directions = optionsParser.parse(arr);
        System.out.println("Animal position before moving " + animal);
        run(directions, animal);
        System.out.println("Animal position after moving " + animal);

        System.out.println("Stop");
    }

    private static void run(MoveDirection[] directions, Animal animal) {
        for (MoveDirection direction : directions) {
            animal.move(direction);
        }
    }
}
