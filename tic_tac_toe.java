@SupportedAnnotationTypes("com.example.tictactoe.MyAnnotation")
public class TicTacToe {

    private char[][] board;
    private Player currentPlayer;
    private boolean gameOver;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }

        currentPlayer = Player.X;
        gameOver = false;
    }

    public void start() {
        while (!gameOver) {
            takeTurn();
            checkWinner();
        }

        announceWinner();
    }

    private void takeTurn() {
        int row = currentPlayer.chooseRow();
        int column = currentPlayer.chooseColumn();

        if (board[row][column] == '-') {
            board[row][column] = currentPlayer.getSymbol();
            currentPlayer = currentPlayer.getOpponent();
        } else {
            System.out.println("Invalid move. Please try again.");
        }
    }

    private void checkWinner() {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                gameOver = true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                gameOver = true;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            gameOver = true;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            gameOver = true;
        }
    }

    private void announceWinner() {
        if (gameOver) {
            System.out.println(currentPlayer.getSymbol() + " wins!");
        } else {
            System.out.println("Tie!");
        }
    }

    public enum Player {
        X, O;

        public char getSymbol() {
            return this == X ? 'X' : 'O';
        }

        public Player getOpponent() {
            return this == X ? O : X;
        }


        public int chooseColumn() {
            System.out
        }
    }
}
}
