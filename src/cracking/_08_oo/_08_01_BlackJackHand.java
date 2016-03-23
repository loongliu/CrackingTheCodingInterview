package cracking._08_oo;

import java.util.ArrayList;
import java.util.Collections;

enum Suit {
	Culb (0), Diamond(1), Heart (2), Spade(3);
	private int value;
	private Suit(int v) { value = v;}
	public int getValue() { return value; }
	public static Suit getSuitFromValue(int value){
		switch(value){
		case 0: return Culb;
		case 1: return Diamond;
		case 2: return Heart;
		case 3: return Spade;
		}
		throw new RuntimeException(" value should between 0 and 3");
	}
}

abstract class Card {
	private boolean available = true;
	protected int faceValue;
	protected Suit suit;
	
	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}
	
	public abstract int value();
	public Suit suit() { return suit; }
	public void mardUnavailable() { available = false;	}
	public void markAvailable() { available = true; }
	public boolean isAvailable() { return available;}
}


class Deck <T extends Card>{
	private ArrayList<T> cards; // all cards
	private int dealtIndex = 0; // index of next cards
	
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}
	/**
	 * shuffle the card, between dealtIndex (include) and cards.length() (exclude)
	 */
	public void shuffle(){
		Collections.shuffle(cards.subList(dealtIndex, cards.size()));
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number){
		if(number + dealtIndex > cards.size()){
			throw new RuntimeException("array size exception");
		}
		@SuppressWarnings("unchecked")
		T[] res = (T[]) new Object[number];
		for(int i = 0; i<number; i++){
			res[i] = cards.get(dealtIndex+i);
		}
		dealtIndex += number;
		return res;
	}
	
	public T dealCard(){
		return cards.get(dealtIndex++);
	}
}

class Hand <T extends Card> {
	protected ArrayList<T> cards = new ArrayList<>();
	
	public int score(){
		int score = 0;
		for(T card : cards){
			score+= card.value();
		}
		return score;
	}
	
	public void addCard(T card){
		cards.add(card);
	}
}

class BlackJackCard extends Card {
	public BlackJackCard(int c, Suit s){
		super(c,s);
	}
	public int value(){
		if(isAce()) return 1;
		else if (faceValue>=11 && faceValue <= 13) return 10;
		else return faceValue;
	}
	
	public int minValue(){
		if(isAce()) return 1;
		else return value();
	}
	public int maxValue(){
		if(isAce()) return 11;
		else return value();
	}
	public boolean isAce(){
		return faceValue == 1;
	}
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
}

class BlackJackHand extends Hand<BlackJackCard>{
	public int score(){
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for(int score : scores){
			if(score > 21 && score < minOver){
				minOver = score;
			}else if(score <= 21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}
	
	private ArrayList<Integer> possibleScores() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(0);
		for(BlackJackCard card : cards){
			ArrayList<Integer> tmp = res;
			res = new ArrayList<Integer>();
			for(int s : tmp){
				res.add(s+card.value());
				if(card.isAce()){
					res.add(s+card.maxValue());
				}
			}
		}
		return res;
	}
	
	public boolean busted() { return score()>21; }
	public boolean is21() { return score()==21;}

}


public class _08_01_BlackJackHand {

	public static void main(String[] args) {

	}

}
