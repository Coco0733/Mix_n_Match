import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Would you like to start the game? Y/N");
        String start = input.nextLine();
        if(start.equals("Y")){
            Board board = new Board();
            System.out.println("Starting board");
            board.createBoard();
            board.printBoard();
            board.printHidden();
            System.out.println("Would you like to play with hints? Y/N");
            String hint = input.nextLine();
            Play play;
            if(hint.equals("Y")){
                play = new Hint(board);
            }
            else{
                play = new Play(board);
            }
            play.ask();
        }
        else{
            System.out.println("Game over");
        }


    }
}