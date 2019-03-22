import java.util.Scanner;

public class Sudoku {

	static int[][] display = new int[4][4];
	static boolean win;
	
	public static void main (String [] args)
	{			
		while(!CheckWin(display))
		{
			Move();	
			CheckLegal(display);
		}
		
		System.out.println("You Win!");
	}
	
	public static void Move()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Move:");
		String move = input.next();
		
		String[] parts = move.split("");
		int[] inputs = new int[parts.length];
		
		for (int i = 0; i < parts.length; i++) {	
			inputs[i] = Integer.parseInt(parts[i]);
		}
		
		display [inputs[0]][inputs[1]] = inputs[2];
		
		Display(display);
	}
	
	public static Boolean CheckWin(int[][] _display)
	{
		boolean hasNum = false;
		boolean legal = true;
		boolean full = true;
		
		for(int numCheck = 1;numCheck <= 4;numCheck++)
		{
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {					
					if(_display[r][c] == numCheck)
					{
						if(hasNum == true)
							legal = false;
						hasNum = true;
					}
				}
				hasNum = false;
			}			
		}
		
		for(int numCheck = 1;numCheck <= 4;numCheck++)
		{
			for (int r = 0; r < 4; r++) {			
				for (int c = 0; c < 4; c++) {
					
					if(_display[c][r] == numCheck)
					{
						if(hasNum == true)
							legal = false;
						hasNum = true;
					}
				}
				hasNum = false;
			}			
		}		
		for (int r = 0; r < 4; r++) {			
			for (int c = 0; c < 4; c++) {
				
				if(_display[r][c] == 0)
				{
					return false;
				}
			}
		}		
		if(legal == true)	
			return true;
		
		return false;			
	}
	
	public static void CheckLegal(int[][] _display)
	{
		boolean hasNum = false;
		boolean legal = true;
		
		for(int numCheck = 1;numCheck <= 4;numCheck++)
		{
			for (int r = 0; r < 4; r++) {			
				for (int c = 0; c < 4; c++) {
					
					if(_display[r][c] == numCheck)
					{
						if(hasNum == true)
							legal = false;
						hasNum = true;
					}
				}
				hasNum = false;
			}			
		}
		
		for(int numCheck = 1;numCheck <= 4;numCheck++)
		{
			for (int r = 0; r < 4; r++) {			
				for (int c = 0; c < 4; c++) {
					
					if(_display[c][r] == numCheck)
					{
						if(hasNum == true)
							legal = false;
						hasNum = true;
					}
				}
				hasNum = false;
			}			
		}
		
		if(legal == false)			
			System.out.println("Not Legal!");
	}
	
	public static void Display(int[][] _display)
	{
		for (int r = 0; r < 4; r++) {			
			for (int c = 0; c < 4; c++) {
				System.out.print(_display[r][c] + " ");
			}
			System.out.println();
		}
	}
	
}
