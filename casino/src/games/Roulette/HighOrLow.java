package src.games.Roulette;


public class HighOrLow extends Bet{

    String betOn;
    protected HighOrLow(String betOn, int betAmount) {
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
            case "high":
                return (winningNumber >= 19 && winningNumber <= 36);
            case "low":
                return (winningNumber >= 1 && winningNumber <= 18);
            default:
                return false;
        }
    }


    //Below not needed here just because of abstraction and overloading
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



//public class HighOrLow extends Bet{
//    public HighOrLow(Scanner scanner, Player player) {
//        super(scanner, player);
//    }
//    Roulette roulette = new Roulette(scanner, player);
//    int winningNumber = roulette.winningNumber;
//
//    @Override
//    protected void play() {
//        String hl;
//        int hlBetAmount;
//        do {
//            roulette.invalidInputMsg();
//            System.out.println("High or Low?");
//            hl = scanner.nextLine();
//        } while (!validHL(hl));
//
//        do {
//            roulette.howMuchMsg();
//            hlBetAmount = scanner.nextInt();
//        } while (!(roulette.validAmount(hlBetAmount)));
//
//        if (hl.equalsIgnoreCase("high")){
//            if (winningNumber >= 19 && winningNumber <= 36){
//                player.gainChips(hlBetAmount*2);
//            }else {
//                player.loseChips(hlBetAmount);
//            }
//        }else if (hl.equalsIgnoreCase("low")){
//            if (winningNumber >= 1 && winningNumber <= 18){
//                player.gainChips(hlBetAmount*2);
//            }else {
//                player.loseChips(hlBetAmount);
//            }
//        }else {
//            System.out.println("Not a valid high low bet");
//            player.loseChips(hlBetAmount);
//        }
//    }
//
//    boolean validHL(String s){
//        return (s.equalsIgnoreCase("high") || s.equalsIgnoreCase("low"));
//    }
//
//}
