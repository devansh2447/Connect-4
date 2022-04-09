
/**
 * Write a description of class Initializer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Initializer
{
    public static void main(String args[]){
        init(true);
    }

    //initializer : prints instructions if boolean isFirstTime == true and the asks for board width and board height
    public static void init(boolean isFirstTime){
        //isFirstTime: prints instructions when true
        if(isFirstTime == true){
            //prints instructions
            Main.newLine();
            Main.print("Welcome to Connect 4", true);
            Main.newLine();
            Main.print("In this game, you attempt to connect 4 counters in a row (horizontal, vertical or diagonal) in a grid - and every time you place a counter, it goes to the bottommost square free of the column you specify.", true);
            Main.newLine();
        }
        Scanner width = new Scanner(System.in);
        Scanner height = new Scanner(System.in);
        int boardWidth;
        int boardHeight;
        Main.print("Please choose your board width", true);
        Main.newLine();
        boardWidth = width.nextInt();
        Main.newLine();
        Main.print("Please choose your board height", true);
        Main.newLine();
        boardHeight = height.nextInt();
        Main.newLine();
        Main.takeInput(true, "", boardWidth, boardHeight);
    }
}
