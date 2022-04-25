package com.tictactoe.tictactoecontroller;

import com.tictactoe.message.*;

public class GameController {
    private String gameName;
    private char playerToken;
    private int move;
    private char [] boardState;

    public char changePlayer() {
        return playerToken == 'X' ? 'O' : 'X';
    }

    public boolean isFullBoard() {
        return !(boardState[0] == 0) && !(boardState[1] == 0) && !(boardState[2] == 0) &&
                !(boardState[3] == 0) && !(boardState[4] == 0) && !(boardState[5] == 0) &&
                !(boardState[6] == 0) && !(boardState[7] == 0) && !(boardState[8] == 0);
    }

    public String checkIfGameOver() {
        for (int i = 0; i < 3; ++i) {
            if (boardState[3 * i] == boardState[3 * i + 1] && boardState[3 * i] == boardState[3 * i + 2]) {
                if (boardState[3 * i] == 'X') return "X";
                else if (boardState[3 * i] == 'O') return "O";
            }
            if (boardState[i] == boardState[3 + i] && boardState[i] == boardState[6 + i]) {
                if (boardState[i] == 'X') return "X";
                else if (boardState[i] == 'O') return "O";
            }
        }
        if (boardState[0] == boardState[4] && boardState[0] == boardState[8]) {
            if (boardState[0] == 'X') return "X";
            else if (boardState[0] == 'O') return "O";
        }
        if (boardState[6] == boardState[4] && boardState[6] == boardState[2]) {
            if (boardState[6] == 'X') return "X";
            else if (boardState[6] == 'O') return "O";
        }
        if (isFullBoard()) return "D";
        else return "N";
    }

    public PlayerMoveResult moveResult(PlayerMoveSend playerMoveSend) {
        gameName = playerMoveSend.GameName();
        playerToken = playerMoveSend.playerToken();
        move = playerMoveSend.move();
        boardState = playerMoveSend.boardState();
        boardState[move] = playerToken;
        String result = checkIfGameOver();
        char nextPlayer = changePlayer();

        return new PlayerMoveResult(gameName, nextPlayer, move, result);
    }
}
