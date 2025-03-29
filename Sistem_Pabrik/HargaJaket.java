package Sistem_Pabrik;

public class HargaJaket {
    //Harga jaket normal
    private static final int hargaJaketA = 100000;
    private static final int hargaJaketB = 125000;
    private static final int hargaJaketC = 175000;

    //Harga jaket setelah diskon
    private static final int diskonJaketA = 95000;
    private static final int diskonJaketB = 120000;
    private static final int diskonJaketC = 160000;

    //Method untuk menghitung harga yang digunakan berdasarkan jumlah jaket
    public int hitungHarga(int jumlahJaketA, int jumlahJaketB, int jumlahJaketC) {
        int totalHarga = 0;

        if (jumlahJaketA > 100) {
            totalHarga += jumlahJaketA * diskonJaketA;
        } else {
            totalHarga += jumlahJaketA * hargaJaketA;
        }

        if (jumlahJaketB > 100) {
            totalHarga += jumlahJaketB * diskonJaketB;
        } else {
            totalHarga += jumlahJaketB * hargaJaketB;
        }

        if (jumlahJaketC > 100) {
            totalHarga += jumlahJaketC * diskonJaketC;
        } else {
            totalHarga += jumlahJaketC * hargaJaketC;
        }
        
        return totalHarga;
    }
    
    //Method menghitung harga tiap jaket 
    public int hitungHargaA(int jumlahJaketA) {
        return (jumlahJaketA > 100) ? jumlahJaketA * diskonJaketA : jumlahJaketA * hargaJaketA;
    }

    public int hitungHargaB(int jumlahJaketB) {
        return (jumlahJaketB > 100) ? jumlahJaketB * diskonJaketB : jumlahJaketB * hargaJaketB;
    }

    public int hitungHargaC(int jumlahJaketC) {
        return (jumlahJaketC > 100) ? jumlahJaketC * diskonJaketC : jumlahJaketC * hargaJaketC;
    }
}
