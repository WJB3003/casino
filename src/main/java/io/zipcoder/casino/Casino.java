package io.zipcoder.casino;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Casino {
    private Player player;
    private int response;
//    private InputStream in;
//    private PrintStream outprint;
    private Game game;
    private Console console = new Console();

    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.createPlayer();
        casino.playGame();
    }

    public Casino() {
//        this.player = player;
    }

    public String findName(){
        return console.getStringInput("Please enter your name.");
    }

    public int findAge(){
        return console.getIntegerInput("Please enter your age.");
    }

    public double findMoney(){
        return console.getDoubleInput("Please enter the amount of money in your account");
    }

    public void createPlayer(){
        player = new Player(findName(), findAge(), findMoney());
    }

    public void playGame() {
        selectGamePrompt();
        response = selectedGame();
        while (response == 1 || response == 2 || response == 3) {
            startGame();
            selectGame();
//            response = selectedGame();
        }
        console.print("Thank you for visiting ZipCasino");
    }

    public void selectGame() {
        console.print("Welcome " + player.getName() + " to ZipCasino");
        selectGamePrompt();
        selectedGame();
    }

    public int selectedGame(){
        int output = console.getIntegerInput("Enter the number for what game you want to play.");
        return output;
    }

    public void startGame(){
        startCraps();
        startBlackJack();
        startGoFish();
    }

    public void startCraps(){
        if (response == 1) {
            game = new Craps(player);
            game.playRound();
        }
    }

    public void startBlackJack(){
        if (response == 2) {
            game = new BlackJack(player);
            game.playRound();
        }
    }

    public void startGoFish(){
        if (response == 3) {
            game = new GoFish(player);
            game.playRound();
        }
    }

    public void selectGamePrompt(){
        console.print("1: Craps");
        console.print("2: BlackJack");
        console.print("3: Go Fish. WIP");
        console.print("Press any other key to leave.");
    }
}