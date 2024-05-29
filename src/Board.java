import java.util.Random;
import java.util.ArrayList;

public class Board {

    //make board and hidden board
    private String[][] board;
    private String[][] hidden;


    //initialize board with _
    public Board(){
        board = new String[3][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "_"; // Fill the board with default values
            }
        }
        hidden = new String[3][4];
    }
    /*
    //create board
    // @param
    // @return
     */
    public void createBoard(){
        ArrayList<String> letters = new ArrayList<String>();
        //add letters a-f 2 times in arraylist
        for (char c = 'a'; c <= 'f'; c++) {
            letters.add(String.valueOf(c));
            letters.add(String.valueOf(c));
        }
        Random rand = new Random();
        for(int i = 0; i < hidden.length; i++){
            for(int j = 0; j < hidden[i].length; j++){
                int ran = rand.nextInt(letters.size());
                hidden[i][j] = letters.get(ran);
                letters.remove(ran);
            }
        }
    }

    public void resetBoard(){
        board = new String[][]{{"_","_","_"},
                                {"_","_","_"},
                                {"_","_","_"},
                                {"_","_","_"}};
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printHidden(){
        for (int i = 0; i < hidden.length; i++) {
            for (int j = 0; j < hidden[i].length; j++) {
                System.out.print(hidden[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int getRowA(){
        int row = 0;
        for(int i = 0; i < hidden.length; i++){
            for(int j = 0; j < hidden[i].length; j++){
                if(hidden[i][j].equals("a")){
                    row = i;
                }
            }
        }
        return row;
    }

    public int getColA(){
        int col = 0;
        for(int i = 0; i < hidden.length; i++){
            for(int j = 0; j < hidden[i].length; j++){
                if(hidden[i][j].equals("a")){
                    col = j;
                }
            }
        }
        return col;
    }


    public void updateBoard(int row, int col){
        board[row][col] = hidden[row][col];
    }

    public void redoBoard(int row, int col){
        board[row][col] = "_";
    }

    public String getLetter(int row, int col){
        return board[row][col];
    }

    public boolean matched() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }
}
