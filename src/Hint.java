import java.util.Scanner;
public class Hint extends Play implements Askable{
    public Hint(Board board) {
        super(board);
    }

    /*
    // ask the user to input 2 row and 2 columns
    // continue to ask until game is over
    // @param
    // @return
     */
    public void ask() {
        Scanner input = new Scanner(System.in);
        //continue to ask until game is complete
        while (!gameOver()) {
            // ask user to input 1st row and 1st col
            System.out.println("Enter row #1: ");
            int row1 = input.nextInt();
            System.out.println("Enter column #1: ");
            int col1 = input.nextInt();
            board.updateBoard(row1, col1);
            board.printBoard();

            //if user selects letter a, give user a hint
            if (board.getLetter(row1, col1).equals("a")) {
                giveHint(row1, col1);
            }
            //ask user to input 2nd row and 2nd col
            System.out.println("Enter row #2: ");
            int row2 = input.nextInt();
            System.out.println("Enter column #2: ");
            int col2 = input.nextInt();
            board.updateBoard(row2, col2);
            board.printBoard();
            //Check if two letter match
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
        //If all cards are matched, print game over
        System.out.println("Game Over!!");
    }

    /*
    // Give a hint to user where the two location for letter a is at
    // @param int row, int col
    // @return
    */
    private void giveHint(int row1, int col1) {
        int row2 = board.getRowA();
        int col2 = board.getColA();
        //Print where the 2 location for letter a is at
        System.out.println("Hint: Letter A are at (" + row1 + "," + col1 + ") and (" + row2 + "," + col2 + ")");
    }
}
