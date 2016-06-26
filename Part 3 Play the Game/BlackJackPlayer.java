import java.util.Random;
import java.util.Scanner;

public class BlackJackPlayer{


	//This method takes a string and an int and displays that string 
	//to the console one character at a time in an explicitly defined amount of time
	//This is J Perez's own personally designed method and claims no-stealsies
	//Credits to the internet for the .toCharArray() method
	public static void smoothStringDisplay(String string1, int time) throws InterruptedException{
		char[] charArray1 = (string1).toCharArray();
		long threadTimer = 0;
		threadTimer = (time / charArray1.length);
		for (int i = 0; i < charArray1.length; i++){
			System.out.print(charArray1[i]);
			Thread.sleep(threadTimer);
		}
	}

	//This method prints the contents of the deck
	//This method is never used
	public static void printDeck(Card[] deck){
		for(int i = 0; i < deck.length; i++){
			System.out.println(deck[i]);
		}
	}

	//This method swaps a card of position ? in the deck with another card
	//of position ? in the deck a total of 52 times
	//This method is oddly never used
	public static void shuffleDeck(Card[] deck){
	    Random random = new Random();
		for(int i = 0; i < 4 * deck.length; i++){
			int int1 = (random.nextInt((deck.length /*- 1*/)) + 0);
			int int2 = (random.nextInt((deck.length /*- 1*/)) + 0);
			Card int3 = deck[int2];
			deck[int2] = deck[int1];
			deck[int1] = int3;
		}
	}


	//This method is crucial to determining what action to perform after dealing the first cards
	public static boolean hasBlackJack(Player player) throws InterruptedException{
		int win = 21;
		boolean bool = false;
		if (player.getPlayerTotal() == win){
			System.out.println("\n");
			BlackJackPlayer.smoothStringDisplay("PLAYER " + player.id 
				+ " HAS DRAWN BLACKJACK", 500);
			System.out.println("\n");
				smoothStringDisplay("CONGRATULATIONS!", 1000);
			System.out.println("\n");
			return bool = true;
		}
		else if (player.getPlayerTotal() > win){
			BlackJackPlayer.smoothStringDisplay("Player " + player.id + 
				" has not drawn BlackJack", 1500);
			return bool = true;
		}
		else {
			BlackJackPlayer.smoothStringDisplay("Player " + player.id + 
				" has not drawn BlackJack", 1500);
			System.out.println("\n");
			return bool;
		}
	}

	//public static something else i had planned to make my life easier. RIP

	//This method is a really unnecessary continuation to the determination of what 
	//action to perform after cards have been dealt, but hey you live and learn
	public static int playerCompareTo(Player player1, Player player2){
		int num = 0;
		if (player1.getPlayerTotal() < player2.getPlayerTotal()){
			num = 1;
		}
		else if(player1.getPlayerTotal() == player2.getPlayerTotal()){
			num = 0;
		}
		else if(player1.getPlayerTotal() > player2.getPlayerTotal()){
			num = -1;
		}
		return num;
	}


	//Main method
	public static void main(String[] args) throws InterruptedException{
		long startTime = System.nanoTime();
		//Initialize variables and deck
		Card[] deck = new Card[52];

		String[] suits = {"clubs", "diamonds", "heart", "spades"};
		int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

		int i = 0;
		for (int j = 0; j < suits.length; j++){
			for(int k = 0; k < ranks.length; k++){
				deck[i++] = new Card(suits[j], ranks[k]);
			}
		}

		boolean playAgain = false;
		boolean activeBool = true;


		//This double do-while allows the program to ask user if it wants to play again, 
		//and then run itself again after game finish
		do
		{
			do
			{
				Player player1 = new Player(1);
				Player player2 = new Player(2);

				smoothStringDisplay("\n\n=======================================\n\n"
					+ "Welcome to BlackJack!", 300);
				//{"W", "e", "l", "c", "o", "m", "e ", "t", "o ", "B", "l", "a", "c", "k", "J", "a", "c", "k", "!"};

				Thread.sleep(1000);
				System.out.println();
				smoothStringDisplay("Shuffling cards....", 300);
				Thread.sleep(3500);

				//=====================================================//
				//This part handles dealing the initial cards

				System.out.println("\n");
				for (int j = 1; j <= 2; j++){
					player1.getCardfromDeck(deck);
					Thread.sleep(750);	
					player2.getCardfromDeck(deck);
					Thread.sleep(750);
				}

				Thread.sleep(2000);
				player1.displayHand();
				Thread.sleep(2500);
				player2.displayHand();
				Thread.sleep(2500);
				
				System.out.println("\n");

				if (BlackJackPlayer.hasBlackJack(player1)){
					activeBool = false;
				}
				Thread.sleep(250);
				System.out.println("\n");
				if (BlackJackPlayer.hasBlackJack(player2)){
					activeBool = false;
				}
				Thread.sleep(100);

				//=====================================================//

				String input = "";
				if (activeBool){
					do{

						String string1 = "";
						if (player1.getPlayerTotal() <= 8){
							string1 += "\n(You could really use another card)";
						}
						else if (player1.getPlayerTotal() >= 19){
							string1 += "\n(You really shouldn't get another card....)";
						}
						smoothStringDisplay("Your turn. Would you like to draw a card? " + string1 + "(y/n)  ", 1000);
						Scanner scanner = new Scanner(System.in);
						input = scanner.nextLine();

						System.out.println("");
						if (input.equals("y")){
							Thread.sleep(500);
							player1.getCardfromDeck(deck);
							Thread.sleep(1000);
							player1.displayHand();
							Thread.sleep(2000);
						}
						else {
							smoothStringDisplay("You declined to draw another card", 500);
							Thread.sleep(1000);
						}
						System.out.println("\n");
						BlackJackPlayer.hasBlackJack(player1);

					} while ((!input.equals("n")) && ! (player1.getPlayerTotal() > 21));
				}

				Thread.sleep(2000);
				if (player1.getPlayerTotal() > 21){
					System.out.println("\n");
					smoothStringDisplay("PLAYER " + player1.id + " HAS GONE OVER 21", 1000);
					System.out.println("\n");
					System.out.println("");
					smoothStringDisplay("BETTER LUCK NEXT TIME!", 500);
					break;
				}
				else if (player2.getPlayerTotal() > 21){
					System.out.println("\n");
					smoothStringDisplay("PLAYER " + player2.id + " HAS GONE OVER 21", 1000);
					System.out.println("\n");
					smoothStringDisplay("YOU WIN!", 500);
					break;
				}

				while (player2.getPlayerTotal() < 17){
					System.out.println("\n");
					smoothStringDisplay("Player " + player2.id + " has a hand of " + 
						player2.getPlayerTotal() + " and has to draw again!", 1500);
					Thread.sleep(2000);
					System.out.println("\n");
					player2.getCardfromDeck(deck);
					player2.displayHand();
					Thread.sleep(2000);
				}

				BlackJackPlayer.hasBlackJack(player2);
				if (player2.getPlayerTotal() > 21){
					smoothStringDisplay("PLAYER " + player2.id + " HAS GONE OVER 21", 1000);
					System.out.println("\n");
					System.out.println("\n");
					smoothStringDisplay("BETTER LUCK NEXT TIME!", 500);
				}

				System.out.println("\n\n");
				smoothStringDisplay("GAME DONE", 500);
				System.out.println("\n");

				if (!hasBlackJack(player1) && !hasBlackJack(player2)){
					switch (BlackJackPlayer.playerCompareTo(player1, player2)){

						case -1:{
							smoothStringDisplay("Player " + player1.id + " has the greater hand! (" + player1.getPlayerTotal() +")", 1000);
							System.out.println("\n");
							smoothStringDisplay("CONGRATULATIONS!", 1000);
							break;
						}
						case 0:{
							smoothStringDisplay("ITS A TIE", 1000);
							break;
						}
						case 1:{
							smoothStringDisplay("Player " + player2.id + " has the greater hand!(" + player2.getPlayerTotal() +")", 1000);
							System.out.println("\n");
							smoothStringDisplay("BETTER LUCK NEXT TIME!", 1000);
							break;
						}
					}
				}

				System.out.println("\n");
				BlackJackPlayer.smoothStringDisplay("Thank you for playing BlackJack!", 1000);
				playAgain = false;
				break;

			} while (true);

			Thread.sleep(1500);
			System.out.println("\n");
			BlackJackPlayer.smoothStringDisplay("Would you like to play again? (y/n)", 500);
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			if (input.equals("y")){				
				playAgain = true;
				i = 0;
				smoothStringDisplay("Returning cards back to deck....", 1500);
				for (int j = 0; j < suits.length; j++){
					for(int k = 0; k < ranks.length; k++){
						deck[i++].setDealt(false);
					}
				}
				activeBool = true;
				System.out.println("\n\n=======================================\n\n");
			}
			else{
				BlackJackPlayer.smoothStringDisplay("Thank you for playing BlackJack. Program will now close", 2000);
				Thread.sleep(1000);
				System.out.println("\n");
			}
		} while(playAgain);

	//==============================END MAIN===============================
	BlackJackPlayer.smoothStringDisplay("Total session time: " + ((System.nanoTime() - startTime) / 1000000000) + " seconds", 1000);
	}
}