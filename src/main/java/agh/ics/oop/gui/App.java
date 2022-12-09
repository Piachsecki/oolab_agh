package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {
    private AbstractWorld map;
    /*
    The application initialization method. This method is called immediately after the Application class is loaded and constructed.
     An application may override this method to perform initialization prior to the actual starting of the application.
    */

    @Override
    public void init() throws Exception {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(args);
            map = new GrassField(12);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int minX=map.findLowerLeftBound().getX();
        int minY=map.findLowerLeftBound().getY();
        int maxX=map.findUpperRightBound().getX();
        int maxY=map.findUpperRightBound().getY();
//        System.out.println(minX);
//        System.out.println(minY);
//        System.out.println(maxX);
//        System.out.println(maxY);
        int height=30;
        int width=30;
        GridPane grid = new GridPane();
//        grid.add(new Label("malpka"),0,0);
        grid.add(new Label("chomik"),4,5);
        grid.setGridLinesVisible(true);
        /*
        Defines optional layout constraints for a column in a GridPane.
        If a ColumnConstraints object is added for a column in a gridpane,
        the gridpane will use those constraint values when computing the column's width and layout.
         */

        grid.getColumnConstraints().add(new ColumnConstraints(width));
        Label labelxy = new Label("y/x");

        /*
        Defines optional layout constraints for a row in a GridPane.
        If a RowConstraints object is added for a row in a gridpane,
        the gridpane will use those constraint values when computing the row's height and layout.

         */

        grid.getRowConstraints().add(new RowConstraints(height));
        GridPane.setHalignment(labelxy, HPos.CENTER);
        grid.add(labelxy, 0, 0);

        for (int i = 1; i <= maxX - minX + 1; i++){
//            System.out.println("i = " + i);
            Label label = new Label(Integer.toString(minX + i -1));
//            System.out.println("minX + i -1 = " + (minX + i -1));
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, i, 0);
        }
        for (int i =1 ; i <=  maxY - minY + 1; i++){
            Label label = new Label(Integer.toString(maxY-i+1));
            grid.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, 0,i);
        }
        for (int x=minX;x<=maxX;x++){
            for (int y=minY;y<=maxY;y++){
                Vector2d position = new Vector2d(x,y);
                Object object=  map.objectAt(position);
                if (object!=null){
                    Label label = new Label(object.toString());
                    grid.add(label, position.getX() - minX + 1, maxY - position.getY() + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(grid, (maxX-minX+2)*width, (maxY-minY+2)*height);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
