import java.util.Scanner;

public class Uno {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfPlayers = 0;	//value to send to method for creating Players array
		
		
		//Start of game. User to declare number of players
		System.out.print("Welcome to Uno Classic, please enter 2-4 players: ");
		
		//check to see if user did not enter a number
		while (!input.hasNextInt()) {
				System.out.println("Error: Must enter a valid number: 2 3 or 4.");
				input.next();
			}
		
		//Grab user input for 2-4 players
		numOfPlayers = input.nextInt();
		if (numOfPlayers < 2 || numOfPlayers > 4) {
			System.out.println("Only 2-4 players supported, exiting game!");
			System.exit(0);
		}
		else {
			System.out.println("Creating " + numOfPlayers + " players.");
			Player myPlayers = new Player();
			String[] players =myPlayers.createPlayer(numOfPlayers);
			for (String e : players)
				System.out.println(e);
			
		}
	}

}

class Player {
	public static String[] createPlayer(int numOfPlayers) {
		String[] players = new String[numOfPlayers + 2]; //add Dealer and Pile to game players
		
		for (int i=0; i <= numOfPlayers; i++) {
			players[i] = ("P" + i);
			System.out.println("Player: " + players[i] + " created.");
		}

		return players; //return player array String
	}
}
