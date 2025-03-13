package Perpustakaan_Version_2;

import java.util.Scanner;

public class Buku {
    private String judul;
    private Penulis[] penulis;
    private String kategori;
    private String sinopsis;
    private int tahun;

    public Buku(String judul, Penulis[] penulis, String kategori, String sinopsis, int tahun) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.tahun = tahun;
    }

    public String getJudul() {
        return judul;
    }

    public Penulis[] getPenulis() {
        return penulis;
    }

    public String getKategori() {
        return kategori;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getTahun() {
        return tahun;
    }

    private static void hitungJumlahKata(String sinopsis) {
        String[] kata = sinopsis.split("\\s+"); //Memisahkan berdasar spasi (termasuk lebih dari 1 spasi)

        System.out.println("Jumlah kata dalam sinopsis: " + kata.length);
    }

    public static void tampilkanSinopsis(Kategori kategori, Scanner input) {
        System.out.print("Masukkan nomor buku untuk sinopsis yang diinginkan (1-" + kategori.getListBuku().length + "): ");
        int pilihan = input.nextInt();

        if (pilihan > 0 && pilihan <= kategori.getListBuku().length) {
            Buku buku = kategori.getListBuku()[pilihan-1]; //Di -1 karena index array dimulai dari 0
            System.out.println("\nSinopsis Buku \"" + buku.getJudul() + "\": ");
            System.out.println(buku.getSinopsis());
            hitungJumlahKata(buku.getSinopsis());
        } else {
            System.out.println("Input tidak valid.");
        }
    }

    public static void perbandinganBuku (Kategori kategori1, Kategori kategori2, String judulbuku1, String judulbuku2) {
        Buku buku1 = null;
        Buku buku2 = null;

        for (Buku buku : kategori1.getListBuku()) {
            if (buku.getJudul().equalsIgnoreCase(judulbuku1)) {
                buku1 = buku;
            }
        }

        for (Buku buku : kategori2.getListBuku()) {
            if (buku.getJudul().equalsIgnoreCase(judulbuku2)) {
                buku2 = buku;
            }
        }

        if (buku1 != null && buku2 != null) {
            int skorKesamaan = hitungKesamaan(buku1, buku2); 
            System.out.print("\nPerbandingan buku: ");
            System.out.printf("\n%-20s\nJudul: %s\nPenulis: %s\nTahun: %d\nSinopsis: %s", "Buku 1", buku1.getJudul(), buku1.getPenulis()[0].getNama(), buku1.getTahun(), buku1.getSinopsis());
            System.out.printf("\n\n%-20s\nJudul: %s\nPenulis: %s\nTahun: %d\nSinopsis: %s", "Buku 2", buku2.getJudul(), buku2.getPenulis()[0].getNama(), buku2.getTahun(), buku2.getSinopsis());
        
            System.out.println("\n\nSkor kesamaan " + skorKesamaan);
        } else {
            if (buku1 == null) 
                System.out.println("Buku 1 dengan judul \"" + judulbuku1 + "\" tidak valid." );
            if (buku2 == null)
                System.out.println("Buku 2 dengan judul \"" + judulbuku2 + "\" tidak valid." );

        }
    }

    public static int hitungKesamaan(Buku buku1, Buku buku2) {
        int skor = 0;

        //Bandingkan judul
        if (buku1.getJudul().equalsIgnoreCase(buku2.getJudul())) {
            skor += 25;
        }
        //Bandingkan penulis
        if (buku1.getPenulis()[0].getNama().equalsIgnoreCase(buku2.getPenulis()[0].getNama())) {
            skor += 25;
        }
        //Bandingin tahun
        if (buku1.getTahun() == buku2.getTahun()) {
            skor += 25;
        }
        //Bandingin sinopsis
        int skorSinopsis = perbandinganSinopsis(buku1.getSinopsis(), buku2.getSinopsis());
        skor += skorSinopsis;

        return skor;
    }

    private static int perbandinganSinopsis (String sinopsis1, String sinopsis2) {
        String[] kata1 = sinopsis1.split("\\s+"); 
        String[] kata2 = sinopsis2.split("\\s+"); 

        int totalKata = kata1.length + kata2.length;

        if (totalKata == 0) {
            return 0;
        }

        int kataSama = 0;
        for (String k1 : kata1) {
            for (String k2 : kata2) {
                kataSama++;
                break;
            }
        }

        double skor = (double) (kataSama*2) / totalKata * 25;
        return (int) skor;
    }


    public Buku copy() {
        return new Buku(this.judul, this.penulis, this.kategori, this.sinopsis, this.tahun);
    }
    
}
