import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane; 
public class BlackJackPlayer2{

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
				Player2 player1 = new Player2(1);
				Player2 player2 = new Player2(2);

				//System.out.println("___________________________________________________________");
				//System.out.println("Welcome to BlackJack (Debug mode)!\n\n");
				JOptionPane.showMessageDialog(null, "Welcome to BlackJack! (Debug mode)");

				for (int j = 1; j <= 2; j++){
					player1.getCardfromDeck(deck);
					player2.getCardfromDeck(deck);
				}

				player1.displayHand();
				player2.displayHand();

				BlackJackPlayer2.hasBlackJack(player1);
				BlackJackPlayer2.hasBlackJack(player2);

				int reply = 0;

				do{
					//System.out.println("Your turn. Would you like to draw a card? (y/n)");
					//Scanner scanner = new Scanner(System.in);
					//input = scanner.nextLine();

					//input = JOptionPane.showInputDialog("Your turn. Would you like to draw a card? (y/n)");
					reply = JOptionPane.showConfirmDialog(null, "Your turn. Would you like to draw a card?\n(Your hand is currently " + player1.getPlayerTotal() +
						")", "PLAYER1's TURN", JOptionPane.YES_NO_OPTION);

					//if (input.equals("y")){
					if (reply == JOptionPane.YES_OPTION){
						player1.getCardfromDeck(deck);
						player1.displayHand();
					}

					BlackJackPlayer2.hasBlackJack(player1);

				} while ((reply == JOptionPane.YES_OPTION) && (player1.getPlayerTotal() <= 21));

				if (player1.getPlayerTotal() > 21){
					//System.out.println("PLAYER " + player1.id + " HAS GONE OVER 21");
					//System.out.println("BETTER LUCK NEXT TIME!");
					JOptionPane.showMessageDialog(null, "PLAYER " + player1.id + " HAS GONE OVER 21");
					JOptionPane.showMessageDialog(null, "BETTER LUCK NEXT TIME!");
					break;
				}
				else if (player2.getPlayerTotal() > 21){
					//System.out.println("PLAYER " + player2.id + " HAS GONE OVER 21");
					//System.out.println("YOU WIN!");
					JOptionPane.showMessageDialog(null, "PLAYER " + player2.id + " HAS GONE OVER 21");
					JOptionPane.showMessageDialog(null, "YOU WIN!");
					break;
				}

				while (player2.getPlayerTotal() < 17){
					//System.out.println("Player " + player2.id + " has a hand of " + 
					//	player2.getPlayerTotal() + " and has to draw again");
					JOptionPane.showMessageDialog(null, "Player " + player2.id + " has a hand of " + 
						player2.getPlayerTotal() + " and has to draw again");
					player2.getCardfromDeck(deck);
					player2.displayHand();
				}

				BlackJackPlayer2.hasBlackJack(player2);
				if (player2.getPlayerTotal() > 21){
					//System.out.println("PLAYER " + player2.id + " HAS GONE OVER 21");
					//System.out.println("BETTER LUCK NEXT TIME!");
					JOptionPane.showMessageDialog(null, "PLAYER " + player2.id + " HAS GONE OVER 21\nBETTER LUCK NEXT TIME!");
					//OptionPane.showMessageDialog(null, "BETTER LUCK NEXT TIME!");
					//System.exit(5);
					break;				//THIS PART NEEDS PATCHING
				}

				//System.out.println("\n\nGAME DONE\n");
				//JOptionPane.showMessageDialog(null, "GAME DONE");
				switch (BlackJackPlayer2.playerCompareTo(player1, player2)){

					case -1:{
						//System.out.println("Player " + player1.id + " has the greater hand! (" + player1.getPlayerTotal() +")");
						//System.out.println("CONGRATULATIONS!");
						JOptionPane.showMessageDialog(null, "Player " + player1.id + " has the greater hand! (" + player1.getPlayerTotal() +")\nCONGRATULATIONS!");
						//JOptionPane.showMessageDialog(null, "CONGRATULATIONS!");
						break;
					}
					case 0:{
						//System.out.println("ITS A TIE");
						JOptionPane.showMessageDialog(null, "ITS A TIE");
						break;
					}
					case 1:{
						//System.out.println("Player " + player2.id + " has the greater hand!(" + player2.getPlayerTotal() +")");
						//System.out.println("BETTER LUCK NEXT TIME!");
						JOptionPane.showMessageDialog(null, "Player " + player2.id + " has the greater hand!(" + player2.getPlayerTotal() +")\nBETTER LUCK NEXT TIME!");
						//OptionPane.showMessageDialog(null, "BETTER LUCK NEXT TIME!");
						break;
					}


				}
				//System.out.println("Thank you for playing BlackJack");
				//JOptionPane.showMessageDialog(null, "Thank you for playing BlackJack");
				playAgain = false;
				break;
			} while (true);

			//System.out.println("Would you like to play again? (y/n)");
			//Scanner scanner = new Scanner(System.in);
			//String input = scanner.nextLine();
			//String input = JOptionPane.showInputDialog("Would you like to play again? (y/n)");
			int reply = JOptionPane.showConfirmDialog(null, "Thank you for playing BlackJack\nWould you like to play again?", "Do Over?", JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION){
				playAgain = true;
				//System.out.println("\n\n\n\n\n\n");
			}
			else{
				//System.out.println("Thank you for playing BlackJack. Program will now close");
				JOptionPane.showMessageDialog(null, "Thank you for playing BlackJack. Program will now close");
				playAgain = false;
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

	public static void hasBlackJack(Player2 player){
		int win = 21;
		if (player.getPlayerTotal() == win){
			//System.out.println("PLAYER " + player.id 
			//	+ " HAS DRAWN BLACKJACK");
			//System.out.println("CONGRATULATIONS!\n");
			JOptionPane.showMessageDialog(null, "PLAYER " + player.id 
				+ " HAS DRAWN BLACKJACK");
			JOptionPane.showMessageDialog(null, "CONGRATULATIONS!");
			//System.exit(player.id);
		}
		else {
			//System.out.println("Player " + player.id + " has not drawn BlackJack\n");
			JOptionPane.showMessageDialog(null, "Player " + player.id + " has not drawn BlackJack");
		}
	}

	//public static something else i had planned


	public static int playerCompareTo(Player2 player1, Player2 player2){
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