package agh.ics.oop;


public class World {

    public static void main(String[] args) {
            System.out.println("Start");
            String[] array = {"f", "f", "r", "x"};
            MoveDirection[] directions = changeToEnum(array);
            run(directions);
            System.out.println("Stop");
            MapDirection mapDirection = MapDirection.EAST;

        System.out.println(mapDirection.next());
        System.out.println(mapDirection.previous());
        System.out.println(mapDirection.toString());
        System.out.println(mapDirection.toUnitVector());

    }

    private static MoveDirection[] changeToEnum(String[] array) {
        MoveDirection[] directions = new MoveDirection[array.length];
        for (int i = 0; i < directions.length; i++) {
                switch (array[i]) {
                    case "f" -> directions[i] = MoveDirection.FORWARD;
                    case "b" -> directions[i] = MoveDirection.BACKWARD;
                    case "r" -> directions[i] = MoveDirection.RIGHT;
                    case "l" -> directions[i] = MoveDirection.LEFT;
                    default -> directions[i] = MoveDirection.STAY;
                }
        }

        return directions;
    }

    private static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("An animal is moving forward");
                case BACKWARD -> System.out.println("An animal is moving backwards");
                case RIGHT -> System.out.println("An animal is turning right");
                case LEFT -> System.out.println("An animal is turning left");
                default -> System.out.println("Inappropriate command");
            }
        }
    }
}
