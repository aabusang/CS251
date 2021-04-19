package src.games.Roulette;


public class Straight extends Bet {

    private final int sNumberBetOn;


    public Straight(int sNumberBetOn, int betAmount) {
        super(betAmount);
        this.sNumberBetOn = sNumberBetOn;
    }
    @Override
    public boolean wasSuccessful(int winningNumber){
        return sNumberBetOn == winningNumber;
    }


    @Override
    public int payout() {
        return 37;
    }

    @Override
    public boolean wasSuccessful(int x, int y, int winningNumber) {
        return false;
    }

    @Override
    public boolean wasSuccessful(int x, int y, int z, int winningNumber) {
        return false;
    }

    @Override
    public boolean wasSuccessful(String betOn, int winningNumber) {
        return false;
    }
}
