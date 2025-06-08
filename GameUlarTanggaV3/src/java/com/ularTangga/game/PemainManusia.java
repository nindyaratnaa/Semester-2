package com.ularTangga.game;

public class PemainManusia extends Pemain {

    //Konstruktor PemainManusia
    public PemainManusia(String nama) {
        super(nama);
    }

    //Overide abstract method dari Pemain
    @Override
    public boolean isBot() {
        return false;
    }

    @Override
    public int lemparDadu() {
        return (int)(Math.random() * 6) + 1;
    }
}