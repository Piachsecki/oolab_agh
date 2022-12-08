package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    TreeSet<MapBoundaryElement> xAxis = new TreeSet<>(new Comparator<MapBoundaryElement>() {
        @Override
        public int compare(MapBoundaryElement e1, MapBoundaryElement e2) {
            int resultX = Integer.compare(e1.getPosition().getX(), e2.getPosition().getX());
            int resultY = Integer.compare(e1.getPosition().getY(), e2.getPosition().getY());
            if(resultX != 0){
                return resultX;
            }
            if(resultY != 0){
                return resultY;
            }
            if(resultY == 0 && resultX == 0){
                if (e1.getMapBoundaryInstance() == MapBoundaryInstance.ANIMAL){
                    return 1;
                }
            }
            return -1;
        }
    });
    TreeSet<MapBoundaryElement> yAxis = new TreeSet<>(new Comparator<MapBoundaryElement>() {
        @Override
        public int compare(MapBoundaryElement e1, MapBoundaryElement e2) {
            int resultX = Integer.compare(e1.getPosition().getX(), e2.getPosition().getX());
            int resultY = Integer.compare(e1.getPosition().getY(), e2.getPosition().getY());
            if(resultX != 0){
                return resultX;
            }
            if(resultY != 0){
                return resultY;
            }
            if(resultY == 0 && resultX == 0){
                if (e1.getMapBoundaryInstance() == MapBoundaryInstance.ANIMAL){
                    return 1;
                }
            }
            return -1;
        }
    });
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        MapBoundaryElement toDelete = new MapBoundaryElement(MapBoundaryInstance.ANIMAL, oldPosition);
        MapBoundaryElement toAdd = new MapBoundaryElement(MapBoundaryInstance.ANIMAL, newPosition);
        xAxis.remove(toDelete);
        yAxis.remove(toDelete);
        xAxis.add(toAdd);
        yAxis.add(toAdd);
    }

    public void add(MapBoundaryElement element){
        yAxis.add(element);
        xAxis.add(element);
    }
    public void remove(MapBoundaryElement element){
        yAxis.remove(element);
        xAxis.remove(element);
    }


    public Vector2d upperRight(){
        Vector2d position = new Vector2d(xAxis.last().getPosition().getY(), yAxis.last().getPosition().getY() );
        return position;
    }
    public Vector2d lowerLeft(){
        Vector2d position = new Vector2d(xAxis.first().getPosition().getX(), yAxis.first().getPosition().getY());
        return position;
    }






}
