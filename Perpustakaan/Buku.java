package Perpustakaan;

public class Buku {
    private String judul;
    private Penulis[] penulis;
    private String kategori;

    public Buku(String judul, Penulis[] penulis, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
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
}
