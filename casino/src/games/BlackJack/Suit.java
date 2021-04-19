package src.games.BlackJack;

public enum Suit {

    HEART("HEART"),
    CLUB("CLUB"),
    SPADE("SPADE"),
    DIAMOND("DIAMOND");


    String stringValue;

    Suit(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return " " + stringValue;
    }
}
