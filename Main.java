
import java.util.*;

public class Main {
	public static char[][] board;
	static Random rand;
	static boolean keepPlaying;
	public static void main(String args[])
	{
		rand = new Random();
		Scanner scnr = new Scanner(System.in);
		board = new char[3][3];
		boolean valid = false;
		keepPlaying = true;
		printBoard();
		while (keepPlaying)
		{
			while (valid == false)
			{
				int x = -1;
				int y = -1;
				System.out.println();
				System.out.println("Players Turn");
				System.out.println();
				System.out.println("Enter X coordinate in the form of an integer from 0-2:");
				try {
				x = scnr.nextInt();
				} catch(InputMismatchException e) {
					x = -1;
				}
				while(x < 0 || x > 2)
				{
					System.out.println("Invalid entry try again");
					//j is used to stop infinite loop from occurring.
					var j = scnr.nextLine();
					try {
						x = scnr.nextInt();
						} catch(InputMismatchException e) {
							x = -1;
						}
				}
				System.out.println("Enter Y coordinate in the form of an integer from 0-2:");
				try {
					y = scnr.nextInt();
					} catch(InputMismatchException e) {
						y = -1;
					}
				while(y < 0 || y > 2)
				{
					System.out.println("Invalid entry try again");
					//j is used to stop infinite loop from occurring.
					var j = scnr.nextLine();
					try {
						y = scnr.nextInt();
						} catch(InputMismatchException e) {
							y = -1;
						}
				}
				valid = TryUserEntry(x,y);
			}
			valid = false;
			printBoard();
			CheckWinner();
			
			System.out.println();
			System.out.println("AI turn");
			System.out.println();
		
			AIMove();
			printBoard();
			
			CheckWinner();
		}
	}
	
	static boolean TryUserEntry(int x, int y)
	{
		boolean valid = true;
		if(board[x][y] == 0)
		{
			board[x][y] = 'O';
		}
		else
		{
			System.out.println("That spot is taken try again");
			valid = false;
		}
		return valid;
	}
	
	static void AIMove()
	{
		boolean done = false;
		while(done == false)
		{
			
			int random1 = rand.nextInt(3);
			int random2 = rand.nextInt(3);
			if(board[random1][random2] == 0)
			{
				board[random1][random2] = 'X';
				done = true;
			}
		}
	}
	
	static void printBoard()
	{
		System.out.println("  / 0 | 1 | 2 \\");
		System.out.println("  /---|---|---\\");
		System.out.println("0 | " + board[0][0] + " | " + board[1][0] + " | " + board[2][0] + " |");
		System.out.println("  |-----------|");
		System.out.println("1 | " + board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " |");
		System.out.println("  |-----------|");
		System.out.println("2 | " + board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " |");
		System.out.println("  /---|---|---\\");
	}
	
	static int CheckWinner() {
		for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = Character.toString(board[0][0]) + Character.toString(board[1][0]) + Character.toString(board[2][0]);
				break;
			case 1:
				line = Character.toString(board[0][1]) + Character.toString(board[1][1]) + Character.toString(board[2][1]);
				break;
			case 2:
				line = Character.toString(board[0][2]) + Character.toString(board[1][2]) + Character.toString(board[2][2]);
				break;
			case 3:
				line = Character.toString(board[0][0]) + Character.toString(board[0][1]) + Character.toString(board[0][2]);
				break;
			case 4:
				line = Character.toString(board[1][0]) + Character.toString(board[1][1]) + Character.toString(board[1][2]);
				break;
			case 5:
				line = Character.toString(board[2][0]) + Character.toString(board[2][1]) + Character.toString(board[2][2]);
				break;
			case 6:
				line = Character.toString(board[0][0]) + Character.toString(board[1][1]) + Character.toString(board[2][2]);
				break;
			case 7:
				line = Character.toString(board[2][0]) + Character.toString(board[1][1]) + Character.toString(board[0][2]);
				break;
			}
			if (line.equals("XXX")) 
			{
				System.out.println("The AI has won! Terminating program.");
				System.exit(0);
			} 
			else if (line.equals("OOO")) 
			{
				System.out.println("You won! Terminating program.");
				System.exit(0);
			}
		}
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0;j < 3; j++)
			{
				if(board[i][j] == 0)
				{
					System.out.println("Moving on to next turn");
					return 0;
				}
			}
		}
		
		System.out.println("All slots on the board are full");
		System.out.println("Game has ended in a tie. Terminating program.");
		System.exit(0);
		return 0;
		
	}
}
