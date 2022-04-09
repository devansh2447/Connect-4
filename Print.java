
/**
 * Write a description of class Print here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Print
{
    public static void printSequence(String sequence, int squaresLeftOver, int rowsLeftOver, int boardWidth){
        //sequence: sequence to be printed
        //squaresLeftOver: total number of squares left over
        //rowsLeftOver: total number of rows left over
        //boardWidth: width of board
        //begin with squaresLeftOver and rowsLeftOver = boardWidth and boardHeight respectively
        if(rowsLeftOver > 0){
            //condition if printing of squares is not complete
            if(squaresLeftOver >= 0){
                //condition is row is incomplete
                if(squaresLeftOver == boardWidth){
                    //condition if this is the first time this row is being printed, prints row number in front of row
                    System.out.print(rowsLeftOver + " ");
                }
                //check: current square number, used ot check if that square is there in the sequence
                String check;
                check = rowsLeftOver + "" + (boardWidth - squaresLeftOver + 1);
                if(sequence.indexOf(check) != -1){
                    //condition if square is there, prints out player name then invokes printSequence to continue
                    System.out.print(sequence.charAt(sequence.indexOf(check) + 2) + " ");
                    printSequence(sequence, squaresLeftOver - 1, rowsLeftOver, boardWidth);
                }
                else{
                    //condition if square is not there, prints space then invokes printSequence to continue
                    System.out.print("  ");
                    printSequence(sequence, squaresLeftOver - 1, rowsLeftOver, boardWidth);
                }
            }
            else{
                //condition if row is fully done, goes to new line then invokes printSequence
                System.out.println("");
                printSequence(sequence, boardWidth, rowsLeftOver - 1, boardWidth);
            }
        }
        else{
            //prints coordinates at the bottom
            System.out.print("  "); 
            printBottom(boardWidth, 1);
        }
    }

    //prints coordinates at the bottom
    public static void printBottom(int width, int recurse){
        //width: width of grid
        //recurse: total numbers which have been printed
        if(recurse <= width){
            System.out.print(recurse + " ");
            printBottom(width, recurse + 1);
        }
        else{
            System.out.println("");
        }
    }
}
