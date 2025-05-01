/* Perusahaan NV. Meneer memiliki koperasi karyawan yang memungkinkan karyawannya berbelanja 
di koperasi tersebut. Tentunya, karyawan tersebut bisa membayar belanjaanya tersebut di akhir 
bulan melalui pemotongan gaji. Ada 2 kelas yang terlibat disini, Invoice dan Employee. Kedua 
class tadi mengimplementasikan interface Payable yang mana ia hanya memiliki satu method yang 
harus diimplementasikan di kedua class, yaitu getPayableAmount(). Program harus bisa mengolah 
gaji karyawan di akhir bulan beserta invoice belanjaan karyawan yang nantinya gaji karyawan 
perbulannya dikurang total harga belanjaanya secara polimorfis. Tampilkan informasi dari karyawan 
tersebut beserta total gaji setelah dipotong hutang belanjaan di koperasi dan tampilkan pula 
detail belanjaanya secara polimorfis pula.
1. Attribut dari Invoice:
    String productName, Integer quantity, Integer pricePerItem
2. Attribut dari Employee:
    Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices */

package PerusahaanNV;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Input data karyawan
        System.out.print("Masukkan nomor registrasi: ");
        int nomerReg = input.nextInt();
        input.nextLine(); //Membersihkan newline

        System.out.print("Masukkan nama: ");
        String name = input.nextLine();

        System.out.print("Masukkan gaji perbulan: ");
        int salary = input.nextInt();

        //Input jumlah item belanja
        System.out.print("Masukkan banyak barang yang dibeli: ");
        int itemCount = input.nextInt();
        input.nextLine(); //Membersihkan newline

        //Membuat array untuk menyimpan invoice belanjaan
        Invoice[] invoices = new Invoice[itemCount];
        
        //Input data tiap barang
        for (int i = 0; i < itemCount; i++) {
            System.out.println();
            System.out.print("Barang ke-" + (i + 1));
            System.out.print("\nNama barang: ");
            String productName = input.nextLine();

            System.out.print("Jumlah beli: ");         
            int quantity = input.nextInt();

            System.out.print("Harga per item: ");
            int price = input.nextInt();
            input.nextLine(); //Membersihkan newline

            //Simpan ke array invoice
            invoices[i] = new Invoice(productName, quantity, price);
        }

        //Buat objek employee berdasarkan data yang diinput
        Employee employee = new Employee(nomerReg, name, salary, invoices);

        System.out.println();
        
        //Tampilkan informasi struk karyawan (toString sudah diatur)
        System.out.println(employee);

        input.close();
    }
}