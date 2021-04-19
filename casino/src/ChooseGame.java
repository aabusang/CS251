package src;

import src.games.BlackJack.BlackJack;
import src.games.Game;
import src.games.Roulette.Roulette;
import src.games.SlotMachine.SlotMachine;
import src.games.bigsixwheel.BigSixWheel;
import src.player.Player;

import java.util.Scanner;

/**
 * The class acts as the welcome mat to the casino. It allows
 * you to get your initial chip count as well as choose which
 * game you want to play.
 */
public class ChooseGame {
    private final Scanner scanner;
    private final Player player;

    public ChooseGame(Scanner scanner) {
        this.scanner = scanner;

        welcome();

        System.out.println("How much money do you have to convert to chips? ");
        int chips = scanner.nextInt();

        this.player = new Player(chips);

        System.out.println("Great! Here is $" + chips + " worth of chips!");
    }

    private void welcome() {
        System.out.println("Welcome to my casino where your wildest dreams " +
                "can come true!! At a price of course...");
    }



        public void chooseGame() {
            System.out.println("Which game would you like to play?");
            System.out.println("[bw] big six wheel");
            System.out.println("[sm] slot machine");
            System.out.println("[ro] roulette");
            System.out.println("[bj] blackjack");
            System.out.println("[q] leave casino");

            String choice = scanner.next();
            switch (choice) {
                case "bw":
                    Game bigSixWheel = new BigSixWheel(scanner, player);
                    bigSixWheel.startGame();
                    chooseGame();
                    break;
                case "sm":
                    // TODO: Implement this game
                    Game slotMachine = new SlotMachine(scanner, player);
                    slotMachine.startGame();
                    chooseGame();
                    break;
                case "ro":
                    // TODO: Implement this game
                    Roulette roulette = new Roulette(scanner, player);
                    roulette.startGame();
                    chooseGame();
                    break;
                case "bj":
                    // TODO: Implement this game
                    BlackJack blackJack = new BlackJack(scanner, player);
                    blackJack.startGame();
                    chooseGame();
                    break;
                case "q":
                    System.out.println("Come again soon!");
                    break;
                default:
                    System.out.println(Utils.invalidChoice(choice));
                    chooseGame();
                    break;
            }
    }
}
