/* Susunlah program sesuai studi kasus di bawah ini:
1. Manusia.java
Kelas manusia merupakan kelas induk dengan definisi sebagai berikut:
    − nama : String
    − jenisKelamin : boolean (true : laki-laki, false : perempuan)
    − nik : String
    − menikah : boolean
    + setter, getter
    + getTunjangan() : double
    + getPendapatan() : double
    + toString() : String
(Keterangan)
    o Tunjangan untuk yang telah menikah adalah apabila laki-laki akan mendapat $25 sedangkan perempuan mendapat $20.
    o Tunjangan untuk yang belum menikah adalah $15 .
    o toString() menampilkan nama, nik, jenis kelamin, dan jumlah pendapatan.

2. MahasiswaFILKOM.java
Kelas mahasiswa merupakan kelas turunan dari Manusia dengan definisi sebagai berikut:
    − nim : String
    − ipk : double
    + setter, getter
    + getStatus() : String
    + getBeasiswa() : double
    + toString() : String
(Keterangan)
    o Beasiswa untuk ipk 3.0 – 3.5 mendapat $50 dan untuk 3.5 – 4 mendapat $75
    o Status untuk mendapatkan angkatan dan prodi (menurut kaidah FILKOM UB) 1651506XXXXXXX
    o Digit ke 1-2 adalah angkatan
    o Digit ke 7 adalah prodi
        ▪ 2 Teknik Informatika
        ▪ 3 Teknik Komputer
        ▪ 4 Sistem Informasi
        ▪ 6 Pendidikan Teknologi Informasi
        ▪ 7 Teknologi Informasi
Dengan pengembalian dengan format : prodi angkatan, contoh : Sistem Informasi, 2017
    o toString() menampilkan atribut induk + nim, ipk, dan status.

3. Pekerja.java
Kelas Pekerja merupakan kelas turunan dari Manusia dengan definisi sebagai berikut:
    − gaji : double
    − tahunMasuk : LocalDate
    − jumlahAnak : int
    + setter, getter
    + getBonus() : double
    + getGaji() : double
    + toString() : String
(Keterangan)
    o Bonus didapatkan oleh pegawai sesuai lama bekerja :
    o Jika lama bekerja 0 – 5 tahun, maka bonus sebesar 5% dari gaji
    o Jika lama bekerja 5 – 10 tahun, maka bonus sebesar 10% dari gaji
    o Jika lebih dari 10 tahun, maka bonus sebesar 15% dari gaji
    o Tunjangan ditambah apabila memiliki anak, yaitu $20 per anak.
    o toString() menampilkan atribut induk + tahun masuk, jumlah anak, dan gaji.

4. Manager.java
Kelas Manager merupakan kelas turunan dari Pekerja dengan definisi sebagai berikut:
    − departemen : String
    + setter, getter
(Keterangan)
    o Tunjangan ditambah sebesar 10% dari gaji.
    o toString() menampilkan atribut induk + departemen.

Dari semua kelas yang telah dibuat, buatlah testcase (mencetak objek / toString()) untuk kasus berikut :
1. Manusia
    a. Laki-laki telah menikah.
    b. Perempuan telah menikah.
    c. Belum menikah.
2. MahasiswaFilkom (sesuai status Anda)
    a. Ipk < 3
    b. Ipk 3 – 3.5
    c. Ipk 3.5 – 4
3. Pekerja
    a. Lama bekerja 2 tahun, anak 2
    b. Lama bekerja 9 tahun
    c. Lama bekerja 20 tahun, anak 10
4. Manager, lama bekerja 15 tahun dengan gaji $7500 */


package Hidup_Mahasiswa_Pekerja;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) { //Opsi inputan untuk objek
            System.out.println();
            System.out.println("Pilih objek apa yang ingin anda buat!");
            System.out.println("1. Manusia");
            System.out.println("2. Mahasiswa FILKOM");
            System.out.println("3. Pekerja");
            System.out.println("4. Manager");
            System.out.println("5. Selesai");
            System.out.print("Masukkan pilihan: ");
            int pilihan = input.nextInt(); //Input pilihan
            input.nextLine();

            switch (pilihan) {
                case 1: //Jika memilih manusia
                    System.out.print("Nama: ");
                    String namaManusia = input.nextLine();
                    System.out.print("NIK: ");
                    String nik = input.nextLine();
                    System.out.print("Jenis kelamin (true = laki)/(false = wanita): ");
                    boolean jenisKelamin = input.nextBoolean();
                    System.out.print("Sudah menikah? (true/false): ");
                    boolean menikah = input.nextBoolean();
                    System.out.println();

                    Manusia orang = new Manusia(namaManusia, nik, jenisKelamin, menikah); 
                    System.out.println(orang); //Output objek orang
                    break;
                
                case 2: //Untuk pilihan Mahasiswa FILKOM
                    System.out.print("NIM: ");
                    String nim = input.nextLine();
                    System.out.print("IPK: ");
                    double ipk = input.nextDouble();
                    input.nextLine(); //Hapus next line
                    System.out.print("Nama: ");
                    String namaMahasiswa = input.nextLine();
                    System.out.print("NIK: ");
                    String nikMahasiswa = input.nextLine();
                    System.out.print("Jenis kelamin (true = laki)/(false = wanita): ");
                    boolean jenisKelaminMahasiswa = input.nextBoolean();
                    System.out.print("Sudah menikah? (true/false): ");
                    boolean menikahMahasiswa = input.nextBoolean();
                    System.out.println();

                    MahasiswaFILKOM orangFilkom = new MahasiswaFILKOM(nim, ipk, namaMahasiswa, nikMahasiswa, jenisKelaminMahasiswa, menikahMahasiswa);
                    System.out.println(orangFilkom); //Outpun objek orangFILKOM
                    break;

                case 3: 
                    System.out.print("Gaji: ");
                    double gaji = input.nextDouble();
                    System.out.print("Tahun masuk (contoh: 2006): ");
                    int tahunMasuk = input.nextInt();
                    System.out.print("Bulan masuk (contoh: 1): ");
                    int bulanMasuk = input.nextInt();
                    System.out.print("Tanggal masuk (contoh: 1): ");
                    int tanggalMasuk = input.nextInt();
                    System.out.print("Jumlah anak: ");
                    int jumlahAnak = input.nextInt();
                    input.nextLine(); //Hapus next line
                    System.out.print("Nama: ");
                    String namaOrangKerja = input.nextLine();
                    System.out.print("NIK: ");
                    String nikOrangKerja = input.nextLine();
                    System.out.print("Jenis kelamin (true = laki)/(false = wanita): ");
                    boolean jenisKelaminPekerja = input.nextBoolean();
                    System.out.print("Sudah menikah? (true/false): ");
                    boolean menikahPekerja = input.nextBoolean();
                    System.out.println(); 

                    Pekerja orangKerja = new Pekerja(gaji, tahunMasuk, bulanMasuk, tanggalMasuk, jumlahAnak, namaOrangKerja, nikOrangKerja, jenisKelaminPekerja, menikahPekerja);
                    System.out.println(orangKerja); //Outpun objek orang kerja
                    break;

                case 4:
                    System.out.print("Departemen: ");
                    String departemen = input.nextLine();
                    System.out.print("Gaji: ");
                    double gajiManager = input.nextDouble();
                    System.out.print("Tahun masuk (contoh: 2006) ");
                    int tahunMasukManager = input.nextInt();
                    System.out.print("Bulan masuk (contoh: 1) ");
                    int bulanMasukManager = input.nextInt();
                    System.out.print("Tanggal masuk (contoh: 1) ");
                    int tanggalMasukManager = input.nextInt();
                    System.out.print("Jumlah anak: ");
                    int jumlahAnakManager = input.nextInt();
                    input.nextLine(); //Hapus next line
                    System.out.print("Nama: ");
                    String namaManager = input.nextLine();
                    System.out.print("NIK: ");
                    String NIKManager = input.nextLine();
                    System.out.print("Jenis kelamin (true = laki)/(false = wanita): ");
                    boolean jenisKelaminManager = input.nextBoolean();
                    System.out.print("Sudah menikah? (true/false): ");
                    boolean menikahManager = input.nextBoolean();
                    System.out.println();

                    Manager orangKerjaManager = new Manager(departemen, gajiManager, tahunMasukManager, bulanMasukManager, tanggalMasukManager, jumlahAnakManager, namaManager, NIKManager, jenisKelaminManager, menikahManager);
                    System.out.println(orangKerjaManager); //Outpun objek orang kerja manajer
                    break;

                case 5: 
                    System.out.println("Program telah selesai dan keluar");
                    input.close(); //Menutup input
                    return; //Keluar program

                default: //Setingan default
                    System.out.println("Coba lagi, pilihan tidak valid"); 
                    break;
            }
        }
    }
}
