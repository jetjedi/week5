import java.util.Scanner;

public class Uno {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfPlayers = 0; // value to send to method for creating Players array

		// Start of game. User to declare number of players
		System.out.print("Welcome to Uno Classic, please enter 2-4 players: ");

		// check to see if user did not enter a number
		while (!input.hasNextInt()) {
			System.out.println("Error: Must enter a valid number: 2 3 or 4.");
			input.next();
		}

		// Grab user input for 2-4 players
		numOfPlayers = input.nextInt();
		if (numOfPlayers < 2 || numOfPlayers > 4) {
			System.out.println("Only 2-4 players supported, exiting game!");
			System.exit(0);
		} else {
			System.out.println("Creating " + numOfPlayers + " players + Dealer and Pile.");
			Player myPlayers = new Player();
			String[] players = myPlayers.createPlayer(numOfPlayers);
;
			for (String e : players)
				System.out.print(e + " Player ready. ");
		}
		System.out.println();
		
		//Create Dealer object then Deck of cards
		Dealer dealer = new Dealer();
		dealer.initDeck();
	}
}

class Player {
	public static String[] createPlayer(int numOfPlayers) {
		String[] players = new String[numOfPlayers + 2]; // game players plus Dealer and Pile arrays

		for (int i = 1; i <= numOfPlayers; i++) {
			players[i] = ("P" + i);
			System.out.println("Player: " + players[i] + " created.");
		}
		// default players
		players[0] = "Dealer";
		players[numOfPlayers + 1] = "Pile";

		return players; // return players array String
	}
}

class Dealer {
	public static void initDeck() {
		/*
		 * There are 108 cards in an Uno deck. 7 cards to a player(PX) to start
		 * 
		 * 4 colors in the deck, Red, Blue, Yellow, Green
		 * 
		 * Each color has 25 cards 1 x 0 card 2 x 1 cards 2 x 2,3,4,5,6,7,8,9 cards 2 x
		 * Draw Two cards 2 x Skip cards 2 x Reverse cards
		 * 
		 * In addition there are 8 Wild cards: 4 x Wild cards 4 x Wild Draw Four cards
		 * 
		 */
		int numberOfCards = 108;
		String[] deckColors = { "R", "B", "Y", "G" };
		String[] deckRanks = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] deck = new String[numberOfCards];
		
		System.out.println("Creating Deck");
		
		for (int i=0,k=0; i < deckRanks.length; i++) {
			for (int j=0; j < deckColors.length; j++) {
				if (i != 0) {
					deck[deckColors.length*i + j] = deckColors[j] + deckRanks[i];
				}
				else {
					//need to add 2 of each deckRanks per deckColors
				}			
			}
		}
		//print the deck
		for (int i=0; i < numberOfCards; i++)
			System.out.println(deck[i]);

	}
}
