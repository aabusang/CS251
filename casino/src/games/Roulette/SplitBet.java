package src.games.Roulette;

public class SplitBet extends Bet {

    int split1;
    int split2;

    public SplitBet(int split1, int split2, int betAmount) {
        super(betAmount);
        this.split1 = split1;
        this.split2 = split2;
    }

    @Override
    public int payout() {
        return 17;
    }

    @Override
    public boolean wasSuccessful(int winningNumber) {
        return false;
    }

    @Override
    public boolean wasSuccessful(int split1, int split2, int winningNumber) {
        return winningNumber == split1 || winningNumber == split2;
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
