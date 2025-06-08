package com.ularTangga.game;

public abstract class Pemain {
    protected String nama;
    protected int posisi;

    //Konstruktor Pemain
    public Pemain(String nama) {
        this.nama = nama;
        this.posisi = 0;
    }

    //Getter dan Setter
    public String getNama() {
        return nama;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }

    public void reset() {
        this.posisi = 0;
    }

    // Abstract method
    public abstract boolean isBot();

    public abstract int lemparDadu();
}
