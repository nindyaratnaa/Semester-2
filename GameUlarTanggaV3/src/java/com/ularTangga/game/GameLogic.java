package com.ularTangga.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameLogic {
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    private Pemain pemain1;
    private Pemain pemain2;
    private int currentPlayer;

    private Random random;

    public GameLogic() {
        random = new Random();
        reset();
    }

    public void reset() {

        // Data ular pada board
        snakes = new HashMap<>();
        snakes.put(16, 6);
        snakes.put(46, 25);
        snakes.put(49, 11);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(74, 53);
        snakes.put(89, 68);
        snakes.put(92, 88);
        snakes.put(95, 75);
        snakes.put(99, 80);

        // Data tangga pada board
        ladders = new HashMap<>();
        ladders.put(2, 38);
        ladders.put(7, 14);
        ladders.put(8, 31);
        ladders.put(15, 26);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 55);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(78, 98);
        ladders.put(87, 94);

        // Reset posisi pemain jika sudah diset
        if (pemain1 != null) pemain1.reset();
        if (pemain2 != null) pemain2.reset();

        currentPlayer = 1;
    }

    public void setPemain(Pemain p1, Pemain p2) {
        this.pemain1 = p1;
        this.pemain2 = p2;
    }

    public int rollDice() {
        return getCurrentPemain().lemparDadu();
    }

    public void moveCurrentPlayer(int steps) {
        Pemain pemain = (currentPlayer == 1) ? pemain1 : pemain2;
        int pos = pemain.getPosisi();
        pos += steps;

        if (pos > 100) {
            pos = 100 - (pos - 100); // Kembali balik kalau lebih dari 100
        }

        if (ladders.containsKey(pos)) {
            pos = ladders.get(pos);
        }

        if (snakes.containsKey(pos)) {
            pos = snakes.get(pos);
        }

        pemain.setPosisi(pos);
    }

    public void switchTurn() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    public boolean isCurrentPlayerWin() {
        return getCurrentPemain().getPosisi() == 100;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public Pemain getPemain1() {
        return pemain1;
    }

    public Pemain getPemain2() {
        return pemain2;
    }

    public Pemain getCurrentPemain() {
        return (currentPlayer == 1) ? pemain1 : pemain2;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }


    public boolean isCurrentPlayerBot() {
        return getCurrentPemain().isBot();
    }

    public int playBotTurn() {
        if (!isCurrentPlayerBot()) return -1;

        int dice = getCurrentPemain().lemparDadu();
        moveCurrentPlayer(dice);
        return dice;
    }

    public int getPlayer1Pos() {
        return (pemain1 != null) ? pemain1.getPosisi() : 0;
    }

    public int getPlayer2Pos() {
        return (pemain2 != null) ? pemain2.getPosisi() : 0;
    } 
}
