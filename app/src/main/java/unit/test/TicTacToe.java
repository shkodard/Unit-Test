package unit.test;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';  // X beginnt immer
        gameEnded = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean playMove(int row, int col) {
        if (gameEnded || row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false; // Kein Zug möglich, wenn das Spiel beendet ist oder das Feld ungültig oder belegt ist.
        }
        board[row][col] = currentPlayer;
        if (hasWon(currentPlayer)) {
            gameEnded = true;
        } else if (isFull()) {
            gameEnded = true; // Überprüft, ob das Brett voll ist und setzt das Spiel als beendet, wenn ja.
        } else {
            switchPlayer();
        }
        return true;
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean hasWon(char player) {
        for (int i = 0; i < 3; i++) {
            // Überprüfung der Reihen und Spalten
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Überprüfung der Diagonalen
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean isDraw() {
        return isFull() && !hasWon('X') && !hasWon('O');
    }

}
