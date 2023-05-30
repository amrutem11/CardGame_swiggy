package entity;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;


    public Deck() {
        // creating the deck.
        deck = new ArrayList<>();
        for(Shapes shape : Shapes.values()){

            for(int i = 1; i <= 13; i++){
                deck.add(new Card(i,shape));
            }

        }
        
        // to shuffle the deck we will use collections.
        Collections.shuffle(deck);

    }
    
    // to get the list of cards in the deck
    public ArrayList<Card> getDeck() {
        return deck;
    }
    
    public Card dragCard() {
    	
    	Card card=null;
    	
    	for(Card c : deck) {
    		card = c;
    	}
    	
    	return card;
    }
}
