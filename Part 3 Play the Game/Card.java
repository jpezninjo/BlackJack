public class Card{

	//Initialize variables
	public String suit;
	public int rank;
	public boolean isDealt = false;


	//Card class constructor
	public Card(String suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}

	//Setters
	public void setSuit(String suit){
		this.suit = suit;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public void setDealt(boolean isDealt){
		this.isDealt = isDealt;
	}

	//Getters
	public String getSuit(){
		return this.suit;
	}

	public int getRank(){
		return this.rank;
	}

	public boolean isDealt(){
		return this.isDealt;
	}

	//ToString
	@Override
	public String toString(){
		String s2String = "";
		if (this.suit.equals("diamonds")){
			s2String = "Suit: " + this.suit + ".    Rank: " 
		+ this.rank + ". \tDealt: " + this.isDealt;
		}
		else {
			s2String = "Suit: " + this.suit + ". \tRank: " 
		+ this.rank + ". \tDealt: " + this.isDealt;
	}
		return s2String;
	}


}