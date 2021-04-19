package src.games.Roulette;


public class SixLine extends Bet{
    int row1Num, row2Num;
    protected SixLine(int row1Num , int row2Num, int betAmount) {
        super(betAmount);
        this.row1Num = row1Num;
        this.row2Num = row2Num;
    }

    @Override
    public int payout() {
        return 5;
    }
    /**
     * if the winning number is greater than or
     * equal to the first/lowest number of the first row
     * and <= the the last number of the second
     * row (second row first number + 2);
     * then it's a win for the user
     *
     * @param row1Num the first number of the first row
     * @param row2Num the first number of he second row
     * @param winningNumber the random winning number
     * **/
    @Override
    public boolean wasSuccessful(int row1Num, int row2Num,
                                 int winningNumber) {
        return winningNumber >= row1Num &&
                winningNumber <= (row2Num+2);
    }





    //The below is now useful in this method I have
    // them because of abstraction. I must implement them
    @Override
    public boolean wasSuccessful(int x, int y, int z, int winningNumber) {
     return false;
    }

    @Override
    public boolean wasSuccessful(int winningNumber) {
        return false;
    }


    @Override
    public boolean wasSuccessful(String betOn, int winningNumber) {
        return false;
    }
}

