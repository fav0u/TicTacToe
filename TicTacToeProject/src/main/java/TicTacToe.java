import java.util.Random;

public class TicTacToe {
        private char[][] board;
        private Player player1;
        private Player player2;
        private Player currentPlayer;

    public TicTacToe(Player player1, Player player2) {
        this.board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

    }
    public void makeMove(int fieldNr) {
        switch (fieldNr) {
            case 1 -> board[0][0] = currentPlayer.getSymbol();
            case 2 -> board[0][1] = currentPlayer.getSymbol();
            case 3 -> board[0][2] = currentPlayer.getSymbol();
            case 4 -> board[1][0] = currentPlayer.getSymbol();
            case 5 -> board[1][1] = currentPlayer.getSymbol();
            case 6 -> board[1][2] = currentPlayer.getSymbol();
            case 7 -> board[2][0] = currentPlayer.getSymbol();
            case 8 -> board[2][1] = currentPlayer.getSymbol();
            case 9 -> board[2][2] = currentPlayer.getSymbol();
            default -> System.out.println("Invalid move");
        }
    }
   public int randomNumber() {
        Random random = new Random();
        int randFieldNr = -1;
        do {
            randFieldNr = random.nextInt(9) + 1;
        } while(!checkEmptyField(randFieldNr));
        return randFieldNr;
    }

    public boolean isWin(char[][] board, char symbol) {
        //Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
                String winner = (symbol == player1.getSymbol()) ? player1.getName() : player2.getName();
                System.out.println("Game is won. Player " + winner + " has won");
                return true;
            }
        }
        //CHeck columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
                String winner = (symbol == player1.getSymbol()) ? player1.getName() : player2.getName();
                System.out.println("Game is won. Player " + winner + " has won");
                return true;
            }

        }
        //Check diagonals
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            String winner = (symbol == player1.getSymbol()) ? player1.getName() : player2.getName();
            System.out.println("Game is won. Player " + winner + " has won");
            return true;
        }

        return false;
    }

    public boolean isDraw(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if(board[row][col] == ' ') return false;
            }
        }
        System.out.println("Game is a draw");
        return true;
    }
}

