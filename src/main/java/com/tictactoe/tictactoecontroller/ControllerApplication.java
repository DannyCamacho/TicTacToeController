package com.tictactoe.tictactoecontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ControllerApplication.class.getResource("controller-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 400);
        stage.setTitle("Tic-Tac-Toe Controller");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}