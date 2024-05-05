package unit.test;

import java.util.Arrays;

public class GameBoard {
    private char[][] board;
    public static final int SIZE = 3;

    public GameBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    public boolean setMove(char player, int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public char[][] getBoard() {
        return board;
    }
}
