import java.util.Random;
import javax.swing.JOptionPane; 
public class Player2{
	
	public int id;
	public Card[] hand = new Card[500];
	public int index = 0;


	public Player2(int id){
		this.id = id;
	}

	public void setID(int id){
		this.id = id;
	}

	public int getID(){
		return this.id;
	}

	public void addCard(Card dealt){
		this.hand[this.index++] = dealt;
	}

	public void displayHand(){
		//System.out.println("PLAYER " + id + "'s HAND");
		String string1 = "";
		for (int i = 0; i < index; i++){
			string1 += this.hand[i] + "\n";
			//System.out.println(this.hand[i]);
		}
		//System.out.println("TOTAL: " + this.getPlayerTotal() +"\t\t<--- \n");
		JOptionPane.showMessageDialog(null, "PLAYER " + id + "'s HAND\n" + string1 + "TOTAL: " + this.getPlayerTotal());
	}

	public void getCardfromDeck(Card[] deck){
		System.out.println("Getting card from deck...");
		Random random = new Random();
		int newIndex;
		do{
			newIndex = (random.nextInt((deck.length)) + 0);
			System.out.println("Found card " +  deck[newIndex]);
		} while (deck[newIndex].isDealt());
		System.out.println("Adding card to player " + this.id + "'s hand\n\n");
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


