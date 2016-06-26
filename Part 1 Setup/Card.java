public class Card{

	//DO NOT NAME ANY OF THESE STATIC LIKE AT ALL
	public String suit;
	public int rank;
	public boolean isDealt = false;


	public Card(String suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}

	public void setSuit(String suit){
		this.suit = suit;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public void setDealt(boolean isDealt){
		this.isDealt = isDealt;
	}

	public String getSuit(){
		return this.suit;
	}

	public int getRank(){
		return this.rank;
	}

	public boolean getDealt(){
		return this.isDealt;
	}

	@Override
	public String toString(){
		String s2String = "Suit: " + this.suit + ". Rank: " 
		+ this.rank + ". Dealt: " + this.isDealt;
		return s2String;
	}


}