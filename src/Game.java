public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player whoIsPlaying;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        whoIsPlaying = player2;
    }

    public void playRound(int row, int column) throws GameException {
        nextRound();
        char c = whoIsPlaying.getChar();

        if (!board.isSpaceEmpty(row, column)) {
            throw new GameException("The space is already chosen");
        }

        board.placeChar(c, row, column);
    }

    private void nextRound() {
        if (whoIsPlaying.equals(player1)) {
            whoIsPlaying = player2;
        } else if (whoIsPlaying.equals(player2)) {
            whoIsPlaying = player1;
        }
    }

    public void dontSwitchPlayer() {
        nextRound();
    }

    public boolean checkGameOver() {

        char[][] field = board.getField();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if ((field[i][0] == player1.getChar() && field[i][1] == player1.getChar()
                        && field[i][2] == player1.getChar()) || (field[i][0] == player2.getChar()
                        && field[i][1] == player2.getChar() && field[i][2] == player2.getChar())) {
                    return true;
                } else if ((field[0][j] == player1.getChar() && field[1][j] == player1.getChar()
                        && field[2][j] == player1.getChar()) || (field[0][j] == player2.getChar()
                        && field[1][j] == player2.getChar() && field[2][j] == player2.getChar())) {
                    return true;
                }
            }
        }
        if ((field[0][0] == player1.getChar() && field[1][1] == player1.getChar()
                && field[2][2] == player1.getChar()) || (field[0][0] == player2.getChar()
                && field[1][1] == player2.getChar() && field[2][2] == player2.getChar())) {
            return true;
        } else {
            return isDraw();
        }
    }

    private boolean isDraw() {
        char[][] field = board.getField();
        char[][] defaultField = new char[3][3];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                defaultField[i][j] = '*';
                if (defaultField[i][j] == field[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void restart() {
        board = new Board();
    }

    public Player getWinner() {
        return whoIsPlaying;
    }

    public Board getBoard() {
        return board;
    }
}
