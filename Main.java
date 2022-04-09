
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
//sequence string format is y + x + player name
public class Main
{
    //prints output
    public static void print(String print, boolean newLine){
        //print : string to be printed
        //newLine: true if newLine is required
        if(newLine == true){
            System.out.println(print);
        }
        else{
            System.out.print(print);
        }
    }

    //newline
    public static void newLine(){
        System.out.println("");
    }

    //checks if a certain board sequence is full
    public static boolean checkIfFull(String sequence, int boardWidth, int boardHeight){
        //sequence: sequence to be checked
        //boardWidth : width of board
        //board height: height of board
        if(sequence.length() >= boardWidth * boardHeight * 3){
            return true;
        }
        else{
            return false;
        }
    }

    //takes input, manipulates it using Gravity class, then sends it to Victory for checking is a player has won and printing the board sequence in readable form
    public static void takeInput(boolean isPlayerA, String sequence, int boardWidth, int boardHeight){
        //isPlayerA: true if it is player A's turn
        //sequence: sequence of filled squares - every group of three characters represents on square
        //use order: row, column for input (square in 1st column, 2nd row will be 21A or 21B)
        //first time: invoke with sequence = ""
        //boardWidth: width of board
        //boardHeight: height of board
        if(isPlayerA == true){
            print("Player A, please provide the column in which you want to place your piece.", true);
            Scanner input = new Scanner(System.in);
            String userInput;
            userInput = input.nextLine();
            String update;
            update = "1" + userInput + "A";
            String updatedInput;
            //updatedInput gets the updated version of input, concatenated to the end of sequence from Gravity.gravity
            updatedInput =  Gravity.gravity(update, sequence);
            if(checkIfFull(sequence, boardWidth, boardHeight) == true){
                //condition if board is full
                newLine();
                print("Looks like the game has ended in a draw!", true);
            }
            else if(Integer.parseInt(updatedInput.charAt(0) + "") > boardHeight || Integer.parseInt(updatedInput.charAt(1) + "") > boardWidth){
                //checks if column selected is full or is not in the board
                newLine();
                print("The column you have selected is not valid, please choose again" , true);
                newLine();
                takeInput(isPlayerA, sequence, boardWidth, boardHeight);
            }
            else{
                newLine();
                String updatedSequence;
                updatedSequence = sequence + updatedInput;
                if(Victory.victoryChecker(updatedSequence, updatedInput, updatedInput.charAt(2) + "", boardWidth, boardHeight) == true){
                    //checks if latest addition in sequence leads to victory
                    //note: printing is done by Victory.victoryChecker invoking Print.printOutput, so code for printing is not included here
                    newLine();
                    print("Looks like player A has won!", true);
                }
                else{
                    takeInput(false, updatedSequence, boardWidth, boardHeight);
                }
            }

        }
        else{
            print("Player B, please provide the column in which you want to place your piece.", true);
            Scanner input = new Scanner(System.in);
            String userInput;
            userInput = input.nextLine();
            String update;
            update = "1" + userInput + "B";
            String updatedInput;
            updatedInput =  Gravity.gravity(update, sequence);
            if(checkIfFull(sequence, boardWidth, boardHeight) == true){
                //condition if board is full
                newLine();
                print("Looks like the game has ended in a draw!", true);
            }
            else if(Integer.parseInt(updatedInput.charAt(0) + "") > boardHeight || Integer.parseInt(updatedInput.charAt(1) + "") > boardWidth){
                //checks if column selected is full or is not in the board
                newLine();
                print("The column you have selected is not valid, please choose again" , true);
                newLine();
                takeInput(isPlayerA, sequence, boardWidth, boardHeight);
            }
            else{
                newLine();
                String updatedSequence;
                updatedSequence = sequence + updatedInput;
                if(Victory.victoryChecker(updatedSequence, updatedInput, updatedInput.charAt(2) + "", boardWidth, boardHeight) == true){
                    //checks if lates addition in sequence leads to victory
                    //note: printing is done by Victory.victoryChecker invoking Print.printOutput, so code for printing is not included here
                    newLine();
                    print("Looks like player B has won!", true);                
                }
                else{
                    takeInput(true, updatedSequence, boardWidth, boardHeight);
                }
            }
        }
        //this portion of code is reached once the game has been ended (through either draw or victory)
        newLine();
        Scanner checkIfContinue = new Scanner (System.in);
        String check;      
        print("Press c is you would like to play again, and press any other key to exit", true);
        check = checkIfContinue.nextLine();
        if(check.equals("c") || check.equals("C")){
            //restarts from Initializer.init to get row width and height, but invokes it with isFirstTime = false so that instructions are not printed
            newLine();
            Initializer.init(false);
        }
        else{
            //terminates program
            System.out.flush();
            System.exit(0);
        }
    }
}
