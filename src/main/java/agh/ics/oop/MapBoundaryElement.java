package agh.ics.oop;

public class MapBoundaryElement {
   private MapBoundaryInstance mapBoundaryInstance;
   private Vector2d position;

    public MapBoundaryInstance getMapBoundaryInstance() {
        return mapBoundaryInstance;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapBoundaryElement(MapBoundaryInstance mapBoundaryInstance, Vector2d position) {
        this.mapBoundaryInstance = mapBoundaryInstance;
        this.position = position;
    }
}
