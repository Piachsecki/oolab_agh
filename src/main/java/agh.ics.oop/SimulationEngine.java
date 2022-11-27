package agh.ics.oop;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;

    public SimulationEngine(
            MoveDirection[] directions,
            IWorldMap map,
            Vector2d[] positions
    ) {
        this.directions = directions;
        this.map = map;
        this.positions = positions;
    }

    public MoveDirection[] getDirections() {
        return directions;
    }

    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }

    public IWorldMap getMap() {
        return map;
    }

    public void setMap(IWorldMap map) {
        this.map = map;
    }

    public Vector2d[] getPositions() {
        return positions;
    }

    public void setPositions(Vector2d[] positions) {
        this.positions = positions;
    }

    @Override
    public void run() {

    }


}

