package src.games.Roulette;

public class OddOrEven extends Bet{
    String betOn;
    protected OddOrEven(String betOn,int betAmount) {
        super(betAmount);
        this.betOn = betOn;
    }

    @Override
    public int payout() {
        return 1;
    }

    @Override
    public boolean wasSuccessful(String betOn, int winningNumber) {
        switch (betOn){
            case "odd":
                return winningNumber % 2 == 0;
            case "even":
                return winningNumber % 2 != 0;
            default:
                return false;
        }
    }






    @Override
    public boolean wasSuccessful(int winningNumber) {
        return false;
    }

    @Override
    public boolean wasSuccessful(int x, int y, int winningNumber) {
        return false;
    }

    @Override
    public boolean wasSuccessful(int x, int y, int z, int winningNumber) {
        return false;
    }

}
