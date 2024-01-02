import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkStatus_whenWinCondition() {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        TicTacToe game = new TicTacToe(player1, player2);


        char[][] testBoard = {
                {'X', 'X', 'X'},
                {' ', 'O', ' '},
                {' ', ' ', 'O'}
        };

        game.setBoard(testBoard);


        assertTrue(Main.checkStatus(game));
    }

    @Test
    void checkStatus_whenDrawCondition() {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        TicTacToe game = new TicTacToe(player1, player2);


        char[][] testBoard = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'O', 'X', 'O'}
        };

        game.setBoard(testBoard);

        assertTrue(Main.checkStatus(game));
    }

    @Test
    void checkStatus_whenContinuingGame() {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        TicTacToe game = new TicTacToe(player1, player2);


        char[][] testBoard = {
                {'X', 'O', 'X'},
                {' ', 'X', ' '},
                {'O', ' ', ' '}
        };

        game.setBoard(testBoard);

        assertFalse(Main.checkStatus(game));
    }
}
