package Hidup_Mahasiswa_Pekerja;

import java.time.LocalDate;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(double gaji, int tahun, int bulan, int hari, int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super(nama, nik, jenisKelamin, menikah);
        this.gaji = gaji;
        this.tahunMasuk = LocalDate.of(tahun, bulan, hari);
        this.jumlahAnak = jumlahAnak;
    }

    //Getter setter
    public double getGaji() {
        return gaji;
    }
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }
    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
    public int getJumlahAnak() {
        return jumlahAnak;
    }
    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() { //untuk menhitung loyalitas berdasarkan tahun masuk
        int tahunKerja = LocalDate.now().getYear() - tahunMasuk.getYear(); //AAmbil tahun sistem - tahun input
        if (tahunKerja <= 5) { 
            return gaji * 0.05;
        } else if (tahunKerja <=10) {
            return gaji * 0.10;
        } else {
            return gaji * 0.15;
        }
    }

    public double getPendapatan() { //Untuk total pendapatan pekerja
        return super.getTunjangan() + getGaji() + getBonus() + (jumlahAnak * 20);
    }

    @Override //Output pekerja
    public String toString() {
        return "Nama : " + getNama() +
                "\nNIK : " + getNik() +
                "\nJenis Kelamin : " + (isJenisKelamin() ? "Laki-laki" : "Perempuan") +
                "\nPendapatan : " + getPendapatan() +
                "\nTahun Masuk: " + tahunMasuk.getDayOfMonth() + 
                    "/" + tahunMasuk.getMonthValue() + 
                    "/" + tahunMasuk.getYear() + 
                "\nJumlah Anak: " + jumlahAnak +
                "\nGaji: $" + String.format("%.2f", gaji);
    }
}
