package src.games.Roulette;


public class Dozen extends Bet{

    String betOn;
    protected Dozen(String betOn, int betAmount) {
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
                return (winningNumber >= 1 && winningNumber <= 12);
            case "second":
                return (winningNumber >= 13 && winningNumber <= 24);
            case "third":
                return (winningNumber >= 24 && winningNumber <= 36);
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

//public class Dozen extends Bet{
//    Roulette roulette = new Roulette(scanner, player);
//    public Dozen(Scanner scanner, Player player) {
//        super(scanner, player);
//    }
//
//    int winningNumber = roulette.winningNumber;
//
//    @Override
//    protected void play() {
//        int dozen;
//        int dzBetAmount;
//        do {
//            roulette.invalidInputMsg();
//            System.out.println("Which Dozen? 1st 12, 2nd 12 or 3rd 12? ");
//            System.out.println("Enter 1 for first and so on");
//            dozen = scanner.nextInt();
//        } while (dozen < 1 || dozen > 3);
//
//        do {
//            roulette.howMuchMsg();
//            dzBetAmount = scanner.nextInt();
//        } while (!(roulette.validAmount(dzBetAmount)));
//
//        if ( (dozen == 1) && (winningNumber >= 1 && winningNumber <= 12)){
//            player.gainChips(dzBetAmount +(dzBetAmount*2));
//            System.out.println("Winning number is " + winningNumber + "\n");
//        }
//        else if ( (dozen == 2) && (winningNumber >= 13 && winningNumber <= 24) ){
//            player.gainChips(dzBetAmount +(dzBetAmount*2));
//            System.out.println("Winning number is " + winningNumber + "\n");
//        }
//        else if ((dozen == 3 ) && (winningNumber >= 25 && winningNumber <= 36)){
//            player.gainChips(dzBetAmount + (dzBetAmount*2));
//            System.out.println("Winning number is " + winningNumber + "\n");
//        }
//        else{
//            player.loseChips(dzBetAmount);
//            System.out.println("Winning number is " + winningNumber + "\n");
//        }
//
//    }
//}
