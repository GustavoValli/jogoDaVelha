public class Board {

    private char[][] field = new char[3][3];
    private char defaultChar = '*';

    public Board () {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = defaultChar;
            }
        }
    }

    public boolean isSpaceEmpty(int row, int column) {
        return field[row][column] == defaultChar;
    }

    public boolean isPositionValid(int row, int column) {
        return row >= 0 && row <3 && column >= 0 && column <3;
    }

    public void placeChar(char c, int row, int column) {
        field[row][column] = c;
    }

    public char[][] getField() {
        return field;
    }
}
