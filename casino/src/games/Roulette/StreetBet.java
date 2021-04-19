package src.games.Roulette;


public class StreetBet extends Bet{
    int str1, str2, str3;
    protected StreetBet(int str1, int str2, int str3, int betAmount) {
        super(betAmount);
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    @Override
    public int payout() {
        return 17;
    }

    @Override
    public boolean wasSuccessful(int x, int y, int z,
                                 int winningNumber) {
        return x == winningNumber || y == winningNumber ||
                z == winningNumber;
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
    public boolean wasSuccessful(String betOn, int winningNumber) {
        return false;
    }
}
