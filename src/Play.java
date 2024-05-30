import java.util.Scanner;
public class Play implements Askable{

    //create new board
    public Board board;

    /*
    //initialize board
    // @param Board board
    // @return
     */
    public Play(Board board){
        this.board = board;
    }

    /*
    //ask user to input row and column
    // @param
    // @return
     */
    public void ask(){
        Scanner input = new Scanner(System.in);
        while(!gameOver()){
            //ask user to input row 1 and column 1
            System.out.println("Enter row #1: ");
            int row1 = input.nextInt();
            System.out.println("Enter column #1: ");
            int col1 = input.nextInt();
            board.updateBoard(row1,col1);
            board.printBoard();

            //ask user to input row 2 and column 2
            System.out.println("Enter row #2: ");
            int row2 = input.nextInt();
            System.out.println("Enter column #2: ");
            int col2 = input.nextInt();
            board.updateBoard(row2,col2);
            board.printBoard();
            //check if letters equal
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
        System.out.println("Game Over!!");
    }

    /*
    // check if letters equal
    // @param int row1,int col1, int row2, int col2
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
    // play until board is complete
    // @param
    // @return boolean
     */
    public boolean gameOver(){
        return board.matched();
    }
}
