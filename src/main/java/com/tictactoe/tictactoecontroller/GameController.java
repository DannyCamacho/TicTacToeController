package com.tictactoe.tictactoecontroller;

import com.tictactoe.message.*;

public class GameController {
    public char changePlayer(char playerToken) {
        return playerToken == 'X' ? 'O' : 'X';
    }

    public boolean isFullBoard(char [] boardState) {
        return !(boardState[0] == 0) && !(boardState[1] == 0) && !(boardState[2] == 0) &&
               !(boardState[3] == 0) && !(boardState[4] == 0) && !(boardState[5] == 0) &&
               !(boardState[6] == 0) && !(boardState[7] == 0) && !(boardState[8] == 0);
    }

    public String checkIfGameOver(char [] boardState) {
        for (int i = 0; i < 3; ++i) {
            if (boardState[3 * i] == boardState[3 * i + 1] && boardState[3 * i] == boardState[3 * i + 2]) {
                if (boardState[3 * i] == 'X') return "X" + i;
                else if (boardState[3 * i] == 'O') return "O" + i;
            }
            if (boardState[i] == boardState[3 + i] && boardState[i] == boardState[6 + i]) {
                if (boardState[i] == 'X') return "X" + (i + 3);
                else if (boardState[i] == 'O') return "O" + (i + 3);
            }
        }
        if (boardState[0] == boardState[4] && boardState[0] == boardState[8]) {
            if (boardState[0] == 'X') return "X6";
            else if (boardState[0] == 'O') return "O6";
        }
        if (boardState[6] == boardState[4] && boardState[6] == boardState[2]) {
            if (boardState[6] == 'X') return "X7";
            else if (boardState[6] == 'O') return "O7";
        }
        if (isFullBoard(boardState)) return "D8";
        else return "N";
    }

    public PlayerMoveResult moveResult(PlayerMoveSend playerMoveSend) {
        String gameName = playerMoveSend.GameName();
        char playerToken = playerMoveSend.playerToken();
        int move = playerMoveSend.move();
        char [] boardState = playerMoveSend.boardState();

        boardState[move] = playerToken;
        String result = checkIfGameOver(boardState);
        char nextPlayer = changePlayer(playerToken);

        return new PlayerMoveResult(gameName, nextPlayer, move, result);
    }
}
