package agh.ics.oop;



public class World {

    public static void main(String[] args) {
        String[] arr= {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        System.out.println("Start");
        MoveDirection[] directions = OptionsParser.parse(arr);
        AbstractWorld grassMap = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, grassMap, positions);
        engine.run();


        System.out.println(grassMap);

        System.out.println("Stop");
    }



}
