package com.tictactoe.tictactoecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class TicTacToeController {
    private ControllerClient server;
    @FXML
    public Button startButton;
    @FXML
    public TextArea ta;

    public void update(String message) {
        ta.appendText(message);
    }

    public void onStartClicked(MouseEvent mouseEvent) {
        server = new ControllerClient("localhost",8000, this);
        server.execute();
        startButton.setVisible(false);
    }
}