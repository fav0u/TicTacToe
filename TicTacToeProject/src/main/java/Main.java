import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');

        System.out.println("Hello Player 1, please enter your name");
        String player1name = scanner.next();
        player1.setName(player1name);

        while (replay) {
        System.out.println("Hello " + player1.getName() + ", please choose the game mode:");
        System.out.println("Press (1) to play against the Computer, press (2) to play against another human");
        int gameMode = scanner.nextInt();

        if (gameMode == 2) {
            System.out.println("Hello Player 2, please enter your name");
            String player2name = scanner.next();
            player2.setName(player2name);
            System.out.println("Hello " + player2.getName());
        }
        if (gameMode == 1) {
            player2.setName("Computer");
        }

            System.out.println("Welcome to TicTacToe Game");
            TicTacToe game = new TicTacToe(player1, player2);

            
    }
}
