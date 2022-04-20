package com.tictactoe.tictactoecontroller;

import javafx.application.Platform;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControllerClient {
    private final String hostname;
    private final int port;
    private final TicTacToeController controller;

    public ControllerClient(String hostname, int port, TicTacToeController controller) {
        this.hostname = hostname;
        this.port = port;
        this.controller = controller;
    }

    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);
            print("Connected to the TestServer");
            new ReadThread(socket, this).start();
        } catch (UnknownHostException ex) {
            print("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            print("I/O Error: " + ex.getMessage());
        }
    }

    void print(String message) {
        Platform.runLater(() -> controller.update(message));
    }
}
