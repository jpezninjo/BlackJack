import java.util.Random;
import java.util.Scanner;
public class BlackJackPlayer{

	public static void main(String[] args) {
		
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

		do
		{
			do
			{
				Player player1 = new Player(1);
				Player player2 = new Player(2);

				System.out.println("___________________________________________________________");
				System.out.println("Welcome to BlackJack (Debug mode)!\n\n");

				for (int j = 1; j <= 2; j++){
					player1.getCardfromDeck(deck);
					player2.getCardfromDeck(deck);
				}

				player1.displayHand();
				player2.displayHand();

				BlackJackPlayer.hasBlackJack(player1);
				BlackJackPlayer.hasBlackJack(player2);

				String input;

				do{
					System.out.println("Your turn. Would you like to draw a card? (y/n)");
					Scanner scanner = new Scanner(System.in);
					input = scanner.nextLine();

					if (input.equals("y")){
						player1.getCardfromDeck(deck);
						player1.displayHand();
					}

					BlackJackPlayer.hasBlackJack(player1);

				} while ((!input.equals("n")) && ! (player1.getPlayerTotal() > 21));

				if (player1.getPlayerTotal() > 21){
					System.out.println("PLAYER " + player1.id + " HAS GONE OVER 21");
					System.out.println("BETTER LUCK NEXT TIME!");
					break;
				}
				else if (player2.getPlayerTotal() > 21){
					System.out.println("PLAYER " + player2.id + " HAS GONE OVER 21");
					System.out.println("YOU WIN!");
					break;
				}

				while (player2.getPlayerTotal() < 17){
					System.out.println("Player " + player2.id + " has a hand of " + 
						player2.getPlayerTotal() + " and has to draw again");
					player2.getCardfromDeck(deck);
					player2.displayHand();
				}

				BlackJackPlayer.hasBlackJack(player2);
				if (player2.getPlayerTotal() > 21){
					System.out.println("PLAYER " + player2.id + " HAS GONE OVER 21");
					System.out.println("BETTER LUCK NEXT TIME!");
					//System.exit(5);
					break;				//THIS PART NEEDS PATCHING
				}

				System.out.println("\n\nGAME DONE\n");
				switch (BlackJackPlayer.playerCompareTo(player1, player2)){

					case -1:{
						System.out.println("Player " + player1.id + " has the greater hand! (" + player1.getPlayerTotal() +")");
						System.out.println("CONGRATULATIONS!");
						break;
					}
					case 0:{
						System.out.println("ITS A TIE");
						break;
					}
					case 1:{
						System.out.println("Player " + player2.id + " has the greater hand!(" + player2.getPlayerTotal() +")");
						System.out.println("BETTER LUCK NEXT TIME!");
						break;
					}


				}
				System.out.println("Thank you for playing BlackJack");
				playAgain = false;
				break;
			} while (true);

			System.out.println("Would you like to play again? (y/n)");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			if (input.equals("y")){
				playAgain = true;
				System.out.println("\n\n\n\n\n\n");
			}
			else{
				System.out.println("Thank you for playing BlackJack. Program will now close");
			}
		} while(playAgain);

	//==============================END MAIN===============================

	}

	public static void printDeck(Card[] deck){
		for(int i = 0; i < deck.length; i++){
			System.out.println(deck[i]);
		}
	}

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

	public static void hasBlackJack(Player player){
		int win = 21;
		if (player.getPlayerTotal() == win){
			System.out.println("PLAYER " + player.id 
				+ " HAS DRAWN BLACKJACK");
			System.out.println("CONGRATULATIONS!\n");
			System.exit(player.id);
		}
		else {
			System.out.println("Player " + player.id + " has not drawn BlackJack\n");
		}
	}

	//public static something else i had planned


	public static int playerCompareTo(Player player1, Player player2){
		int num = 0;
		if (player1.getPlayerTotal() > player2.getPlayerTotal()){
			num = 1;
		}
		else if(player1.getPlayerTotal() == player2.getPlayerTotal()){
			num = 0;
		}
		else if(player1.getPlayerTotal() < player2.getPlayerTotal()){
			num = -1;
		}
		return num;
	}

}