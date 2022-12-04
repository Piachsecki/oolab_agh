package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


public class RectangularMap extends AbstractWorld {
    private final int height;
    private final int width;

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public Vector2d findLowerLeftBound() {
        return new Vector2d(0,0);
    }

    @Override
    public Vector2d findUpperRightBound() {
        return new Vector2d(width, height);
    }
}