package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private final int x;
    private final int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "("+ x + ", " + y + ")";
    }

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean precedes(Vector2d other){
        return ((this.getX() <= other.getX()) && (this.getY() <= other.getY()));
    }

    public boolean follows(Vector2d other){
        return ((this.getX() >= other.getX()) && (this.getY() >= other.getY()));
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.getX() - other.getX(), this.getY() - other.getY());
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(x, other.x), Math.max(y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(x, other.x), Math.min(y, other.y));
    }

    public Vector2d opposite(){
        return new Vector2d(-this.getX(), -this.getY());
    }


}
