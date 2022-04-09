
/**
 * Write a description of class Gravity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//use order: row, column
public class Gravity
{
    //mpdifies input string so that it is just above the uppermost filled square in the column
    public static String gravity(String toModify, String sequence){
        //toModify: input to be modified
        //sequence: sequence of filled squares
        int lastIndexA;
        int lastIndexB;
        lastIndexA = sequence.lastIndexOf(toModify.charAt(1) + "A");
        lastIndexB = sequence.lastIndexOf(toModify.charAt(1) + "B");
        //helps get the value which toModify should take so that it goes right on top of what is already there on the board
        int lastIndex;
        if(lastIndexA > lastIndexB){
            //condition if lastIndexA is larger, sets lastIndex as lastIndexA
            lastIndex = lastIndexA;
            //highestValue: row of highest square in column of toModify
            String highestValue;
            highestValue = sequence.charAt(lastIndex - 1) + "";
            int replaceValue;
            replaceValue = Integer.parseInt(highestValue) + 1;
            return replaceValue + toModify.substring(1,3);
        }
        else{
            //condition if lastIndexB is largers or equal ot lastIndexA, sets lastIndex as lastIndexB
            lastIndex = lastIndexB;
            if(lastIndex == -1){
                //condition if toModify is the only one in it's column (lastIndex == -1)
                return toModify;
            }
            else{
                //condition is toModify needs to be modified
                //highestValue: row of highest square in column of toModify
                String highestValue;
                highestValue = sequence.charAt(lastIndex - 1) + "";
                int replaceValue;
                replaceValue = Integer.parseInt(highestValue) + 1;
                return replaceValue + toModify.substring(1,3);
            }
        }
    }
}
