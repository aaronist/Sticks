import java.util.Scanner;

public class Sticks {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int sticks = (int)(10 * Math.random()) + 21;
		
		System.out.println("There are " + sticks + " sticks.");
		System.out.println("Select 1 to go first, select 2 to go second.");
		
		boolean turn; // True is player turn, false is computer turn
		if (reader.nextInt() == 1)
			turn = true;
		else
			turn = false;
		
		// Game stops when we get to 0 sticks
		// So the game must continue to run as long as sticks does not equal 0
		
		while (sticks > 0) {
			if (turn)
				sticks = playerMove(sticks, reader);
			else
				sticks = computerMove(sticks);
			
			System.out.println("There are " + sticks + " sticks left.");
			
			if (sticks == 0 && turn)
				System.out.println("Player wins!");
			if (sticks == 0 && !turn)
				System.out.println("Computer wins!");
			
			turn = !turn;
		}
		
	}
	
	// The input parameters are: sticks and reader
	public static int playerMove(int sticks, Scanner reader) {
		System.out.println("\nSelect how many sticks to take.");
		int take = reader.nextInt();
		
		if (take < 1)
			take = 1;
		if (take > 3)
			take = 3;
		else if (take > sticks)
			take = sticks;
		
		System.out.println("You took " + take + " sticks.");
		return sticks - take;
	}
	
	public static int computerMove(int sticks) {
		int take;
		
		if (sticks % 4 != 0)
			take = sticks % 4;
		else
			take = (int)(3 * Math.random()) + 1;
		
		System.out.println("The computer took " + take + " sticks.");
		return sticks - take;
	}

}
