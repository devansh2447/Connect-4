
/**
 * Write a description of class Victory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//work on this class, check 4 different arrangements for victory
public class Victory
{
    public static boolean victoryChecker(String sequence, String square, String player, int boardWidth, int boardHeight){
        //first time: recurse = 1
        //square should have player name
            boolean check1, check2, check3, check4;
            check1 = check1(sequence, square, player, boardWidth, boardHeight);
            check2 = check2(sequence, square, player, boardWidth, boardHeight);
            check3 = check3(sequence, square, player, boardWidth, boardHeight);
            check4 = check4(sequence, square, player, boardWidth, boardHeight);
            if(check1 == false && check2 == false && check3 == false && check4 == false){
                Print.printSequence(sequence, boardWidth, boardHeight, boardWidth);
                return false;
            }
            else{
                Print.printSequence(sequence, boardWidth, boardHeight, boardWidth);
                return true;
            }
        }
    
    
    public static String check1Generator(String sequence, String square, int recurse, String player, int boardWidth, int boardHeight){
        //first time: invoke with recurse = 3, base case is recurse = -3
        //return string with 1s wherever the square is there in the sequence string
        if(recurse >= -3){
            String check;
            int y;
            y = Integer.parseInt(square.charAt(0) + "") + recurse;
            int x;
            x = Integer.parseInt(square.charAt(1) + "") + recurse;
            if(y <= 0 || x <= 0 || y > boardHeight || x> boardWidth){
                check = "0";
            }
            else{
                String compare;
                compare = y + "" + x + player;
                if(sequence.indexOf(compare) == -1){
                    check = "0";
                }
                else{
                    check = "1";
                }
            }
            return check + check1Generator(sequence, square, recurse - 1, player, boardWidth, boardHeight);
        }
        else{
            return "";
        }
    }
    
    public static boolean check1(String sequence, String square, String player, int boardWidth, int boardHeight){
        String check;
        check = check1Generator(sequence, square, 3, player, boardWidth, boardHeight);
        return check.contains("1111");
    }
    
    public static String check2Generator(String sequence, String square, int recurse, String player, int boardWidth, int boardHeight){
        //first time: invoke with recurse = 3, base case is recurse = -3
        //return string with 1s wherever the square is there in the sequence string
        if(recurse >= -3){
            String check;
            int y;
            y = Integer.parseInt(square.charAt(0) + "") + recurse;
            int x;
            x = Integer.parseInt(square.charAt(1) + "");
            if(y <= 0 || x <= 0 || y > boardHeight || x> boardWidth){
                check = "0";
            }
            else{
                String compare;
                compare = y + "" + x + player;
                if(sequence.indexOf(compare) == -1){
                    check = "0";
                }
                else{
                    check = "1";
                }
            }
            return check + check2Generator(sequence, square, recurse - 1, player, boardWidth, boardHeight);
        }
        else{
            return "";
        }
    }
    
    public static boolean check2(String sequence, String square, String player, int boardWidth, int boardHeight){
        String check;
        check = check2Generator(sequence, square, 3, player, boardWidth, boardHeight);
        return check.contains("1111");
    }
    
    public static String check3Generator(String sequence, String square, int recurse, String player, int boardWidth, int boardHeight){
        //first time: invoke with recurse = 3, base case is recurse = -3
        //return string with 1s wherever the square is there in the sequence string
        if(recurse >= -3){
            String check;
            int y;
            y = Integer.parseInt(square.charAt(0) + "") + recurse;
            int x;
            x = Integer.parseInt(square.charAt(1) + "") - recurse;
            if(y <= 0 || x <= 0 || y > boardHeight || x> boardWidth){
                check = "0";
            }
            else{
                String compare;
                compare = y + "" + x + player;
                if(sequence.indexOf(compare) == -1){
                    check = "0";
                }
                else{
                    check = "1";
                }
            }
            return check + check3Generator(sequence, square, recurse - 1, player, boardWidth, boardHeight);
        }
        else{
            return "";
        }
    }
    
    public static boolean check3(String sequence, String square, String player, int boardWidth, int boardHeight){
        String check;
        check = check3Generator(sequence, square, 3, player, boardWidth, boardHeight);
        return check.contains("1111");
    }
    
    public static String check4Generator(String sequence, String square, int recurse, String player, int boardWidth, int boardHeight){
        //first time: invoke with recurse = 3, base case is recurse = -3
        //return string with 1s wherever the square is there in the sequence string
        if(recurse >= -3){
            String check;
            int y;
            y = Integer.parseInt(square.charAt(0) + "");
            int x;
            x = Integer.parseInt(square.charAt(1) + "") - recurse;
            if(y <= 0 || x <= 0 || y > boardHeight || x> boardWidth){
                check = "0";
            }
            else{
                String compare;
                compare = y + "" + x + player;
                if(sequence.indexOf(compare) == -1){
                    check = "0";
                }
                else{
                    check = "1";
                }
            }
            return check + check4Generator(sequence, square, recurse - 1, player, boardWidth, boardHeight);
        }
        else{
            return "";
        }
    }
    
    public static boolean check4(String sequence, String square, String player, int boardWidth, int boardHeight){
        String check;
        check = check4Generator(sequence, square, 3, player, boardWidth, boardHeight);
        return check.contains("1111");
    }
}
