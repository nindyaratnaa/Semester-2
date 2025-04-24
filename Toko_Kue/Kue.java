package Toko_Kue;

public abstract class Kue {
    private String nama;
    private double harga;

    //Konstruktor Kue
    public Kue (String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public double getHarga() { //Kalau get harga ga ada ga bisa di pakai ke yg lain
        return harga;
    }

    //Temp method hitungHarga untuk subclass
    public abstract double hitungHarga();

    //Output kue untuk nnt di lengkapi subclassnya
    public String toString() {
        return "Nama Kue   : " + nama + 
               String.format("\nHarga Kue  : Rp %,.2f", harga);
    }
}
