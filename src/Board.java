import java.util.Random;
import java.util.ArrayList;

public class Board {
    //make new board
    private String[][] board;
    private String[][] hidden;

    public Board(){
        board = new String[3][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Fill the board with default values
                board[i][j] = "_";
            }
        }
        hidden = new String[3][4];
    }
    /*
    // create a hidden board of 3x4
    // randomize letters a-f throughout the board
    // @param
    // @return
    */
    public void createBoard(){
        ArrayList<String> letters = new ArrayList<String>();
        //add 2 of each letter a-f to arraylist
        for (char c = 'a'; c <= 'f'; c++) {
            letters.add(String.valueOf(c));
            letters.add(String.valueOf(c));
        }
        //randomize each letter to a set location
        Random rand = new Random();
        for(int i = 0; i < hidden.length; i++){
            for(int j = 0; j < hidden[i].length; j++){
                int ran = rand.nextInt(letters.size());
                hidden[i][j] = letters.get(ran);
                letters.remove(ran);
            }
        }
    }

    /*
    // print the board
    // @param
    // @return
    */
    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    // print the board with letters added
    // @param
    // @return
    */
    public void printHidden(){
        for (int i = 0; i < hidden.length; i++) {
            for (int j = 0; j < hidden[i].length; j++) {
                System.out.print(hidden[i][j] + " ");
            }
            System.out.println();
        }

    }
    /*
    // get the row of where letter a falls
    // @param
    // @return int
    */
    public int getRowA(){
        int row = 0;
        for(int i = 0; i < hidden.length; i++){
            for(int j = 0; j < hidden[i].length; j++){
                //check if the location is a
                if(hidden[i][j].equals("a")){
                    //store the row with letter a
                    row = i;
                }
            }
        }
        return row;
    }

    /*
    // get the column of where letter a falls
    // @param
    // @return int
    */
    public int getColA(){
        int col = 0;
        for(int i = 0; i < hidden.length; i++){
            for(int j = 0; j < hidden[i].length; j++){
                //check if location is a
                if(hidden[i][j].equals("a")){
                    //store the column with letter a
                    col = j;
                }
            }
        }
        return col;
    }


    /*
    // update the Board based on user input
    // @param int row, int col
    // @return
    */
    public void updateBoard(int row, int col){
        //set hidden answer to board shown to the user
        board[row][col] = hidden[row][col];
    }

    /*
    // undo the Board based on user input
    // @param int row, int col
    // @return
    */
    public void redoBoard(int row, int col){
        board[row][col] = "_";
    }

    /*
    // update the Board based on user input
    // @param int row, int col
    // @return String  the letter at a location
    */
    public String getLetter(int row, int col){
        return board[row][col];
    }

    /*
    // check if all the places on the board is matched
    // @param
    // @return boolean  if board is completely matched or not
    */
    public boolean matched() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //check if anything on board is still _
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }
}
