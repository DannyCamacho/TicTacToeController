package com.tictactoe.tictactoecontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TicTacToeController {
    @FXML
    public Button startButton;
    @FXML
    public TextArea ta;

    public void update(String message) {
        ta.appendText(message);
    }

    public void onStartClicked() {
        ControllerClient server = new ControllerClient("localhost", 8000, this);
        server.execute();
        startButton.setVisible(false);
    }
}