package entity;

import java.util.ArrayList;

public class Player {

	private int id;

	private String name;

	// list of cards
	private ArrayList<Card> cards = new ArrayList<>();

	// constructor with parameters.
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Player(int id) {
		this.id = id;		
	}
	
	//to play a card
	public void playCard(Card card){
		cards.add(card);
	}

	//to remove a card from deck
	public void removeCard(Card card){
		cards.remove(card);
		return;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//to get list of initial cards.
	public ArrayList<Card> getCards() {
		return cards;
	}

	//to add cards to the deck.
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", cards=" + cards + "]";
	}


}
