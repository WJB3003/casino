package io.zipcoder.casino;

public class RoulettePlayer implements Gambler {
    private Player player;

    public RoulettePlayer(Player player) {
        this.player = player;
    }

    public void gamble(double wagerAmount) {
        if (player.getMoney() < wagerAmount) {
            System.out.println("You don't have enough money to cover that bet");
        } else {
            wagerAmount = wagerAmount * -1;
            player.setMoney(wagerAmount);
        }
    }
}
