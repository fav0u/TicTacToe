import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    //set up for all tests:
    private TicTacToe game;
    private Player player1;
    private Player player2;

    @BeforeEach
        //gets called each time before a test is run
    void setUp() {
        player1 = new Player("Player1", 'X');
        player2 = new Player("Player2", 'O');
        game = new TicTacToe(player1, player2);
    }

    @Test
    void switchPlayer_switchingPlayerOnce() {
        game.switchPlayer();
        assertEquals(player2, game.getCurrentPlayer(), "Should return player2 instance");

    }

    @Test
    void switchPlayer_switchingPlayerTwice() {
        game.switchPlayer();
        assertEquals(player2, game.getCurrentPlayer(), "Should return player2 instance");
        game.switchPlayer();
        assertEquals(player1, game.getCurrentPlayer(), "should return player1 instance");
    }
    @Test
    void checkEmptyField_allFieldsEmpty() {
        for (int i = 1; i < 10; i++) {
            assertTrue(game.checkEmptyField(i));
        }
    }

    @Test
    void checkEmptyField_invalidFieldNumber() {
        assertFalse(game.checkEmptyField(10));
        assertFalse(game.checkEmptyField(0));
        assertFalse(game.checkEmptyField(-1));
    }

    @Test
    void checkEmptyField_notEmptyAfterMove() {
        game.makeMove(5);
        assertFalse(game.checkEmptyField(5));
    }
}
