import java.util.Random;
public class Player{
	
	public int id;
	public Card[] hand;
	public int index = 0;


	public Player(int id){
		this.id = id;
	}

	public void setID(int id){
		this.id = id;
	}

	public int getID(){
		return this.id;
	}

	public void addCard(Card dealt){
		this.hand[index++] = dealt;
	}

	public void displayHand(){
		System.out.println("\nPLAYER " + id + "'s HAND");
		for (int i = 0; i < index; i++){
			System.out.println(this.hand[i]);
		}
	}

	public void getCardfromDeck(Card[] deck){
		Random random = new Random();
		int newIndex;
		do{
			newIndex = (random.nextInt((deck.length /*- 1*/)) + 0);
		} while (!deck[newIndex].isDealt());
		deck[newIndex].setDealt(true);
		this.addCard(deck[newIndex]);
	}

	public int getPlayerTotal(){
		int sum = 0;
		for(int i = 0; i < this.index; i++){
			sum += hand[i].getRank();
		}
		return sum;
	}

	@Override
	public String toString(){
		String tostring = ("\nPLAYER " + id + "'s HAND");
		for (int i = 0; i < index; i++){
			tostring += (this.hand[i]);
		}
		return tostring;
	}




}


