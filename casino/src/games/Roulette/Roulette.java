package src.games.Roulette;

import src.games.Game;
import src.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Roulette extends Game {

    private final List<String> bets;
    public Roulette(Scanner scanner, Player player) {
        super(scanner, player);

        bets = new ArrayList<>();
    }



    @Override
    protected void play() {
        String betOn = ""; //for bets that have string as bets
        int x = 0, y = 0, z= 0; //for bets that take in more than one bet number

        String betType;
        do {
            System.out.println("What bet type do you want to bet on?\n");
            betTypes();
            betType = scanner.nextLine();
            bets.add(betType);
        } while (!validBetType(betType));

        if (validBetType(betType)){
            do {
                System.out.println("What else do you want to bet on?\n");
                System.out.println("Type [none] if nothing else\n");

                betTypes();
                betType = scanner.nextLine();

                bets.add(betType);

            } while (!betType.equalsIgnoreCase("none"));


            int winningNumber = (int) (Math.random() * 36 + 1);

            for (String bet : bets) {
                rouletteBets(bet, winningNumber, betOn, x, y, z);
            }

        }else {
            System.out.println("Enter something valid");
        }

    }



    //A sub-play method for roulette class to
    // make the play method look cleaner
    protected void rouletteBets(String betType, int winningNumber,
                                String betOn,int x, int y, int z){

    switch (betType) {
        case "st":
            System.out.println("\nSTRAIGHT BET");
            Bet straight = makeStraightBet();
            if (straight.wasSuccessful(winningNumber)){
                player.gainChips(straight.betAmount* straight.payout());
            }else {
                player.loseChips(straight.betAmount);
            }
            break;
        case "sp":
            System.out.println("\nSPLIT BET");
            Bet splitBet = makeSplitBet();
            if (splitBet.wasSuccessful(x, y, winningNumber)){
                player.gainChips(splitBet.betAmount * splitBet.payout());
            }else {
                player.loseChips(splitBet.betAmount);
            }
            break;
        case "str":
            System.out.println("\nSTREET BET");
            Bet street = makeStreetBet();
            if (street.wasSuccessful(x, y, z, winningNumber)){
                player.gainChips(street.betAmount* street.payout());
            }else {
                player.loseChips(street.betAmount);
            }
            break;
        case "sl":
            System.out.println("\nSIX LINE BET");
            Bet sixLine = makeSixLineBet();
            if (sixLine.wasSuccessful(x, y, winningNumber)){
                player.gainChips(sixLine.betAmount * sixLine.payout());
            }else {
                player.loseChips(sixLine.betAmount);
            }
            break;
        case "rb":
            System.out.println("\nRED OR BLACK BET");
            Bet redOrBlack = makeRedOrBlack();
            if (redOrBlack.wasSuccessful(betOn, winningNumber)){
                player.gainChips(redOrBlack.betAmount);
            }else {
                player.loseChips(redOrBlack.betAmount);
            }
            break;
        case "oe":
            System.out.println("\nODD OR EVEN BET");
            Bet oddOrEven = makeOddOrEven();
            if (oddOrEven.wasSuccessful(betOn, winningNumber)){
                player.gainChips(oddOrEven.betAmount);
            }else {
                player.loseChips(oddOrEven.betAmount);
            }
            break;
        case "hl":
            System.out.println("\nHIGH OR LOW BET");
            Bet highOrLow = makeHighOrLow();
            if (highOrLow.wasSuccessful(betOn, winningNumber)){
                player.gainChips(highOrLow.betAmount);
            }else {
                player.loseChips(highOrLow.betAmount);
            }
            break;
        case "dz":
            System.out.println("\nDozen BET");
            Bet dozen = makeDozen();
            if (dozen.wasSuccessful(betOn, winningNumber)){
                player.gainChips(dozen.betAmount* dozen.payout());
            }else {
                player.loseChips(dozen.betAmount);
            }
            break;
        case "cl":
            System.out.println("\nCOLUMN BET");
            Bet column = makeColumn();
            if (column.wasSuccessful(betOn, winningNumber)){
                player.gainChips(column.betAmount * column.payout());
            }else {
                player.loseChips(column.betAmount);
            }
            break;
        default:
            System.out.println("Now going");
            System.out.println("I can't find where I am missing \n" +
                      "a break statement or something and this annoying \n" +
                      "thing keeps printing");
            break;
        }
    }



    private Bet makeStraightBet(){
        int numberBetOn = 0;
        int betAmount;
        do {
            System.out.println("What number do want to bet on?");
            numberBetOn = scanner.nextInt();
        }while ((numberBetOn < 1) || (numberBetOn > 36));
        do {
            System.out.println("How much do you want to bet? ");
            betAmount = scanner.nextInt();
        }while ( ((betAmount < 10) || (betAmount % 10) != 0) ||
                (player.getChipValue() < betAmount));

        player.loseChips(betAmount);
        System.out.println();
        return new Straight(numberBetOn, betAmount);
    }

    boolean validSplit(int num1, int num2){

        if (num1 >= 1 && num1 <= 3){
            if (num1 == 1)
                return (num2 == 2) || (num2 == 4);
            else if (num1 == 2 )
                return (num2 == 1) || (num2 == 3) || (num2 == 5);
            else
                return (num2 == 2) || (num2 == 6);
        }
        else  if (num1 >= 4 && num1 <= 6){
            if (num1 == 4)
                return (num2 == 1) || (num2 == 5) || (num2 == 7);
            else if (num1 == 5)
                return (num2 == 2) || (num2 == 4) || (num2 == 6) || (num2 == 8);
            else
                return (num2 == 3) || (num2 == 5) || (num2 == 9);
        }
        else  if (num1 >= 7 && num1 <= 9){
            if (num1 == 7)
                return (num2 == 4) || (num2 == 8) || (num2 == 10);
            else if (num1 == 8)
                return (num2 == 5) || (num2 == 7) || (num2 == 9) ||
                        (num2 == 11);
            else
                return (num2 == 6) || (num2 == 8) || (num2 == 12);
        }
        else  if (num1 >= 10 && num1 <= 12){
            if (num1 == 10)
                return  (num2 == 7) || (num2 == 11) || (num2 == 13);
            else if (num1 == 11)
                return (num2 == 8) || (num2 == 10) || (num2 == 12) ||
                        (num2 == 14);
            else
                return (num2 == 9) || (num2 == 11) || (num2 == 15);
        }
        else  if (num1 >= 13 && num1 <= 15){
            if (num1 == 13)
                return (num2 == 10) || (num2 == 14) || (num2 == 16);
            else if (num1 == 14)
                return (num2 == 11) || (num2 == 13) || (num2 == 15) ||
                        (num2 == 17);
            else
                return (num2 == 12) || (num2 == 14) || (num2 == 18);
        }
        else  if (num1 >= 16 && num1 <= 18){
            if (num1 == 16)
                return (num2 == 13) || (num2 == 17) || (num2 == 19);
            else if (num1 == 17)
                return (num2 == 14) || (num2 == 16) || (num2 == 18) ||
                        (num2 == 20);
            else
                return (num2 == 15) || (num2 == 17) || (num2 == 21);
        }
        else  if (num1 >= 19 && num1 <= 21){
            if (num1 == 19)
                return (num2 == 16) || (num2 == 20) || (num2 == 22);
            else if (num1 == 20)
                return (num2 == 17) || (num2 == 19) || (num2 == 21) ||
                        (num2 == 23);
            else
                return (num2 == 18) || (num2 == 20) || (num2 == 24);
        }
        else if (num1 >= 22 && num1 <= 24){
            if (num1 == 22)
                return (num2 == 19) || (num2 == 23) || (num2 == 25);
            else if (num1 == 23)
                return (num2 == 20) || (num2 == 22) || (num2 == 24) ||
                        (num2 == 26);
            else
                return (num2 == 21) || (num2 == 23) || (num2 == 27);
        }
        else if (num1 >= 25 && num1 <= 27){
            if (num1 == 25)
                return (num2 == 22) || (num2 == 26) || (num2 == 28);
            else if (num1 == 26)
                return (num2 == 23) || (num2 == 25) || (num2 == 27) ||
                        (num2 == 29);
            else
                return (num2 == 24) || (num2 == 26) || (num2 == 30);
        }
        else if (num1 >= 28 && num1 <= 30){
            if (num1 == 28)
                return (num2 == 25) || (num2 == 29) || (num2 == 31);
            else if (num1 == 29)
                return (num2 == 26) || (num2 == 28) || (num2 == 30) ||
                        (num2 == 32);
            else
                return (num2 == 27) || (num2 == 29) || (num2 == 33);
        }
        else if (num1 >= 31 && num1 <= 33){
            if (num1 == 31)
                return (num2 == 28) || (num2 == 32) || (num2 == 34);
            else if (num1 == 32)
                return (num2 == 29) || (num2 == 31) || (num2 == 33) ||
                        (num2 == 35);
            else
                return (num2 == 30) || (num2 == 32) || (num2 == 36);
        }
        else if (num1 >= 34 && num1 <= 36) {
            if (num1 == 34)
                return (num2 == 31) || (num2 == 35);
            else if (num1 == 35)
                return (num2 == 32) || (num2 == 34) || (num2 == 36);
            else
                return (num2 == 33) || (num2 == 35);
        }
        else
            return false;
    }
    private Bet makeSplitBet(){

        int betAmount = 0;
        int split1, split2;

        do {
            invalidInputMsg();
            System.out.println("1st split number...");
            split1 = scanner.nextInt();
            System.out.println("2nd split number...");
            split2 = scanner.nextInt();
            System.out.println("How much do you want to bet?");
            betAmount = scanner.nextInt();
        } while (!validSplit(split1, split2));


        System.out.println();
        return new SplitBet(split1, split2, betAmount);
    }

    boolean validStreet(int n1, int n2, int n3){
    if ( n1 == 1 || (n1 == 4) || (n1 == 7) || (n1 == 10) || (n1 == 13) ||
            (n1 == 16) || (n1 == 19) || (n1 == 22) || (n1 == 25) ||
            (n1 == 28) || (n1 == 31) || (n1 == 34))
        return (n1 + 1 == n2) && (n2 + 1 == n3);
    else
            return false;
    }
    private Bet makeStreetBet(){
        int betAmount = 0;
        int strNum1, strNum2, strNum3;

        do {
            invalidInputMsg();
            System.out.println("Enter numbers in ascending order\n");
            System.out.println("1st number...");
            strNum1 = scanner.nextInt();
            System.out.println("2nd number...");
            strNum2 = scanner.nextInt();
            System.out.println("3rd number...");
            strNum3 = scanner.nextInt();
        } while (!validStreet(strNum1, strNum2, strNum3));

        return new StreetBet( strNum1, strNum2, strNum3, betAmount);
    }

    boolean validSixLine(int row1, int row2){
        return  ( (row1 - row2 == 3) || (row2 - row1 == 3) );
    }
    private Bet makeSixLineBet(){
        int betAmount;
        int row1Num, row2Num;
        do {
            invalidInputMsg();
            System.out.println("Enter the lowest or first number of each of the 2 rows");
            System.out.println("Enter numbers in ascending order\n");
            System.out.println("First row number...");
            row1Num = scanner.nextInt();
            System.out.println("Second row number...");
            row2Num = scanner.nextInt();
        } while (!validSixLine(row1Num, row2Num));

        do {
            System.out.println("How much to you want to bet?");
            betAmount = scanner.nextInt();
        } while (!validBetAmount(betAmount));

        return new SixLine(row1Num, row2Num, betAmount);
    }


    boolean validRoB(String s){
    return s.equalsIgnoreCase("red") ||
            s.equalsIgnoreCase("black");
    }
    private Bet makeRedOrBlack(){
        int betAmount;
        String betOn;
        do {
            invalidInputMsg();
            System.out.println("\nRed or Black?");
            betOn = scanner.nextLine();
        } while (!validRoB(betOn));
        do {
            inputAmountMsg();
            betAmount = scanner.nextInt();
        } while (!validBetAmount(betAmount));

        return new RedOrBlack(betOn, betAmount);
    }


    boolean validOE(String s){
        return s.equalsIgnoreCase("odd") ||
                s.equalsIgnoreCase("even");
    }
    private Bet makeOddOrEven(){
        String betOn;
        int betAmount;
        do {
            System.out.println("\nOdd or Even");
            betOn = scanner.nextLine();
        } while (!validOE(betOn));
        do {
            inputAmountMsg();
            betAmount = scanner.nextInt();
        } while (!validBetAmount(betAmount));


        return new OddOrEven(betOn, betAmount);
    }


    boolean validHL(String s){
        return s.equalsIgnoreCase("high") ||
                s.equalsIgnoreCase("low");
    }
    private Bet makeHighOrLow(){
        String betOn;
        int betAmount;
        do {
            invalidInputMsg();
            System.out.println("\nHigh or low?");
            betOn = scanner.nextLine();
        } while (!validHL(betOn));

        do {
            inputAmountMsg();
            betAmount = scanner.nextInt();
        } while (!validBetAmount(betAmount));


        return new HighOrLow(betOn, betAmount);
    }

    boolean validDozen(String s){
        return s.equalsIgnoreCase("first") ||
                s.equalsIgnoreCase("second") ||
                s.equalsIgnoreCase("third");
    }
    private Bet makeDozen(){
        int betAmount;
        String betOn;

        do {
            invalidInputMsg();
            System.out.println("First, Second, or Third Dozen?");
            betOn = scanner.nextLine();
        } while (!validDozen(betOn));

        do {
            inputAmountMsg();
            betAmount = scanner.nextInt();
        } while (!validBetAmount(betAmount));


        return new Dozen(betOn, betAmount);
    }


    boolean validColumn(String s){
        return s.equalsIgnoreCase("first") ||
                s.equalsIgnoreCase("second") ||
                s.equalsIgnoreCase("third");
    }
    private Bet makeColumn(){
        int betAmount;
        String betOn;

        do {
            invalidInputMsg();
            System.out.println("First or second or Third Column?");
            System.out.println("Enter first for first and so ...");
            betOn = scanner.nextLine();
        } while (!validColumn(betOn));

        do {
            inputAmountMsg();
            betAmount = scanner.nextInt();
        } while (!validBetAmount(betAmount));

        return new Column(betOn, betAmount);
    }



    protected void betTypes() {
        System.out.println("[ST] Straight, [SP] Split");
        System.out.println("[STR] Street, [SL] Six Line");
        System.out.println("[RB] Red of Black, [OE] Odd or Even");
        System.out.println("[HL] High or Low");
        System.out.println("[CL] Column, [DZ] Dozen");
    }
    protected void invalidInputMsg() {
        System.out.println("Entering invalid input will cause the " +
                "program to re-prompt you for the input\n");
    }
    private boolean validBetType(String betType) {
        return (betType.equalsIgnoreCase("ST") ||
                (betType.equalsIgnoreCase("SP")) ||
                (betType.equalsIgnoreCase("STR")) ||
                (betType.equalsIgnoreCase("SL")) ||
                (betType.equalsIgnoreCase("RB")) ||
                (betType.equalsIgnoreCase("OE")) ||
                (betType.equalsIgnoreCase("HL")) ||
                (betType.equalsIgnoreCase("DZ")) ||
                (betType.equalsIgnoreCase("CL")));
    }
    private boolean validBetAmount(int amount){
        return amount >= 10 && amount % 2 == 0;
    }
    private void inputAmountMsg(){
        System.out.println("How much would you like to bet?" +
                "bets must be multiple of 10");
    }

}


