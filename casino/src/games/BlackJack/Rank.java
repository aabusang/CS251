package src.games.BlackJack;

public enum Rank {

    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);


    private int cValue;
    Rank(int cardValue){
        this.cValue = cardValue;
    }

    public int getcValue() {
        return cValue;
    }

    @Override
    public String toString() {
        return "Rank  " +
                "card Value  " + cValue;
    }
}
