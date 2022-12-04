package agh.ics.oop;

public class Grass {
    private Vector2d position;

    @Override
    public String toString() {
        return "*";
    }

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }
}
