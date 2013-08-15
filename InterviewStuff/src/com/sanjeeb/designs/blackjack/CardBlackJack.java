package com.sanjeeb.designs.blackjack;

public class CardBlackJack extends Card {
	int value[];
	public CardBlackJack(suit aSuit, rank aRank) {
		super(aSuit,aRank);
		setValue();
	}
	
	public int[] getValue() {
		return this.value;
	}
	
	public void setValue() {
		switch(this.getRank())
		{
		case ACE :
			value = new int[]{1, 11};
			break;
		case JACK :
		case QUEEN :
		case KING : 
		case TEN :
			value = new int[]{10};
			break;
		case TWO :
			value = new int[]{2};
			break;
		case THREE :
			value = new int[]{3};
			break;
		case FOUR :
			value = new int[]{4};
			break;
		case FIVE :
			value = new int[]{5};
			break;
		case SIX :
			value = new int[]{6};
			break;
		case SEVEN :
			value = new int[]{7};
			break;
		case EIGHT :
			value = new int[]{8};
			break;
		case NINE :
			value = new int[]{9};
			break;
		}
	}
	@Override
	public String toString() {
		String str = " "; 
		for(int i = 0; i < value.length; ++i) {
			str += this.value[i] + " ";
		}
		return super.toString() + str;
	}
}