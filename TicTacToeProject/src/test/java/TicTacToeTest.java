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

    @Test
    void makeMove_moveOnValidFields() {

        for(int i = 1; i < 10; i++) {
            game.makeMove(i);
        }
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[0][0]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[0][1]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[0][2]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[1][0]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[1][1]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[1][2]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[2][0]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[2][1]);
        assertEquals(game.getCurrentPlayer().getSymbol(), game.getBoard()[2][2]);
    }

    @Test
    void makeMove_moveOnInvalidField() {
        assertFalse(game.makeMove(10));
        assertFalse(game.makeMove(0));
        assertFalse(game.makeMove(-1));
    }

    @Test
    void randomNumber_generatesNumberNine() {
    //Arrange board
        char[][] testBoard = {
                {'X', 'O', 'X'},
                {'X', 'O', 'X'},
                {'O', 'X', ' '} // nur Feld 9 bleibt frei
        };
        game.setBoard(testBoard);
        //Act
        int randomNr = game.randomNumber();
        //Assert
        assertEquals(9, randomNr);
    }

    @Test
    public void isWin_Win() {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        TicTacToe game = new TicTacToe(player1, player2);

        char[][] winningBoard = {
                {'X', 'X', 'X'},
                {'O', ' ', ' '},
                {' ', 'O', ' '}
        };

        boolean result = game.isWin(winningBoard, 'X');
        assertTrue(result);
    }

    @Test
    public void isWin_NoWin() {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        TicTacToe game = new TicTacToe(player1, player2);

        char[][] noWinningBoard = {
                {'X', 'O', 'X'},
                {'X', 'O', ' '},
                {'O', 'X', ' '}
        };

        boolean result = game.isWin(noWinningBoard, 'X');
        assertFalse(result);
    }

    @Test
    public void isDraw_Draw() {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        TicTacToe game = new TicTacToe(player1, player2);

        char[][] drawBoard = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };

        game.setBoard(drawBoard);
        boolean result = game.isDraw(drawBoard);
        assertTrue(result);
    }

    @Test
    public void isDraw_NoDraw() {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        TicTacToe game = new TicTacToe(player1, player2);

        char[][] noDrawBoard = {
                {'X', 'O', 'X'},
                {' ', 'X', 'O'},
                {'O', 'X', ' '}
        };

        game.setBoard(noDrawBoard);
        boolean result = game.isDraw(noDrawBoard);
        assertFalse(result);
    }
}
