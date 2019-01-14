package io.zipcoder.casino;

public class GoFishPlayer {
    private Player player;
    private Hand playerHand = new Hand();

    public GoFishPlayer(Player player) {
        this.player = player;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }
}
