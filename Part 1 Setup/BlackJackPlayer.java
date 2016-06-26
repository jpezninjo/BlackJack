import java.util.Random;
public class BlackJackPlayer{
	public static void main(String[] args) {
		
		//Create a deck of 52 cards

		Card[] deck = new Card[52];

		String[] suits = {"clubs", "diamonds", "heart", "spades"};
		int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

		int i = 0;
		for (int j = 0; j < suits.length; j++){
			for(int k = 0; k < ranks.length; k++){
				deck[i++] = new Card(suits[j], ranks[k]);
			}
		}

		//deck[51] = new Card2(suits[2], ranks[2]);

		//BlackJackPlayer2.printDeck(deck);
		//BlackJackPlayer2.shuffleDeck(deck);
		//BlackJackPlayer2.printDeck(deck);
		//System.out.println("HO");

	}

	public static void printDeck(Card[] deck){
		for(int i = 0; i < deck.length; i++){
			System.out.println(deck[i]);
		}
	}

	public static void shuffleDeck(Card[] deck){
		//Pick a random number
		//Pick another random number
		//Swap cards
	    Random random = new Random();
		for(int i = 0; i < 4 * deck.length; i++){
			int int1 = (random.nextInt((deck.length /*- 1*/)) + 0);
			//System.out.println(int1);
			int int2 = (random.nextInt((deck.length /*- 1*/)) + 0);
			//System.out.println(int2);
			//System.out.println("HI");

			Card int3 = deck[int2];
			deck[int2] = deck[int1];
			deck[int1] = int3;
		}
	}

}