package agh.ics.oop;


public class World {

    public static void main(String[] args) {
        System.out.println("Start");
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        MapVisualizer mapVisualizer = new MapVisualizer(map);
        mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(10, 5));
        System.out.println("Stop");
    }

}
