package com.tictactoe.tictactoecontroller;

import com.tictactoe.message.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;

public class ReadThread extends Thread {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private final ControllerClient client;
    private final GameController gameController;

    public ReadThread(Socket socket, ControllerClient client) {
        this.client = client;
        gameController = new GameController();
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            output.writeObject(new ServerConnection("Controller", "Game Controller", true));
            output.flush();
        } catch (IOException ex) {
            client.print("\nError getting input stream: " + ex.getMessage() + "\n");
        }
    }

    public void run() {
        while (true) {
            try {
                PlayerMoveSend move = (PlayerMoveSend)input.readObject();
                PlayerMoveResult result = gameController.moveResult(move);
                client.print("\nGame [" + move.gameName() +
                             "] Move [" + move.move() +
                             "] Token [" + move.playerToken() +
                             "] Board " + Arrays.toString(move.boardState()) +
                             " Result [" + result.result() + "]");
                output.writeObject(result);
                output.flush();
            } catch (IOException | ClassNotFoundException ex) {
                client.print("\nError reading from server: " + ex.getMessage()+ "\n");
                break;
            }
        }
    }
}