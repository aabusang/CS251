package src.games.BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Suit> suitsArray;
    List<Rank> ranksArray;
    List<Card> deck;

    public Deck() {
        suitsArray = new ArrayList<>();
        ranksArray = new ArrayList<>();
        deck = new ArrayList<>();
        suitsArray.addAll(Arrays.asList(Suit.SPADE, Suit.CLUB, Suit.HEART,
                Suit.DIAMOND));
        ranksArray.addAll(Arrays.asList(Rank.ACE, Rank.TWO, Rank.THREE,
                Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT,
                Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING));

        //create the deck
        for (int i = 0; i < 4; i++) {
            for (int h = 0; h < 13; h++) {
                deck.add(new Card(suitsArray.get(i), ranksArray.get(h)));
            }
        }
        Collections.shuffle(deck);
    }

    Card dealCard(){
        return deck.remove(0);
    }

}

