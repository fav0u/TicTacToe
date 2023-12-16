public class TicTacToe {
        private char[][] board;
        private Player player1;
        private Player player2;
        private Player currentPlayer;

    public TicTacToe() {
        this.board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        this.player1 = new Player("Player1", 'X');
        this.player2 = new Player("Player2", 'O');
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
}

