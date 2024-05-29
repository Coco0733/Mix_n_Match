import java.util.Scanner;
public class Hint extends Play implements Askable{
    public Hint(Board board) {
        super(board);
    }

    /*
    //ask user to input row and column
    // @param
    // @return
     */
    public void ask() {
        Scanner input = new Scanner(System.in);
        //play until game over
        while (!gameOver()) {
            //ask user to input row 1
            System.out.println("Enter row #1: ");
            int row1 = input.nextInt();
            System.out.println("Enter column #1: ");
            int col1 = input.nextInt();
            board.updateBoard(row1, col1);
            board.printBoard();

            if (board.getLetter(row1, col1).equals("a")) {
                giveHint(row1, col1);
            }

            System.out.println("Enter row #2: ");
            int row2 = input.nextInt();
            System.out.println("Enter column #2: ");
            int col2 = input.nextInt();
            board.updateBoard(row2, col2);
            board.printBoard();

            if (!equals(row1, col1, row2, col2)) {
                System.out.println("Does not match");
                board.redoBoard(row1, col1);
                board.redoBoard(row2, col2);
                System.out.println("Redoing board...");
                board.printBoard();
            } else {
                System.out.println("Found a match!!");
            }
        }
        System.out.println("Game Over!!");
    }

    private void giveHint(int row1, int col1) {
        int row2 = board.getRowA();
        int col2 = board.getColA();
        System.out.println("Hint: Letter A are at (" + row1 + "," + col1 + ") and (" + row2 + "," + col2 + ")");
    }
}
