import java.util.Scanner;
public class Play implements Askable{
    public Board board;

    public Play(Board board){
        this.board = board;
    }

    public void ask(){
        Scanner input = new Scanner(System.in);
        while(!gameOver()){
            // ask user to input 1st row and 1st col
            System.out.println("Enter row #1: ");
            int row1 = input.nextInt();
            System.out.println("Enter column #1: ");
            int col1 = input.nextInt();
            board.updateBoard(row1,col1);
            board.printBoard();

            // ask user to input 2nd row and 2nd col
            System.out.println("Enter row #2: ");
            int row2 = input.nextInt();
            System.out.println("Enter column #2: ");
            int col2 = input.nextInt();
            board.updateBoard(row2,col2);
            board.printBoard();

            //Check if two letter match
            if(!equals(row1,col1,row2,col2)){
                System.out.println("does not equal");
                board.redoBoard(row1,col1);
                board.redoBoard(row2,col2);
                System.out.println("Redoing board...");
                board.printBoard();
            }
            else{
                System.out.println("Found a match!!");
            }
        }
        //If all cards are matched, print game over
        System.out.println("Game Over!!");
    }

    /*
    //Check if letter at row1, col1 and row2, col2 are the same
    // @param row1, col1, row2, col2  int for row and col
    // @return boolean
     */
    public boolean equals(int row1,int col1, int row2, int col2){
        if(board.getLetter(row1,col1).equals(board.getLetter(row2,col2))){
            return true;
        }
        else{
            return false;
        }
    }

    /*
    //check if the game is finished
    //calls match method in board class
    // @param
    // @return boolean
     */
    public boolean gameOver(){
        return board.matched();
    }
}
