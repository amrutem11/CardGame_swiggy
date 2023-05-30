package entity;

import java.util.ArrayList;
import java.util.Scanner;

import exception.PlayerException;

public class Game {

    private ArrayList<Card> drawPile = new ArrayList<>();

    private ArrayList<Card> pileCards = new ArrayList<>();
    
    private ArrayList<Card> deck;

    private ArrayList<Player> playerList = new ArrayList<>();
    
    
    public void startGame() throws Exception, PlayerException{
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of players between 2 and 4");
        
        int num = sc.nextInt();

        // to check whether the entered number is valid or not
        
        if (num < 2 || num > 4) {
            throw new PlayerException("Invalid number of players entered... please retry with entering valid number between 2 and 4 !!");
        }

        //deck creation 
        deck = new Deck().getDeck();
        
        for (int i = 1; i <= num; i++) {
            Player p = new Player(i);

            // initially adding 5 - 5 cards in each player's deck
            for (int j = 1; j <= 5; j++) {
            	
                p.playCard(deck.get(deck.size() - 1));
                
                deck.remove(deck.size() - 1);
            }
            
            playerList.add(p);

        }

        int playerTurn = 0;
        int direction = 1;
        int CardsTaken = 1;

        pileCards.add(deck.get(0));
        
        deck.remove(0);

        // creating a draw pile from the deck.
             
        for (Card card : deck) {
            drawPile.add(card);
        }     

        while (true) {
            // if the drawpile is empty then result will be a draw
            if (drawPile.size() < CardsTaken) {
                System.out.println("Oops !!! ...Game is drawn !! number of cards are less !!!");
                break;
            }

            playerTurn %= num;
            
            if (playerTurn < 0) 
            	playerTurn += num; 
            playerTurn %= num;

            // current player will atleast have 1 card ..

            boolean same = false;
            
            int Number = -1;
            
            Card topCard = pileCards.get(pileCards.size() - 1); 
            
            System.out.println("top card is = " + pileCards.get(pileCards.size() - 1));

            for (Card currentCard : playerList.get(playerTurn).getCards()) {
               
                if (currentCard.getValue() == topCard.getValue() || currentCard.getShape() == topCard.getShape()) {

                    // checking if special card on Pile top , so that they are not adjustable

                    if (topCard.getValue() == 1 || topCard.getValue() == 11 || topCard.getValue() == 12 
                    		|| topCard.getValue() == 13) {
                    	
                        if (currentCard.getValue() == topCard.getValue()) {
                        	continue;
                        }
                        	
                    }
                    // if cards matched then this statement will be printed.
                    System.out.println("Cards are same for players : " + playerList.get(playerTurn).getId() 
                    		+ " current card and new card at top = : " + currentCard);
                    
                    if(CardsTaken > 1){
                    	
                        while (CardsTaken-- > 0) {
                        	
                            System.out.println("Drawing " + drawPile.get(drawPile.size() - 1) + " Card : ");
                          
                            playerList.get(playerTurn).playCard(drawPile.get(drawPile.size() - 1));
                            
                            drawPile.remove(drawPile.size() - 1);
                        }
                        CardsTaken = 1;
                    }

                   
                    playerList.get(playerTurn).removeCard(currentCard);
                                       
                    pileCards.add(currentCard);
                    
                    same = true;
                    
                    Number = currentCard.getValue();
                    
                    break;
                }
            }

            if (same == false) {
                System.out.println("No cards matched for player number :  " + playerList.get(playerTurn).getId() + " Taking " + CardsTaken + " Card(s)");
               
                while (CardsTaken-- > 0) {
                    System.out.println("Drawing :  " + drawPile.get(drawPile.size() - 1) + "Card");
                    
                    playerList.get(playerTurn).playCard(drawPile.get(drawPile.size() - 1));
                    
                    drawPile.remove(drawPile.size() - 1);
                }
                CardsTaken = 1;
            }

            if (same == true && playerList.get(playerTurn).getCards().size() == 0) {

                System.out.println("Congratulations ...!! " + playerList.get(playerTurn).getId() + "won the match !!!");

                System.exit(0);
            }

            //some additional feautures which i would like to add
            

            if (same == true && Number == 13) {
                direction *= -1;
            }
            
            if (same == true && Number == 1) {
                playerTurn += direction;
            }
            
            // to determine the next player
            playerTurn += direction;

            System.out.println("->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>-");
        }



    }

}
