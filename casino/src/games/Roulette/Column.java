package src.games.Roulette;


public class Column extends Bet{

    String betOn;
    protected Column(String betOn, int betAmount) {
        super(betAmount);
        this.betOn = betOn;
    }

    @Override
    public int payout() {
        return 2;
    }

    @Override
    public boolean wasSuccessful(String betOn, int winningNumber) {
        switch (betOn){
            case "first":
                return inCol1(winningNumber);
            case "second":
                return inCol2(winningNumber);
            case "third":
                return inCol3(winningNumber);
            default:
                return false;
        }
    }


    boolean inCol1(int x){
        for (int i = 1; i < 35; i += 3){
            if (x == (i))
                return true;
        }
        return false;
    }
    boolean inCol2(int x){
        for (int i = 2; i < 37; i += 3){
            if (x == (i))
                return true;
        }
        return false;
    }
    boolean inCol3(int x){
        for (int i = 3; i < 37; i += 3){
            if (x == (i))
                return true;
        }
        return false;
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
