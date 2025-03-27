package Sistem_Swalayan;

import java.util.ArrayList;
import java.util.Scanner;

class Transaksi {
    private Pelanggan pelanggan;
    private String[] daftarBarang = {"Kipas angin", "TV", "AC", "Sound", "Mesin cuci"}; //Daftar barang yang dijual
    private double[] daftarHarga = {500000, 999900, 800000, 750000, 1200000}; //Daftar harga barang
    private ArrayList<String> barangYangDibeli; //Menyimpan barang yang di beli
    private ArrayList<Integer> jumlahBarang; //Menyimpan jumlah barang yang dibeli

    public Transaksi(Pelanggan pelanggan) { 
        this.pelanggan = pelanggan;
        this.barangYangDibeli = new ArrayList<>();
        this.jumlahBarang = new ArrayList<>();
    }

    //Method untuk melakukan Pembelian Barang
    public void lakukanPembelian(String pinMasuk) { 
        if (pelanggan.isAkunDiblokir()) { //Melakukan cek apakah member memenuhi syarat yang ditetapkan
            System.out.println("Akun diblokir. Tidak dapat melakukan transaksi.");
            return;
        }

        //Verifikasi PIN
        if (!pelanggan.verifikasiPin(pinMasuk)) {
            System.out.println("PIN salah. Akun akan diblokir setelah 3 kesalahan.");
            return;
        }

        //Cek saldo minimal
        if (pelanggan.getSaldo() < 10000) {
            System.out.println("Saldo minimal harus Rp 10.000,00");
            return;
        }

        //Menampilkan daftar barang berbentuk tabel
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nDaftar Barang yang Tersedia:");
            System.out.printf("%-5s%-20s%-15s\n", "No", "Nama Barang", "Harga");
            System.out.println("--------------------------------------------");
            
            for (int i = 0; i < daftarBarang.length; i++) { //Melakukan sepanjang/sebanyak array daftar barang
                System.out.printf("%-5d%-20s%-15s\n", i + 1, daftarBarang[i], String.format("Rp %,.2f", daftarHarga[i]));
            }
            

            System.out.print("Masukkan nomor barang yang ingin dibeli (atau ketik 'selesai' untuk selesai): ");
            String pilihan = input.nextLine();
            if (pilihan.equalsIgnoreCase("selesai")) {
                break;  //Keluar dari loop jika selesai
            }

            int nomorBarang;
            try { //Jika nomer yang dimasukkan di luar dari yang ada 
                nomorBarang = Integer.parseInt(pilihan) - 1;
                if (nomorBarang < 0 || nomorBarang >= daftarBarang.length) {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                    continue;
                }
            } catch (NumberFormatException e) { 
                System.out.println("Masukkan nomor yang valid.");
                continue;
            }

            System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
            int jumlah;
            try {  //Untuk cek jumlah input
                jumlah = input.nextInt();
                if (jumlah <= 0) {
                    System.out.println("Jumlah barang tidak valid.");
                    input.nextLine(); //Clear invalid input
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Masukkan jumlah yang valid.");
                input.nextLine(); //Clear invalid input
                continue;
            }
            input.nextLine(); //Clear newline after nextInt()

            //Menyimpan inputan dalam array
            barangYangDibeli.add(daftarBarang[nomorBarang]); 
            jumlahBarang.add(jumlah);

            System.out.println("Barang berhasil ditambahkan: " + daftarBarang[nomorBarang] + " x " + jumlah + " buah.\n"); //Konfirmasi akhir inputan
        }

        //Menampilkan pembelian dan menghitung total harga
        double totalPembelian = hitungTotalPembelian();
        System.out.printf("\nTotal Pembelian: Rp %,.2f\n", totalPembelian);

        //Cek saldo cukup untuk pembelian
        if (pelanggan.getSaldo() < totalPembelian + 10000) {
            System.out.println("Saldo tidak cukup untuk transaksi.");
            return;
        }

        //Proses pembelian dan cashback
        double cashback = hitungCashback(totalPembelian);
        double totalBayar = totalPembelian - cashback;
        pelanggan.setSaldo(pelanggan.getSaldo() - totalBayar);

        System.out.printf("\nPembelian berhasil! Cashback: Rp %,.2f\n", cashback);
        System.out.printf("Total Pembayaran: Rp %,.2f\n", totalBayar);
        System.out.printf("Saldo sekarang: Rp %,.2f\n", pelanggan.getSaldo());
    }

    //Method untuk menghitung total pembelian
    private double hitungTotalPembelian() {
        double total = 0;
        for (int i = 0; i < barangYangDibeli.size(); i++) {
            int index = indexBarang(barangYangDibeli.get(i));
            total += daftarHarga[index] * jumlahBarang.get(i);
        }
        return total;
    }

    //Method untuk menghitung cashback
    private double hitungCashback(double jumlahPembelian) {
        String jenisRekening = pelanggan.getNomorPelanggan().substring(0, 2); //Mengambil 2 karakter awal
        double cashback = 0;

        if (jumlahPembelian > 1000000) { //Cek total pembelian
            if (jenisRekening.equals("38")) { //Silver
                cashback = 0.05 * jumlahPembelian;
            } else if (jenisRekening.equals("56")) { //Gold
                cashback = 0.07 * jumlahPembelian;
            } else if (jenisRekening.equals("74")) { //Platinum
                cashback = 0.10 * jumlahPembelian;
            }
        } else {
            if (jenisRekening.equals("38")) { //Silver
                cashback = 0;
            } else if (jenisRekening.equals("56")) { //Gold
                cashback = 0.02 * jumlahPembelian;
            } else if (jenisRekening.equals("74")) { //Platinum
                cashback = 0.05 * jumlahPembelian;
            }
        }

        //Update saldo pelanggan setelah cashback
        pelanggan.setSaldo(pelanggan.getSaldo() + cashback);
        return cashback;
    }

    //Method untuk mendapatkan index barang berdasarkan nama
    private int indexBarang(String namaBarang) {
        for (int i = 0; i < daftarBarang.length; i++) {
            if (daftarBarang[i].equals(namaBarang)) {
                return i;
            }
        }
        return -1;
    }

    //Method untuk melakukan top up saldo
    public void lakukanTopUp(double topUpAmount, String pinMasuk) {
        if (pelanggan.isAkunDiblokir()) {
            System.out.println("Akun diblokir. Tidak dapat melakukan transaksi.");
            return;
        }

        //Verifikasi PIN
        if (!pelanggan.verifikasiPin(pinMasuk)) {
            System.out.println("PIN salah. Akun akan diblokir setelah 3 kesalahan.");
            return;
        }

        //Proses top up saldo
        double saldoBaru = pelanggan.getSaldo() + topUpAmount;

        //Pastikan saldo minimal tidak kurang dari Rp10.000
        if (saldoBaru < 10000) {
            System.out.println("Saldo tidak cukup setelah top-up. Top-up gagal.");
            return;
        }

        //Lakukan top-up
        pelanggan.setSaldo(saldoBaru);
        System.out.printf("Top-up berhasil! Saldo baru: Rp %,.2f\n", pelanggan.getSaldo());
    }

    public void cekSaldo(String pinMasuk) {
        if (pelanggan.isAkunDiblokir()) {
            System.out.println("Akun diblokir. Tidak dapat melakukan transaksi.");
            return;
        }

        //Verifikasi PIN
        if (!pelanggan.verifikasiPin(pinMasuk)) {
            System.out.println("PIN salah. Akun akan diblokir setelah 3 kesalahan.");
            return;
        }

        //Menampilkan saldo
        System.out.printf("Saldo Anda: Rp %,.2f\n", pelanggan.getSaldo());
    }
}
