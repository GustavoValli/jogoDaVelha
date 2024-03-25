public class UI {

    public static void printScreen(Game game) {
        char[][] field = game.getBoard().getField();

        for (int i = 0; i < field.length; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("   0 1 2");
    }
}
