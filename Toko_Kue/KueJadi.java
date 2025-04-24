package Toko_Kue;

public class KueJadi extends Kue{
    private double jumlah;
    
    //Kontruktor kue jadi
    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }
    
    public double getJumlah() {
        return jumlah;
    }
    
    //Overide dri kue u/ hitung harga
    @Override
    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }

    //Overide dri kue u/ output
    @Override
    public String toString() {
        return "------- Kue Jadi -------\n" + 
                super.toString() + 
               "\nJumlah     : " + jumlah;
    }
}
