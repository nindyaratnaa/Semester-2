package com.ularTangga.game;

public class PemainBot extends Pemain {
    private int level;

    //Konsttuktor PemainBot
    public PemainBot(String nama, int level) {
        super(nama);
        this.level = level;
    }

    //Override abstract method dari Pemain
    @Override
    public boolean isBot() {
        return true;
    }

    @Override
    public int lemparDadu() {
        if (level == 1) {
            return (int)(Math.random() * 6) + 1;
        } else if (level == 2) {
            return (int)(Math.random() * 4) + 3; // 3–6 saja
        } else {
            return 6; // Cheating level 
        }
    }
}