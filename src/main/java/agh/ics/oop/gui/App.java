package agh.ics.oop.gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    Label label = new Label("Zwierzak");
    Scene scene = new Scene(label, 400, 400);


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
