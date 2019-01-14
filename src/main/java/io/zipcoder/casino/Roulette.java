package io.zipcoder.casino;

public class Roulette {

    private RoulettePlayer player;

    public Roulette(Player player) {
        this.player = new RoulettePlayer(player);
    }
}
