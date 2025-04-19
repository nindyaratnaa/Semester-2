package Hidup_Mahasiswa_Pekerja;

import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Pilih objek apa yang ingin anda buat!");
            System.out.println("1. Manusia");
            System.out.println("2. Mahasiswa FILKOM");
            System.out.println("3. Pekerja");
            System.out.println("4. Manager");
            System.out.println("5. Selesai");
            System.out.print("Masukkan pilihan: ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
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
                    System.out.println(orang);
                    break;
                
                case 2:
                    System.out.print("NIM: ");
                    String nim = input.nextLine();
                    System.out.print("IPK: ");
                    double ipk = input.nextDouble();
                    input.nextLine();
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
                    System.out.println(orangFilkom);
                    break;

                case 3: 
                    System.out.print("Gaji: ");
                    double gaji = input.nextDouble();
                    System.out.print("Tahun masuk (contoh: 2006) ");
                    int tahunMasuk = input.nextInt();
                    System.out.print("Bulan masuk (contoh: 1) ");
                    int bulanMasuk = input.nextInt();
                    System.out.print("Tanggal masuk (contoh: 1) ");
                    int tanggalMasuk = input.nextInt();
                    System.out.print("Jumlah anak: ");
                    int jumlahAnak = input.nextInt();
                    input.nextLine();
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
                    System.out.println(orangKerja);
                    break;

                case 4:
                    System.out.print("Departemen: ");
                    String departemen = input.nextLine();
                    System.out.print("Gaji: ");
                    double gajiManager = input.nextDouble();
                    System.out.print("Tahun masuk (contoh: 2006) ");
                    int tahunMasukManager = input.nextInt();
                    System.out.print("Bulan masuk (contoh: 01) ");
                    int bulanMasukManager = input.nextInt();
                    System.out.print("Tanggal masuk (contoh: 01) ");
                    int tanggalMasukManager = input.nextInt();
                    System.out.print("Jumlah anak: ");
                    int jumlahAnakManager = input.nextInt();
                    input.nextLine();
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
                    System.out.println(orangKerjaManager);
                    break;

                case 5: 
                    System.out.println("Program telah selesai dan keluar");
                    input.close();
                    return;

                default:
                    System.out.println("Coba lagi, pilihan tidak valid");
                    break;
            }
        }
    }
}
