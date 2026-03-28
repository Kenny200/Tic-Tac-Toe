@SupportedAnnotationTypes("com.example.tictactoe.MyAnnotation")
public class TicTacToeDriver {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        while (!game.isGameOver()) {
            int row = chooseRow();
            int column = chooseColumn();

            game.takeTurn(row, column);
        }

        game.announceWinner();

        //start the game
        TicTacToeDriver.main(null);
    }

    private static int chooseRow() {
        System.out.println("Player " + game.getCurrentPlayer().getSymbol() + ", choose a row (1-3): ");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        while (row < 1 || row > 3) {
            System.out.println("Invalid row. Please try again.");
            row = scanner.nextInt();
        }
        return row - 1;
    }
}
