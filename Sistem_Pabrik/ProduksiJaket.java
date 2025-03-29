/* 1. Buatlah program dengan menggunakan class untuk menghitung penjumalahan, pengurangan, 
  perkalian dan pembagian. Method penjumlahan dan pengurangan menggunakan static method 
  sedangkan sisanya menggunakan method non static. Tambahkan method bertipe non static 
  bernama Sederhana untuk menyederhanakan sebuah pecahan.
2. CV. Labkomdas adalah perusahaan yang bergerak di bidang produksi jaket, terdapat 3
  tipe jaket yang memiliki harga yang tetap (final) yaitu jaket dengan bahan A, B dan C 
  yang masing-masing memiliki harga persatuannya adalah Rp 100.000, Rp 125.000, Rp 175.000. 
  Karena produksi jaket tersebut terbilang masih baru pihak perusahaan melakukan strategi 
  dengan memberi diskon harga bila pembeli membeli banyak jenis jaket, diskon di berikan apabila :
3. Jaket A di beli sebanyak lebih dari 100 buah maka harga menjadi 95.000 per biji
    a. Jaket A di beli sebanyak lebih dari 100 buah maka harga menjadi 95.000 per biji
    b. Jaket B di beli sebanyak lebih dari 100 buah maka harga menjadi 120.000 per biji
    c. Jaket C di beli sebanyak lebih dari 100 buah maka harga menjadi 160.000 per biji
Buat program dari kasus diatas dengan materi yang sudah di ajarkan oleh asisten
Nb : nilai final adalah harga Jaket A, B dan C. */

package Sistem_Pabrik;

import java.util.Scanner;

public class ProduksiJaket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HargaJaket hargaJaket = new HargaJaket();

        //Input jumlah jaket
        System.out.print("Masukkan jumlah jaket A yang ingin dibeli: ");
        int jumlahJaketA = input.nextInt();

        System.out.print("Mauskkan jumlah jaket B yang ingin dibeli: ");
        int jumlahJaketB = input.nextInt();

        System.out.print("Masukkan jumlah jaket C yang ingin dibeli: ");
        int jumlahJaketC = input.nextInt();

        input.close();

        //Menyimpan nilai total harga
        int totalHarga = hargaJaket.hitungHarga(jumlahJaketA, jumlahJaketB, jumlahJaketC);

        //Menyimpan nilai harga masing masing jaket
        int hargaJaketA = hargaJaket.hitungHargaA(jumlahJaketA);
        int hargaJaketB = hargaJaket.hitungHargaB(jumlahJaketB);
        int hargaJaketC = hargaJaket.hitungHargaC(jumlahJaketC);
        
        //Output
        System.out.printf("\nHarga jaket A dengan jumlah %d adalah Rp %,.2f", jumlahJaketA, (double)hargaJaketA);
        System.out.printf("\nHarga jaket B dengan jumlah %d adalah Rp %,.2f", jumlahJaketB, (double)hargaJaketB);
        System.out.printf("\nHarga jaket C dengan jumlah %d adalah Rp %,.2f", jumlahJaketC, (double)hargaJaketC);
        System.out.print("\n-----------------------------------------------------------");
        System.out.printf("\nTotal harga untuk seluruh jaket adalah Rp %,.2f", (double)totalHarga);
    }
}