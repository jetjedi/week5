import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uno {

	public static void main(String[] args) {
		Player player = new Player();
		Dealer dealer = new Dealer();
		Game game = new Game();
		boolean isWinner = false;

		// create players - need to revisit this.
		// ArrayList<String> players = player.createPlayers();

		// Player list
		String[] allPlayers = { "pile", "player1", "player2", "player3", "player4" };
		// Player hand
		List<String> player1 = new ArrayList<String>();
		List<String> player2 = new ArrayList<String>();
		List<String> player3 = new ArrayList<String>();
		List<String> player4 = new ArrayList<String>();
		List<String> pile = new ArrayList<String>();

		// initialize deck array, shuffle then convert from array to list.
		String[] initDeck = dealer.initDeck();
		dealer.shuffleDeck(initDeck);

		// check to see if a wild card will be placed in the pile at the start of the
		// game.
		char pileTopCard = initDeck[0].charAt(0);
		while (pileTopCard == 'W') {
			dealer.shuffleDeck(initDeck);
			pileTopCard = initDeck[0].charAt(0);
			System.out.println("\nWild card detected, reshuffle!");
		}

		List<String> gameDeck = new ArrayList<String>(Arrays.asList(initDeck)); // convert asList to true ArrayList so
																				// that I can add/drop
		// Deal 7 cards per player and 1 card for discard pile
		System.out.println("\n\nDeal cards.");
		dealer.dealCard(pile, gameDeck, pile, 1);
		dealer.dealCard(pile, gameDeck, player1, 7);
		dealer.dealCard(pile, gameDeck, player2, 7);
		dealer.dealCard(pile, gameDeck, player3, 7);
		dealer.dealCard(pile,gameDeck, player4, 7);
		System.out.println("Done");

		game.displayCards(allPlayers, pile, player1, player2, player3, player4);
		System.out.println();
		System.out.println("\nTime to play:\n");

		String playerTurn = "player1";

		while (isWinner == false) {

			// player 1 turn
			if (playerTurn == "player1") {
				System.out.println("\n" + playerTurn + " is up.");
				String matchedCard = game.playableCard(pile, player1, playerTurn);
				// now decide if play card or draw
				if (matchedCard == null) {
					System.out.println("No cards to play, not even a Wild card :-( ..Draw card\n");
					dealer.dealCard(pile,gameDeck, player1, 1); // draw card
					System.out.println("New card added for " + playerTurn + " , any matches?\n");
					matchedCard = game.playableCard(pile, player1, playerTurn);
					if (matchedCard == null) {
						System.out.println("Still no playable card, next players turn\n");
						playerTurn = "player2";
					} else {
						game.playCard(pile, player1, matchedCard, isWinner);// player has match after drawing, play it
						game.displayCards(playerTurn, pile, player1);
						playerTurn = "player2";
					}
				} else {
					game.playCard(pile, player1, matchedCard, isWinner);// player has match in hand, play it
					game.displayCards(playerTurn, pile, player1);
					playerTurn = "player2";
				}

			}
			
			// player 2 turn
			else if (playerTurn == "player2") {
				System.out.println("\n" + playerTurn + " is up.");
				String matchedCard = game.playableCard(pile, player2, playerTurn);
				// now decide if play card or draw
				if (matchedCard == null) {
					System.out.println("No cards to play, not even a Wild card :-( ..Draw card\n");
					dealer.dealCard(pile,gameDeck, player2, 1); // draw card
					System.out.println("New card added for " + playerTurn + " , any matches?\n");
					matchedCard = game.playableCard(pile, player2, playerTurn);
					if (matchedCard == null) {
						System.out.println("Still no playable card, next players turn\n");
						playerTurn = "player3";
					} else {
						game.playCard(pile, player2, matchedCard, isWinner);// player has match after drawing, play it
						game.displayCards(playerTurn, pile, player2);
						playerTurn = "player3";
					}
				} else {
					game.playCard(pile, player2, matchedCard, isWinner);// player has match in hand, play it
					game.displayCards(playerTurn, pile, player2);
					playerTurn = "player3";
				}

			}
			// player 3 turn
			else if (playerTurn == "player3") {
				System.out.println("\n" + playerTurn + " is up.");
				String matchedCard = game.playableCard(pile, player3, playerTurn);
				// now decide if play card or draw
				if (matchedCard == null) {
					System.out.println("No cards to play, not even a Wild card :-( ..Draw card\n");
					dealer.dealCard(pile,gameDeck, player3, 1); // draw card
					System.out.println("New card added for " + playerTurn + " , any matches?\n");
					matchedCard = game.playableCard(pile, player3, playerTurn);
					if (matchedCard == null) {
						System.out.println("Still no playable card, next players turn\n");
						playerTurn = "player4";
					} else {
						game.playCard(pile, player3, matchedCard, isWinner);// player has match after drawing, play it
						game.displayCards(playerTurn, pile, player3);
						playerTurn = "player4";
					}
				} else {
					game.playCard(pile, player3, matchedCard, isWinner);// player has match in hand, play it
					game.displayCards(playerTurn, pile, player3);
					playerTurn = "player4";
				}

			}
			
			// player 4 turn
			else if (playerTurn == "player4") {
				System.out.println("\n" + playerTurn + " is up.");
				String matchedCard = game.playableCard(pile, player4, playerTurn);
				// now decide if play card or draw
				if (matchedCard == null) {
					System.out.println("No cards to play, not even a Wild card :-( ..Draw card\n");
					dealer.dealCard(pile,gameDeck, player4, 1); // draw card
					System.out.println("New card added for " + playerTurn + " , any matches?\n");
					matchedCard = game.playableCard(pile, player4, playerTurn);
					if (matchedCard == null) {
						System.out.println("Still no playable card, next players turn\n");
						playerTurn = "player1";
					} else {
						game.playCard(pile, player4, matchedCard, isWinner);// player has match after drawing, play it
						game.displayCards(playerTurn, pile, player4);
						playerTurn = "player1";
					}
				} else {
					game.playCard(pile, player4, matchedCard, isWinner);// player has match in hand, play it
					game.displayCards(playerTurn, pile, player4);
					playerTurn = "player1";
				}

			}
		}

	}
}

class Player {
	// need to change this to create new ArrayList per playerName, for now create
	// players in main
	public List<String> createPlayers(String playerName) {
		System.out.println("Creating Player: " + playerName);
		List<String> players = new ArrayList<String>();
		players.add(playerName);
		System.out.println("Done");
		return players;
	}
}

class Dealer {
	public static String[] initDeck() {
		System.out.println("\nCreating Deck");
		// cheat here and just initialize the deck array, burnt too much time trying to
		// get array[] nested loops to work for 2 * 1-9 per color.
		String[] deck = { "R0", "B0", "Y0", "G0", "R1", "R1", "B1", "B1", "Y1", "Y1", "G1", "G1", "R2", "R2", "B2",
				"B2", "Y2", "Y2", "G2", "G2", "R3", "R3", "B3", "B3", "Y3", "Y3", "G3", "G3", "R4", "R4", "B4", "B4",
				"Y4", "Y4", "G4", "G4", "R5", "R5", "B5", "B5", "Y5", "Y5", "G5", "G5", "R6", "R6", "B6", "B6", "Y6",
				"Y6", "G6", "G6", "R7", "R7", "B7", "B7", "Y7", "Y7", "G7", "G7", "R8", "R8", "B8", "B8", "Y8", "Y8",
				"G8", "G8", "R9", "R9", "B9", "B9", "Y9", "Y9", "G9", "G9", "RD2", "RD2", "RSkip", "RSkip", "RRev",
				"RRev", "BD2", "BD2", "BSkip", "BSkip", "BRev", "BRev", "YD2", "YD2", "YSkip", "YSkip", "YRev", "YRev",
				"GD2", "GD2", "GSkip", "GSkip", "GRev", "GRev", "Wild", "Wild", "Wild", "Wild", "WD4", "WD4", "WD4",
				"WD4" };

		// print the deck array
		for (int i = 0; i < deck.length; i++) {
			System.out.print(deck[i] + ",");
		}

		System.out.println("\nDone");
		return deck;

	}

	public ArrayList shuffleDeck(String[] deckArray) {
		System.out.println("\nShuffle Deck.");
		for (int i = 0; i < deckArray.length; i++) {
			int index = (int) (Math.random() * deckArray.length);
			String temp = deckArray[i];
			deckArray[i] = deckArray[index];
			deckArray[index] = temp;
		}
		ArrayList<String> deckMain = new ArrayList<String>(Arrays.asList(deckArray));
		System.out.println("Done");
		for (int i = 0; i < deckMain.size(); i++)
			System.out.print(deckMain.get(i) + ",");
		return deckMain;
	}

	public static List<String> dealCard(List thePile, List theDeck, List thePlayer, int numOfCards) {
		if (theDeck.size() == 0) {
			System.out.println("Ran out of deck cards! Time to re-shuffle...");
			
			//get thePile list and move everything from 1-thePilse.size back to theDeck. Leave card(0) in the pile.
			for (int i=1; i < thePile.size(); i++) {
				theDeck.add(thePile.get(i));
				thePile.remove(i);
			}
		}
		for (int i = 0; i < numOfCards; i++) {
			thePlayer.add(theDeck.get(0));
			theDeck.remove(0);
		}
		return theDeck;
	}
}

class Game {
	public void displayCards(String[] thePlayers, List pile, List player1, List player2, List player3, List player4) {
		List allPlayersList = new ArrayList<String>();
		allPlayersList.add(pile);
		allPlayersList.add(player1);
		allPlayersList.add(player2);
		allPlayersList.add(player3);
		allPlayersList.add(player4);

		for (int i = 0, j = 0; i < thePlayers.length; i++, j++) {
			if (i == 0 && j == 0) {
				System.out.println(thePlayers[i] + ":\t" + allPlayersList.get(j));
			} else {
				System.out.println(thePlayers[i] + ":" + allPlayersList.get(j));
			}
		}
	}
	public void displayCards(String currentPlayer, List pile, List player) {
		List allPlayersList = new ArrayList<String>();
		allPlayersList.add(pile);
		allPlayersList.add(player);
		
		System.out.print("pile:\t");
		System.out.println(allPlayersList.get(0));
		
		System.out.println(currentPlayer + ":" + allPlayersList.get(1));
		
	}

	public String playableCard(List<String> pCard, List<String> playerCards, String currentPlayer) {
		char pileColor = (pCard.get(0).charAt(0)); // grab the color code
		char pileNum = (pCard.get(0).charAt(1)); // grab the number of the card

		for (int i = 0; i < playerCards.size(); i++) {
			char playerColor = (playerCards.get(i).charAt(0));
			char playerNum = (playerCards.get(i).charAt(1));
			
			if (pileColor == 'W') {
				System.out.println("Pile card has Wild, drop next player card");
				return playerCards.get(0);
			}
			
			if (pileColor == playerColor) {
				System.out.println("Card " + (i + 1) + " found color match:\npile: " + pCard.get(0) + "\nplayer: "
						+ playerCards.get(i));
				return playerCards.get(i);
			} else if (pileNum == playerNum) {
				System.out.println("Card " + (i + 1) + " found number match:\npile: " + pCard.get(0) + "\nplayer: "
						+ playerCards.get(i));
				return playerCards.get(i);
			} else {
				System.out.println(
						"Card " + (i + 1) + " for " + currentPlayer + " did not match color or number of the pile.");
			}
		}
		// loop again, if no color or number found check if player has a wild card to
		// play.
		System.out.println("Checking to see if " + currentPlayer + " has wild card.");
		for (int i = 0; i < playerCards.size(); i++) {
			char playerColor = (playerCards.get(i).charAt(0));
			if (playerColor == 'W') {
				System.out.println("Wild card found!\nplayer: " + playerCards.get(i));
				return playerCards.get(i);
			}
		}
		System.out.println("Nope, nothing found.");
		return null;
	}

	public boolean playCard(List<String> pileCards, List<String> playerCards, String matchedCard, boolean isWinner) {
		boolean foundWinner = isWinner;
		int indexOfmatchedCard = playerCards.indexOf(matchedCard);

		System.out.println("Player has match, dropping card to pile");
		pileCards.add(0, matchedCard);
		playerCards.remove(indexOfmatchedCard);
		if (playerCards.size() == 0) {
			System.out.println("We have a winner!");
			isWinner = true;
			System.exit(0);
		}
		return isWinner;
	}
}
