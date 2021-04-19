package src.games.BlackJack;


public class Card {

    private final Suit suitType;
    private final Rank rankValue;

    Card (Suit suitType, Rank rankValue) {
        this.suitType = suitType;
        this.rankValue = rankValue;

    }

    public int getRankValue() {
        return rankValue.getcValue();
    }

    public Suit getSuitType() {
        return suitType;
    }


    @Override
    public String toString() {
        return getRankValue()  + " Of " + getSuitType();
    }
}
