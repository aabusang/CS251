package src.games.SlotMachine;

import src.Utils;
import src.games.Game;
import src.player.Player;

import java.util.Scanner;

public class SlotMachine extends Game {

    public SlotMachine(Scanner scanner, Player player) {
        super(scanner, player);
    }

    //3 random numbers to determine the 3 possible winds in
    // spade, diamond, heart and lb  AND
    // the two in horseshoe and star

    int rand1 = (int) (Math.random() * 6 + 1);
    int rand2 = (int) (Math.random() * 6-1 + 1);
    int rand3  = (int) (Math.random() * 6 + 1);

    @Override
    protected void play() {

        int n = player.getChipValue();
        if ( n >= 5){
            System.out.println("What would you like to do? ");
            System.out.println("[p] Play: ");
            System.out.println("[q] Walk away: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "p": {
                    if ((rand1 == 1) && (rand2 == 1) && (rand3 == 2)) {
                        player.gainChips(10);
                        System.out.println("2 HORSES, 1 STAR");
                    }
                    //two horses and a star
                    else if (((rand1 == 1) && (rand3 == 1)) && (rand2 == 2)) {
                        player.gainChips(10);
                        System.out.println("2 HORSES, 1 STAR");
                    }
                    //two horses one star
                    else if (((rand2 == 1) && (rand3 == 1)) && (rand1 == 2)) {
                        player.gainChips(10);
                        System.out.println("2 HORSES, 1 STAR");
                    }
                    else if (((rand1 == 1) && (rand2 == 1)) ||
                            ((rand1 == 1) && (rand3 == 1)) ||
                            ((rand2 == 1) && (rand3 == 1))) {
                        player.gainChips(5);
                        System.out.println("2 HORSES, 1 STAR");
                    }
                    //3 spades spade is 3
                    else if ((rand1 == 3) && (rand2 == 3) && (rand3 == 3)) {
                        player.gainChips(20);
                        System.out.println();
                        System.out.println("DIAMOND DIAMOND DIAMOND");
                    }
                    //3 diamonds. diamond is 4
                    else if ((rand1 == 4) && (rand2 == 4) && (rand3 == 4)) {
                        player.gainChips(30);
                        System.out.println("HEART HEART HEART");
                    }
                    //3 hearts heart is 5
                    else if ((rand1 == 5) && (rand2 == 5) && (rand3 == 5)) {
                        player.gainChips(40);
                        System.out.println("SPADE SPADE SPADE");
                    }
                    //3 liberty bells
                    else if ((rand1 == 6) && (rand2 == 6) && (rand3 == 6)) {
                        player.gainChips(50);
                        System.out.println("LIBERTY BELL    LIBERTY BELL    LIBERTY BELL");
                    } else {
                        player.loseChips(5);
                    }
                }
                case "q":
                    System.out.println("Thanks for playing");
                default: {
                    System.out.println(Utils.invalidChoice(choice));
                    startGame();
                }
            }
        }
        else {
            System.out.println("You need a minimum of 5 chips ($5) to play");
        }
    }
}

