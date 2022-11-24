package agh.ics.oop;


public class World {

    public static void main(String[] args) {
            System.out.println("Start");
            String[] array = {"f", "f", "r", "x"};
            Direction[] directions = changeToEnum(array);
            run(directions);
            System.out.println("Stop");

    }

    private static Direction[] changeToEnum(String[] array) {
        Direction[] directions = new Direction[array.length];
        for (int i = 0; i < directions.length; i++) {
                switch (array[i]) {
                    case "f" -> directions[i] = Direction.FORWARD;
                    case "b" -> directions[i] = Direction.BACKWARD;
                    case "r" -> directions[i] = Direction.RIGHT;
                    case "l" -> directions[i] = Direction.LEFT;
                    default -> directions[i] = Direction.STAY;
                }
        }

        return directions;
    }

    private static void run(Direction[] directions) {
        for (Direction direction : directions) {
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
