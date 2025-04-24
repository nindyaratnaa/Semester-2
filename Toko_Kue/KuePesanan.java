package Toko_Kue;

public class KuePesanan extends Kue {
    private double berat;
    
    //Konstruktor pesanan
    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getberat() {
        return berat;
    }

    //Untuk hitung harga overide dri kue
    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    //output untuk pesanan overide dri kue
    @Override
    public String toString() {
        return "------ Kue Pesanan ------\n" + 
                super.toString() + 
                String.format("\nBerat      : %.1f", berat) + " gram";
    }
}
