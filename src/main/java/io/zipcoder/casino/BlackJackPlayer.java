
package io.zipcoder.casino;

public class BlackJackPlayer implements Gambler {
    private Player player;
    private Hand playerHand = new Hand();
    private double money;
    private int age;
    private String name;
    private double wagerAmount;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setWagerAmount(double wagerAmount){
        this.wagerAmount = wagerAmount;
    }

    public double getWagerAmount(){
        return wagerAmount;
    }



    public void setName(String name) {
        this.name = name;
    }

    public BlackJackPlayer(Player player) {

        this.name = player.getName();
        this.money = player.getMoney();
        this.age = player.getAge();
        this.player = player;
    }

    public void gamble(double wagerAmount) {
        if (player.getMoney() < wagerAmount) {
            System.out.println("You don't have enough money to cover that bet");
        } else {
            wagerAmount = wagerAmount * -1;
            player.setMoney(player.getMoney() - wagerAmount);
        }
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }
}

