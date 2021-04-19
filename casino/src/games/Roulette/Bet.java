package src.games.Roulette;

public abstract class Bet {


    protected final int betAmount;

    protected Bet(int betAmount) {
        this.betAmount = betAmount;
    }

    public abstract int payout();
    public abstract boolean wasSuccessful(int winningNumber);
    public abstract boolean wasSuccessful(int x, int y, int winningNumber);
    public abstract boolean wasSuccessful(int x, int y, int z, int winningNumber);
    public abstract boolean wasSuccessful(String betOn, int winningNumber);










//    int [][] wheel = {
//            {1,  2,  3},
//            {4,  5,  6},
//            {7,  8,  9},
//            {10, 11, 12},
//            {13, 14, 15},
//            {16, 17, 18},
//            {19, 20, 21},
//            {22, 23, 24},
//            {25, 26, 27},
//            {28, 29, 29},
//            {31, 32, 33},
//            {34, 35, 36}
//    };
}
