package unit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    public void testWinCondition() {
        TicTacToe game = new TicTacToe();
        game.playMove(0, 0); // X
        game.playMove(1, 0); // O
        game.playMove(0, 1); // X
        game.playMove(1, 1); // O
        game.playMove(0, 2); // X gewinnt hier
    
        assertTrue(game.hasWon('X')); // Überprüft, ob X gewonnen hat
    }

    @Test
    public void testDrawCondition() {
    TicTacToe game = new TicTacToe();
    // Spielen eines kompletten Spiels ohne Gewinner
    game.playMove(0, 0); // X
    game.playMove(0, 1); // O
    game.playMove(0, 2); // X
    game.playMove(1, 1); // O
    game.playMove(1, 0); // X
    game.playMove(1, 2); // O
    game.playMove(2, 1); // X
    game.playMove(2, 0); // O
    game.playMove(2, 2); // X
    assertTrue(game.isDraw(), "Das Spiel sollte unentschieden sein.");
}


    @Test
    public void testPlayerSwitchAfterMove() {
        TicTacToe game = new TicTacToe();
        game.playMove(0, 0); // X macht den ersten Zug
        assertEquals('O', game.getCurrentPlayer()); // Prüft, ob der Spieler zu O gewechselt hat
        game.playMove(0, 1); // O macht den nächsten Zug
        assertEquals('X', game.getCurrentPlayer()); // Prüft, ob der Spieler zurück zu X gewechselt hat
    }

    @Test
    public void testInvalidMoveOnOccupiedCell() {
        TicTacToe game = new TicTacToe();
        game.playMove(0, 0); // X macht den ersten Zug
        assertFalse(game.playMove(0, 0), "Sollte falsch zurückgeben, wenn ein Feld bereits belegt ist"); // Versuch, erneut auf dasselbe Feld zu setzen
        assertEquals('X', game.getBoard()[0][0]); // Überprüft, ob der ursprüngliche Wert erhalten bleibt
    }

    @Test
    public void testGameEndsAfterWin() {
        TicTacToe game = new TicTacToe();
        game.playMove(0, 0); // X
        game.playMove(1, 0); // O
        game.playMove(0, 1); // X
        game.playMove(1, 1); // O
        game.playMove(0, 2); // X gewinnt hier
        
        assertTrue(game.hasWon('X'), "X sollte das Spiel gewonnen haben.");
        assertFalse(game.playMove(2, 2), "Kein Zug sollte nach dem Gewinn möglich sein.");
    }
    
    @Test
    public void testOccupiedCellMove() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.playMove(0, 0)); // X macht den ersten Zug
        assertFalse(game.playMove(0, 0)); // Versuch, erneut auf dasselbe Feld zu setzen
        assertEquals('X', game.getBoard()[0][0]); // Überprüfen, ob der ursprüngliche Wert erhalten bleibt
    }

    @Test
    public void testInvalidMoveOutsideBoard() {
    TicTacToe game = new TicTacToe();
    assertFalse(game.playMove(3, 3), "Sollte falsch zurückgeben, wenn der Zug außerhalb des Spielfelds liegt");
    // Überprüfen, ob das Spielfeld unverändert bleibt
    assertEquals(' ', game.getBoard()[0][0], "Das Feld außerhalb des Spielfelds sollte unverändert sein");
    }

    @Test
    public void testAlternatePlayerTurn() {
    TicTacToe game = new TicTacToe();
    assertEquals('X', game.getCurrentPlayer()); // Überprüfen, ob Spieler X beginnt
    assertTrue(game.playMove(0, 0)); // Spieler X setzt
    assertEquals('O', game.getCurrentPlayer()); // Überprüfen, ob Spielerwechsel zu O erfolgt ist
    assertTrue(game.playMove(0, 1)); // Spieler O setzt
    assertEquals('X', game.getCurrentPlayer()); // Überprüfen, ob Spielerwechsel zu X erfolgt ist
    assertTrue(game.playMove(1, 1)); // Spieler X setzt
    assertEquals('O', game.getCurrentPlayer()); // Überprüfen, ob Spielerwechsel zu O erfolgt ist
    }

    @Test
    public void testWinInRow() {
    TicTacToe game = new TicTacToe();
    // X gewinnt durch eine volle Reihe
    game.playMove(0, 0); // X
    game.playMove(1, 0); // O
    game.playMove(0, 1); // X
    game.playMove(1, 1); // O
    game.playMove(0, 2); // X
    assertTrue(game.hasWon('X'), "X sollte das Spiel gewonnen haben.");
    }

    @Test
    public void testWinInDiagonal() {
    TicTacToe game = new TicTacToe();
    // X gewinnt durch eine Diagonale
    game.playMove(0, 0); // X
    game.playMove(0, 1); // O
    game.playMove(1, 1); // X
    game.playMove(0, 2); // O
    game.playMove(2, 2); // X
    assertTrue(game.hasWon('X'), "X sollte das Spiel gewonnen haben.");
    }

}