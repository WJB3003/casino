package io.zipcoder.casino;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Craps extends DiceGame {

    private  double balance = 0;
    private  double wager = 0;
    private  CrapsPlayer player;
    private int roll = throwDice();
    private int point = throwDice();
    private Console console = new Console();

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWager() {
        return wager;
    }

    public CrapsPlayer getPlayer() {
        return player;
    }

    public void setPlayer(CrapsPlayer player) {
        this.player = player;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setPointTester(int point) {
        this.point = point;
    }

    public Craps(Player player) {
        this.player = new CrapsPlayer(player);
       // player.getMoney(accountBalance());
    }

    public void instantWin(){
        console.print("AYYYYY! YOU ROLLED A " + point + "!! GOOD JOB");
        this.addWinnings();
        console.print("Your new balance is "  + balance);
    }

    public void instantLose(){
        console.print("Daaaamn homie, You rolled a " + point +" & crapped out! It's not looking to good for ya!");
        this.subtractWinnings();
        console.print("Your new balance is "  + balance);
    }

    public int setPoint(){
        int point = rollDice();
       console.print("Your point is now " + point + "..... You got this!");
        return point;
    }

    public int chasePoint(){
        console.print("You rolled a " + roll );
        return roll;
    }





    public int throwDice(){
       Dice dice = new Dice(2);
       return dice.tossAndSum();
    }


    public void accountBalance(){

       balance = console.getDoubleInput("How much money are you bringing to the table today?");
    }


    public  void addWinnings(){
        balance = balance + wager;

    }

    public  void betAmount(){

        wager = console.getDoubleInput("How much would you like to wager?");




    }

    public void lookForMatchPoint(int currentRoll){
        int roll = 0;

        console.print("Your point is " + point);
        while (roll != 7) {
            roll = throwDice();
           console.print("You rolled a " + roll);
            if (point == roll) {
                this.winningRoll();
                break;
            }
         else if(roll == 7) {
                this.losingRoll();
            }
        }
    }

    public  void subtractWinnings(){
        balance = balance - wager;

    }

    public  int rollDice(){
        int roll = throwDice();

        return roll;
    }

    public  void winningRoll(){
        console.print("OK K K! WE HAVE A WINNER! STACK YA PAPER");
        this.addWinnings();
        console.print("Your new balance is "  + balance);
    }

    public void losingRoll(){
        console.print("SMH YOU LOST! YOU MIGHT WANT TO CHOOSE ANOTHER GAME PLAYA!");
        this.subtractWinnings();
        console.print("Your new balance is "  + balance);
    }



    public  void promptUser(){



        String answer1;

        System.out.println();

        console.print("Welcome to Craps! \n\n" +
                "The rules of the game are as follows: \n" +
                "If your first roll is is 7 or 11 you instantly win! \n" +
                "If your first roll is 2 or 3 or 12 you instantly lose! \n" +
                "When the first roll is 4,5,6,8,9 or 10, that will become your \"point\"! \n" +
                "You WIN by re-rolling the \"point\" before rolling a 7! \n" +
                "If you roll a 7 before your \"point\" you LOSE!");


        answer1 = console.getStringInput("Would you like to play?");

        answer1.equalsIgnoreCase("Yes");




        console.print("\nGOOD LUCK... Your gonna need it! \n");



    }

    public  void setWager(double wager) {
     this.wager = wager;
    }

    public  double getBalance() {
        return balance;
    }

    public  int getPoint() {
        return point;
    }

    public void playRound(){

        promptUser();
        accountBalance();
        betAmount();

        Scanner scanner = new Scanner(System.in);
        String continuePlayAnswer;

        do {
            //calls the throw dice method to create 2 dice and give the sum of the 2.

            //checks to see if the player instantly wins or loses
            point = throwDice();

            if ( point== 7 || point == 11) {
                this.instantWin();
            } else if (point == 2 || point == 3 || point == 12) {
                this.instantLose();
            //sets point and checks to see if the player rolls the point
            } else lookForMatchPoint(point);


            if(balance == 0) {
                System.out.println("Sadly, you've lost all your money I think it's time for you to go home for the evening BUDDY! :(");
                break;
            }
            System.out.println("Would you like to roll again?");
            continuePlayAnswer = scanner.nextLine();
        }while (continuePlayAnswer.trim().equalsIgnoreCase("yes"));

    }
}

