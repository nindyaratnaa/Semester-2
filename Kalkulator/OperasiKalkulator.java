package Kalkulator;

public class OperasiKalkulator {

    //Method untuk melakukan penjumlahan
    public static double penjumlahan(double x, double y) {
        return x + y;  
    } 

    //Method untuk melakukan pengurangan
    public static double pengurangan(double x, double y) {
        return x - y; 
    }

    //Method untuk melakukan perkalian
    public double perkalian(double x, double y) {
        return x * y;  
    }

    //Method untuk melakukan pembagian 
    public double pembagian(double x, double y) {
        if (y != 0) {  //Memastikan penyebut tidak nol
            return x / y;  
        } else {
            System.out.println("Pembagian dengan nol tidak boleh!"); 
            return Double.NaN;  //Mengembalikan nilai NaN (Not a Number) jika pembagian dengan nol
        }
    }

    //Method untuk menyederhanakan pecahan (membentuk bilangan campuran jika perlu)
    public String menyederhanakan(int x, int y) {
        int gdc = gdc(x, y);  //Menyederhanakan pecahan dengan mencari GDC
        x /= gdc;  //Membagi pembilang dengan GDC
        y /= gdc;  //Membagi penyebut dengan GDC

        int pecahan = x / y;  //Mengambil bagian bulat dari hasil pembagian pembilang dengan penyebut
        int sisa = x % y;  //Mengambil sisa hasil pembagian, yang menjadi bagian pecahan

        if (sisa == 0) {
            return String.valueOf(pecahan);  //Jika tidak ada sisa, hanya mengembalikan bagian bulat
        } else {
            return pecahan + " " + sisa + "/" + y;  //Mengembalikan hasil dalam bentuk campuran (bilangan bulat dan pecahan)
        }        
    }

    //Method untuk mencari GCD atau FPB 
    private int gdc(int x, int y) {
        while (y != 0) {
            int temp = y;  //Menyimpan sementara nilai y
            y = x % y;  //Menyimpan sisa pembagian x dengan y sebagai y yang baru
            x = temp;  //Menyimpan nilai sementara sebagai x yang baru
        }
        return x;  
    }
}
