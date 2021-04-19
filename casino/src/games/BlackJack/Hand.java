package src.games.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    protected final List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard(Card c){
        hand.add(c);
    }


    public int getCardCount(){
        return hand.size();
    }


//    protected Card getCard(){
//        for (Card card : hand) return card;
//    }


    public int getBJHandValue(){
        //returns the value of the given hand
        int handValue = 0;
        boolean ace = false;
        int cardCount = getCardCount();

        //loop hand, add card, check for an ace
        for (int i = 0; i < cardCount; i++){
            int givenCardValue  = hand.get(i).getRankValue(); // = rank or value of the card
            //I need the value of the card here
            if (givenCardValue == 1) {
                ace = true;
            }
        }

        if (ace && handValue + 10 <= 21)
            handValue += 10;

        return handValue;
    }

    @Override
    public String toString() {
        return "Hand " +
                "hand = " + hand ;
    }
}
