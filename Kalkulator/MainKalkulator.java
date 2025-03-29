/* 1. Buatlah program dengan menggunakan class untuk menghitung penjumalahan, pengurangan, perkalian dan pembagian. 
      Method penjumlahan dan pengurangan menggunakan static method sedangkan sisanya menggunakan method non static. 
      Tambahkan method bertipe non static bernama Sederhana untuk menyederhanakan sebuah pecahan. */

package Kalkulator;

import java.util.Scanner;

public class MainKalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Membuat objek kalkulator untuk melakukan operasi matematika
        OperasiKalkulator kalkulator = new OperasiKalkulator();

        //Program akan terus berjalan hingga pilihan 6 (keluar) dipilih
        while (true) {
            //Menampilkan pilihan operasi matematika
            System.out.println("\nPilih operasi matematika");
            System.out.println(" 1. Penjumlahan");
            System.out.println(" 2. Pengurangan");
            System.out.println(" 3. Perkalian");
            System.out.println(" 4. Pembagian");
            System.out.println(" 5. Menyederhanakan pecahan");
            System.out.println(" 6. Selesai");
            System.out.print("Masukkan pilihan (1-6): ");
            int pilihan = input.nextInt();  //Membaca input 

            //Jika pengguna memilih untuk keluar (pilihan 6)
            if (pilihan == 6) {
                System.out.println("Terimakasih! Program selesai.");
                break;  //Keluar dari loop dan program selesai
            }

            double x, y;
            int p, q;

            //Menggunakan switch-case untuk menangani operasi yang dipilih
            switch (pilihan) {
                case 1:  //Penjumlahan
                    System.out.print("Masukkan angka pertama untuk penjumlahan: ");
                    x = input.nextDouble(); 
                    System.out.print("Masukkan angka kedua untuk penjumlahan: ");
                    y = input.nextDouble(); 
                    System.out.println("Hasil penjumlahan: " + kalkulator.penjumlahan(x, y));  // Menampilkan hasil
                    break;
            
                case 2:  //Pengurangan
                    System.out.print("Masukkan angka pertama untuk pengurangan: ");
                    x = input.nextDouble(); 
                    System.out.print("Masukkan angka kedua untuk pengurangan: ");
                    y = input.nextDouble(); 
                    System.out.println("Hasil pengurangan: " + kalkulator.pengurangan(x, y));  // Menampilkan hasil 
                    break;
                
                case 3:  //Perkalian
                    System.out.print("Masukkan angka pertama untuk perkalian: ");
                    x = input.nextDouble(); 
                    System.out.print("Masukkan angka kedua untuk perkalian: ");
                    y = input.nextDouble(); 
                    System.out.println("Hasil perkalian: " + kalkulator.perkalian(x, y));  // Menampilkan hasil 
                    break;

                case 4:  //Pembagian
                    System.out.print("Masukkan angka pertama untuk pembagian: ");
                    x = input.nextDouble(); 
                    System.out.print("Masukkan angka kedua untuk pembagian: ");
                    y = input.nextDouble(); 
                    System.out.println("Hasil pembagian: " + kalkulator.pembagian(x, y));  //Menampilkan hasil 
                    break;
                     
                case 5:  //Menyederhanakan pecahan
                    System.out.print("Masukkan pembilang pecahan: ");
                    p = input.nextInt(); 
                    System.out.print("Masukkan penyebut pecahan: ");
                    q = input.nextInt();  
                    System.out.println("Hasil penyederhanaan pecahan: " + kalkulator.menyederhanakan(p, q));  //Menampilkan hasil
                    break;
                
                default:  //Jika pilihan tidak valid
                    System.out.println("Pilihan tidak valid!"); 
                    break;
            }
        }
        input.close();  
    }    
}
