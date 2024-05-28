import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Ask user if they want to start the game
        System.out.println("Would you like to start the game? Y/N");
        String start = input.nextLine();
        //if Y start game
        if(start.equals("Y")){
            //create new Board
            Board board = new Board();
            System.out.println("Starting board");
            board.createBoard();
            board.printBoard();
            board.printHidden();

            //ask if user want to play with hint
            System.out.println("Would you like to play with hints? Y/N");
            String hint = input.nextLine();
            Play play;
            //play with hint
            if(hint.equals("Y")){
                play = new Hint(board);
            }
            //play without hint
            else{
                play = new Play(board);
            }
            //ask user
            play.ask();
        }
        else{
            System.out.println("Game over");
        }


    }
}