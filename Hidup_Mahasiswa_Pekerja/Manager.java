package Hidup_Mahasiswa_Pekerja;

public class Manager extends Pekerja {
    private String departemen;

    public Manager (String departemen, double gaji, int tahun, int bulan, int hari, int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super (gaji, tahun, bulan, hari, jumlahAnak, nama, nik, jenisKelamin, menikah);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }
    
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override //Pendapatan manager
    public double getPendapatan() {
        return super.getPendapatan() + (getGaji() * 0.1);
    }

    @Override //Output manager
    public String toString() {
        return super.toString() + "\nDepartemen: " + departemen;
    }
}
