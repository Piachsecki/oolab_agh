package agh.ics.oop;


import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] args) {
        try {


            System.out.println("Start");
            MoveDirection[] directions = OptionsParser.parse(args);
            AbstractWorld grassMap = new GrassField(12);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, grassMap, positions);
            engine.run();


            System.out.println(grassMap);

            System.out.println("Stop");



        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        Application.launch(App.class, args);

    }



}
