import java.util.*;

public class tic_tac_toe{
	static String [] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static String mark;
	
	static void printBoard(){
        System.out.println("     |     |     ");
        System.out.println("  " + board[0] + "  |  "
                           + board[1] + "  |  " + board[2]
                           + "  ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + board[3] + "  |  "
                           + board[4] + "  |  " + board[5]
                           + "  ");
        System.out.println("_____|_____|_____");
        System.out.println("     |     |     ");
        System.out.println("  " + board[6] + "  |  "
                           + board[7] + "  |  " + board[8]
                           + "  ");
        System.out.println("     |     |     ");
    }
	
	static String checkWinner()
    {
        for (int x = 0; x < 8; x++) {
            String line = null;
  
            switch (x) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            
            if (line.equals("XXX")) {
                return "1(X)"; // Player 1 win!
            }
              
            else if (line.equals("OOO")) {
                return "2(O)"; // Player 2 win!
            }
        }
          
        for (int x = 0; x < 9; x++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(x + 1))) {
                break;
            }
            else if (x == 8) {
                return "draw";
            }
        }
        if(mark.equals("X")) {
        	System.out.println("Player 1(X), enter a number:  ");
        }else {
        	System.out.println("Player 2(O), enter a number:  ");
        }
        
        return null;
    }
	
    
    public static void main(String[] args){    	
    	String player = null;
        mark = "X";
     
        Scanner sc = new Scanner(System.in);
      
        System.out.println("Let's START TIC-TAC-TOE game"); 
		printBoard();
		System.out.println("Player 1(X), enter a number:  ");
		
		while (player == null) {
            int num = sc.nextInt();
            
            if(!(num > 0 && num <= 9)) {
				System.out.println("Invalid input. Please re-enter : ");
				continue;
			}  
            
            if (board[num - 1].equals(String.valueOf(num))) {
                board[num - 1] = mark;
  
                if (mark.equals("X")) {
                    mark = "O";
                }
                else {
                    mark = "X";
                }
                printBoard();
                player = checkWinner();
            }
            else {
                System.out.println(
                    "Slot already taken; Please re-enter : ");
            }
        }
        
        if (player.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw!");
        }
        
        else {
            System.out.println("Player " + player + "Win!");
        }
    }
    
}