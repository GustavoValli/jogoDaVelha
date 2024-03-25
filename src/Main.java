import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the symbol for player1: ");
        char c1 = scanner.next().charAt(0);
        System.out.print("Enter the symbol for player2: ");
        char c2 = scanner.next().charAt(0);

        Board board = new Board();
        Game game = new Game(board, new Player(c1), new Player(c2));

        boolean playAgain = true;
        while (playAgain) {
            do {
                try {
                    UI.printScreen(game);
                    System.out.println("Enter the coordinates: (row/column)");
                    String string = scanner.next();
                    int cordX = Character.getNumericValue(string.charAt(0));
                    int cordY = Character.getNumericValue(string.charAt(2));
                    game.playRound(cordX, cordY);
                } catch (GameException e) {
                    game.dontSwitchPlayer();
                    System.out.println(e.getMessage() + "\n");
                } catch (ArrayIndexOutOfBoundsException e) {
                    game.dontSwitchPlayer();
                    System.out.println("The position is not valid");
                }
            } while (!game.checkGameOver());
            System.out.println("\n\n\n\n\n\n");
            UI.printScreen(game);
            System.out.println("\n The '" + game.getWinner().getChar() + "' win!!!");
            System.out.print("Do you want to play again? (y/n): ");
            char answer = scanner.next().charAt(0);
            if (answer == 'n') {
                playAgain = false;
            }
            game.restart();
        }

    }
}