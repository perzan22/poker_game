package org.perzan22.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    // class variables
    private final List<Player> players;

    // constructor
    public PlayerList() {
        players = new ArrayList<>();
    }

    // class logic

    // add player to player list (joining table)
    public void addPlayer(Player player) {
        players.add(player);
    }

    // remove player from player list (leaving table)
    public void removePlayer(Player player) {
        if (players.contains(player)) {
            players.remove(player);
        } else {
            throw new IllegalArgumentException("Player not found");
        }
    }

    // getter
    public List<Player> getPlayers() {
        return players;
    }

    // toString() method
    @Override
    public String toString() {
        return "Actual players in game: " + players;
    }
}
