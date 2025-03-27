/* Anda dan tim anda mendapat sebuah proyek untuk merancang sistem transaksi pada
sebuah swalayan Tiny. Anda ditugasi oleh tim untuk membuat programnya berdasarkan
hasil analisis tim anda :
1. Informasi akun seorang pelanggan (saldo, nomor pelanggan, nama) tidak bias
   diubah oleh pelanggan secara langsung.
2. Nomor pelanggan terdiri dari 10 digit, dimana 2 digit awal adalah jenis rekening
   o 38 : Pelanggan jenis silver; setiap pembelian diatas 1 jt maka mendapat
     cashback sebesar 5%
   o 56 : Pelanggan jenis gold; setiap pembelian diatas 1 jt maka mendapat
     cashback sebesar 7%, selain itu cashback 2% (cashback kembali ke saldo)
   o 74 : Pelanggan jenis platinum; setiap pembelian diatas 1 jt maka
     mendapat cashback sebesar 10%, selain itu cashback 5% (cashback
     kembali ke saldo)
3. Pelanggan harus memiliki saldo minimal Rp10.000, jika saldo pasca transaksi kurang
   dari batas minimal tadi, maka transaksi pembelian dianggap gagal
4. Buatlah sistem transaksi swalayan ini terbatas pada pembelian dan top up saja dan
   menggunakan PIN dan nomor pelanggan sebagai syarat transaksi pembelian atau top up.
5. Apabila pelanggan melakukan 3x kesalahan dalam autentifikasi, maka akun
   pelanggan akan defreeze / diblokir sehingga tidak bisa digunakan lagi. */


package Sistem_Swalayan;

import java.util.Scanner;

public class MainSwalayan {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.print("Apakah sudah memiliki member (y/n)? ");
      String cekMember = input.nextLine().toLowerCase();  //Merubah ke huruf kecil semua mencegah salah input dll

      Pelanggan pelanggan = null;

      if (cekMember.equals("y")) {
         //Verifikasi member lama
         System.out.print("Masukkan ID: ");
         String ID = input.nextLine();
         System.out.print("Masukkan PIN: ");
         String pin = input.nextLine();

         //Mencocokkan data pelanggan dengan yang ada di database
         pelanggan = dataPelanggan.verifikasiMember(ID, pin);

         if (pelanggan == null) {
            System.out.println("Nama atau PIN salah! Tidak dapat melanjutkan.");
            input.close();
            return; //Keluar jika verifikasi gagal
         } else {
            System.out.println("Member lama berhasil masuk.");
         }
      } else {
         //Jika member baru, buat pelanggan baru
         System.out.print("Masukkan nomor pelanggan 10 digit (38/56/74): ");
         String nomorPelanggan = input.nextLine();
         System.out.print("Masukkan nama pelanggan: ");
         String namaPelanggan = input.nextLine();
         System.out.print("Masukkan PIN: ");
         String pin = input.nextLine();

         //Membuat member baru
         pelanggan = new Pelanggan(nomorPelanggan, namaPelanggan, 0, pin);
         System.out.println("Member baru berhasil dibuat!");

         //Menyimpan pelanggan baru ke dalam database
         dataPelanggan.memberBaru(pelanggan);
      }

      //Membuat objek transaksi untuk pelanggan yang berhasil diverifikasi
      Transaksi transaksi = new Transaksi(pelanggan);

      //Pilih transaksi
      while (true) {
         System.out.println("\n==================================");
         System.out.println("Pilih Transaksi:");
         System.out.println("1. Pembelian Barang");
         System.out.println("2. Top Up Saldo");
         System.out.println("3. Cek Saldo");
         System.out.println("4. Keluar");
         System.out.print("Masukkan pilihan (1/2/3/4): ");
         int pilihan = -1;

         //Pengecekan untuk input transaksi yang valid
         try {
            pilihan = input.nextInt();  //Memilih transaksi.
         } catch (Exception e) {
            System.out.println("Input tidak valid. Silakan pilih angka 1, 2, 3, atau 4.");
            input.nextLine();  // ersihkan input yang tidak valid (newline atau karakter lainnya).
            continue;  //Lanjutkan ke loop selanjutnya.
         }

         input.nextLine();  //Membersihkan newline yang tersisa

         //Proses transaksi berdasarkan pilihan
         if (pilihan == 1) {
            //Pembelian barang
            System.out.print("Masukkan PIN untuk Autentikasi: ");
            String pin = input.nextLine();
            transaksi.lakukanPembelian(pin);
         } else if (pilihan == 2) {
            //Top up saldo
            System.out.print("Masukkan PIN untuk Autentikasi: ");
            String pin = input.nextLine();
            System.out.print("Masukkan jumlah Top Up: Rp ");
            double topUp = input.nextDouble();
            transaksi.lakukanTopUp(topUp, pin);
         } else if (pilihan == 3) {
            //Cek saldo
            System.out.print("Masukkan PIN untuk Autentikasi: ");
            String pin = input.nextLine();
            transaksi.cekSaldo(pin);
         } else if (pilihan == 4) {
            System.out.println("Terimakasih telah bertransaksi!");
            break;  //Keluar dari loop jika memilih keluar
         } else {
            System.out.println("Pilihan tidak valid. Silakan pilih angka 1, 2, 3, atau 4.");
         }
      }
      input.close();
   }
}
