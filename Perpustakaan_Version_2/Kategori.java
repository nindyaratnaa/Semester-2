package Perpustakaan_Version_2;

public class Kategori {
    private String nama;
    private Buku[] listBuku;

    public Kategori(String nama, Buku[] listBuku) {
        this.nama = nama;
        this.listBuku = listBuku;
    }

    public String getNama() {
        return nama;
    }

    public Buku[] getListBuku() {
        return listBuku;
    }
}
