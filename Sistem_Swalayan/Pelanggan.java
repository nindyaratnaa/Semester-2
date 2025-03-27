package Sistem_Swalayan;

import java.util.ArrayList;
import java.util.List;

class Pelanggan {
    private String nomorPelanggan;
    private String nama;
    private double saldo;
    private String pin;
    private boolean akunDiblokir;
    private int jumlahKesalahan;

    public Pelanggan(String nomorPelanggan, String nama, double saldo, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
        this.akunDiblokir = false;
        this.jumlahKesalahan = 0;
    }

    //Getter dan Setter
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAkunDiblokir() {
        return akunDiblokir;
    }

    //Verifikasi pin member
    public boolean verifikasiPin(String inputPin) {
        if (this.pin.equals(inputPin)) {
            jumlahKesalahan = 0;
            return true;
        } else {
            jumlahKesalahan++;
            if (jumlahKesalahan >= 3) {
                akunDiblokir = true;
            }
            return false;
        }
    }
}

//Menyimpan data pelanggan
class dataPelanggan {
    private static List<Pelanggan> dataPelanggan = new ArrayList<>();

    //Contoh data yang sudah ada
    static {
        dataPelanggan.add(new Pelanggan("5620482937", "Zoo", 10000000, "2222"));
        dataPelanggan.add(new Pelanggan("3813094618", "Baal", 0, "1111"));
        dataPelanggan.add(new Pelanggan("5620751941", "Bayu", 5500000, "4321"));
        dataPelanggan.add(new Pelanggan("7401247130", "Anya", 3000000, "1234"));
    }

    //Cek apakah pin sama dengan yang sudah ada
    public static Pelanggan verifikasiMember (String ID, String pin) {
        for (Pelanggan i : dataPelanggan) {
            if (i.getNomorPelanggan().equals(ID) && i.getPin().equals(pin)) {
                return i;
            }
        }
        return null;
    }

    //Menambahkan member baru
    public static void memberBaru (Pelanggan pelanggan) {
        dataPelanggan.add(pelanggan);
    }

    //Menyimpan data pelanggan
    public static List<Pelanggan> getDataPelanggan() {
        return dataPelanggan;
    }
}