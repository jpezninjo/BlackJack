import java.util.Random;
public class Player{
	
	//Initialize variables
	public int id;
	public Card[] hand = new Card[500];
	public int index = 0;

	//Player class constructor
	public Player(int id){
		this.id = id;
	}

	//Setters
	public void setID(int id){
		this.id = id;
	}

	//Getters
	public int getID(){
		return this.id;
	}

	//This method adds a Card to the Player.hand
	public void addCard(Card dealt){
		this.hand[this.index++] = dealt;
	}

	//This method displays this Player's Card(s)
	public void displayHand() throws InterruptedException{
		System.out.println("\n");
		BlackJackPlayer.smoothStringDisplay("PLAYER " + id + "'s HAND", 250);
		System.out.println("\n");
		for (int i = 0; i < index; i++){
			//I am a genius
			BlackJackPlayer.smoothStringDisplay(this.hand[i].toString(), 250);
			System.out.println("\n");
		}
		BlackJackPlayer.smoothStringDisplay("TOTAL: " + this.getPlayerTotal() +"\t<--- \n", 250);
	}

	//This method adds a Card to the Player.hand using the addCard() method
	public void getCardfromDeck(Card[] deck) throws InterruptedException{
		BlackJackPlayer.smoothStringDisplay("Getting card from deck...", 750);
		System.out.println("");
		Random random = new Random();
		int newIndex;
		do{
			Thread.sleep(750);
			newIndex = (random.nextInt((deck.length)) + 0);
			BlackJackPlayer.smoothStringDisplay("Found card-  " +  deck[newIndex], 500);
			System.out.println("\n");
		} while (deck[newIndex].isDealt());
		Thread.sleep(1000);
		BlackJackPlayer.smoothStringDisplay("Adding card to PLAYER " + this.id + "'s hand\n\n", 500);
		deck[newIndex].setDealt(true);
		this.addCard(deck[newIndex]);
	}

	//This method returns the total value of all Card(s) in this Player's hand
	public int getPlayerTotal(){
		int sum = 0;
		for(int i = 0; i < this.index; i++){
			sum += hand[i].getRank();
		}
		return sum;
	}

	//ToString
	@Override
	public String toString(){
		String tostring = ("\nPLAYER " + id + "'s HAND");
		for (int i = 0; i < index; i++){
			tostring += (this.hand[i]);
		}
		return tostring;
	}




}


