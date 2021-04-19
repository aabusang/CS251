package src.games.BlackJack;

import src.games.Game;
import src.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class BlackJack extends Game {


    private final List<Card> playerHand;
    private final List<Card> dealerHand;

    Deck deck = new Deck();

    private int playerHandValue = 0;
    private int dealerHandValue = 0;
    private int betAmount;

    private boolean hitAgain = false;
    private String again;

    public BlackJack(Scanner scanner, Player player) {
        super(scanner, player);

        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();

    }


    @Override
    protected void play() {

        System.out.println("How much would you like to bet?");
        betAmount = scanner.nextInt();

        if (validBetAmount(betAmount)) {

            first2Cards();

            System.out.println();
            System.out.println("Dealer has a " + dealerHand.get(0) + " and a...[Face Down]");
            System.out.println("You have a " + playerHand.get(0) + " and a " + playerHand.get(1));
            System.out.println("\nYour hand value is " + playerHandValue);

            if (naturalBJ(playerHandValue) && !naturalBJ(dealerHandValue)) {
                System.out.println("You got a Black Jack");
                System.out.println("Dealer hand value was " + dealerHandValue);
                System.out.println("You hand value was " + playerHandValue);
                player.gainChips(betAmount * 3);
                System.out.println();
            } else if (naturalBJ(dealerHandValue) && !naturalBJ(playerHandValue)) {
                System.out.println("Dealer has a black jack");
                player.loseChips(betAmount);
            } else if (naturalBJ(dealerHandValue) && naturalBJ(playerHandValue)) {
                System.out.println("You both got a black jack");
                System.out.println("You have your original bet back");
            } else {

                String nextAction;
                System.out.println("What do you want to do [h]?");
                nextActions();
                nextAction = scanner.next();

                switch (nextAction) {
                    case "h":
                        playerHit();
                    case "s":
                        playerStand();
                    case "dd":
                        DoubleDown();
                    case "ff":
                        playerSurrender();
                    default:
                        System.out.println("chose a valid next action");
                }
            }

        }else {
            System.out.println("Bet amount must be a multiple of 10");
        }

    }


    boolean validBetAmount(int x){
        return x % 10 == 0;
    }
    boolean validNextAction(String s){
        return s.equalsIgnoreCase("h") ||
                s.equalsIgnoreCase("s") ||
                s.equalsIgnoreCase("dd") ||
                s.equalsIgnoreCase("ff");
    }
    void nextActions(){
        System.out.println("[h] Hit");
        System.out.println("[s] Stand");
        System.out.println("[dd] Double Down");
        System.out.println("[ff] Surrender");
    }


    void updatePlayerHand() {
        playerHandValue = 0;
        for (Card x : playerHand){
            playerHandValue += x.getRankValue();
        }
    }

    void updateDealerHand(){
        dealerHandValue = 0;
        for (Card x: dealerHand){
            dealerHandValue += x.getRankValue();
        }
    }
    private void printPlayerHand(){
        for (Card x : playerHand){
            System.out.println(x);
        }
    }

    private void printDealerHand(){
        for (Card x : dealerHand){
            System.out.println(x);
        }
    }
    private boolean naturalBJ(int handValue){
        return handValue == 21;
    }

    private void first2Cards(){
        //PLAYER
        playerHand.add(deck.dealCard());
        updatePlayerHand();
        playerHand.add(deck.dealCard());
        updatePlayerHand();
        //DEALER
        dealerHand.add(deck.dealCard());
        updateDealerHand();
        dealerHand.add(deck.dealCard());
        updateDealerHand();
    }

    private void playerHit(){
        do {
            System.out.println("You are hitting");
            Card newCard = deck.dealCard();
            playerHand.add(newCard);
            updatePlayerHand();

            printPlayerHand();
            System.out.println("Your hand value is " + playerHandValue);
            if (playerHandValue > 21){
                System.out.println("YOU BUSTED\n");
                System.out.println("Dealer hand value was " + dealerHandValue);
                player.loseChips(betAmount);
            }else if (playerHandValue == 21){
                player.gainChips(betAmount);
            } else {
                System.out.println("What next? ");
                nextActions();
                again = scanner.next();
            }
            if (again.equalsIgnoreCase("h")){
                hitAgain = true;
            }else if (again.equalsIgnoreCase("s")){
                playerStand();
            }else if (again.equalsIgnoreCase("ff")){
                playerSurrender();
            }
        } while (hitAgain);
    }

    private void playerStand(){
        System.out.println("You are standing...");
        if (dealerHandValue > 21){
            System.out.println("Dealer busted");
            player.gainChips(betAmount);
        }else if (dealerHandValue >= 17){
            System.out.println("Dealer Hand value is 17 or " +
                    "more so they are standing");
        }
        while (dealerHandValue <= 16){
            Card nCard = deck.dealCard();
            System.out.println("Dealer hitting...");
            dealerHand.add(nCard);
            updateDealerHand();
            System.out.println("Dealer hand value is now "+ dealerHandValue);
        }

    }
    private void DoubleDown(){
        playerHit();
        playerStand();
    }
    private void playerSurrender(){
        System.out.println("\nYou Surrendered ");
        player.loseChips(betAmount - (betAmount / 2));
    }

}


