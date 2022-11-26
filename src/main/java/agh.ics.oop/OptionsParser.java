package agh.ics.oop;

public class OptionsParser {


    public MoveDirection[] parse(String[] array) {

        String[] newCorrectArray = checkIfCorrectInputs(array);

        MoveDirection[] directions = new MoveDirection[newCorrectArray.length];

        for (int i = 0; i < newCorrectArray.length; i++) {
            switch (newCorrectArray[i]) {
                case "f" -> directions[i] = MoveDirection.FORWARD;
                case "b" -> directions[i] = MoveDirection.BACKWARD;
                case "r" -> directions[i] = MoveDirection.RIGHT;
                case "l" -> directions[i] = MoveDirection.LEFT;
            }
        }
        return directions;
    }

    private String[] checkIfCorrectInputs(String[] array) {
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (
                    array[i].equals("f") ||
                            array[i].equals("b") ||
                            array[i].equals("r") ||
                            array[i].equals("l")
            ) {
                size++;
            }
        }
        String[] temp = new String[size];
        int k = 0;
        for (int j = 0; j < array.length; j++) {
            if (
                    array[j].equals("f") ||
                            array[j].equals("b") ||
                            array[j].equals("r") ||
                            array[j].equals("l")
            ) {
                temp[k] = array[j];
                k++;
            }
        }

        return temp;
    }
}

