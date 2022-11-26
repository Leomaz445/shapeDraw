package com.example.shapedraw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShapeDraw extends Application {
    public static final int SCENE_MAX_HEIGHT = 400;
    public static final int SCENE_MAX_WIDTH = 400;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ShapeDraw.class.getResource("draw-shape.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), SCENE_MAX_WIDTH, SCENE_MAX_HEIGHT);
        stage.setTitle("Draw Shapes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}