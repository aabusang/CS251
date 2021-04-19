package src.games.Roulette;


public class RedOrBlack extends Bet{
    String betOn;
    protected RedOrBlack(String betOn,int betAmount) {
        super(betAmount);
        this.betOn = betOn;
    }

    @Override
    public int payout() {
        return 1;
    }

    @Override
    public boolean wasSuccessful(String betOn, int winningNumber) {
        switch (betOn) {
            case "red":
                isInRed(winningNumber);
            case "black":
                isInBlack(winningNumber);
            default:
                return false;
        }
    }

    int [] Red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30,
            32, 34, 36};
    int [] Black = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28,
            29, 31, 33, 35};

    boolean isInRed(int numberBetOn){
        for (int x : Red){
            if (x == numberBetOn)
                return true;
        }
        return false;
    }

    boolean isInBlack(int numberBetOn){
        for (int x : Black){
            if (x == numberBetOn)
                return true;
        }
        return false;
    }





    //Not needed here.
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

