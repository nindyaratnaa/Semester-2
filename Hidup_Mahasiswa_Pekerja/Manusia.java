package Hidup_Mahasiswa_Pekerja;

public class Manusia {
    private String nama;
    private String nik;
    private boolean jenisKelamin; //True == laki False == perempuan
    private boolean menikah;
    
    //Konstruktor Manusia
    public Manusia (String nama, String nik, boolean jenisKelamin, boolean menikah) {
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }
    
    //Getter setter
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNik() {
        return nik;
    }
    
    public void setNik(String nik) {
        this.nik = nik;
    }
    
    public boolean isJenisKelamin() {
        return jenisKelamin;
    }
    
    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public boolean isMenikah() {
        return menikah;
    }

    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }
    
    //Untuk ambil tunjangan
    public double getTunjangan() {
        if (menikah) {
            if (jenisKelamin) { //True == laki laki
                return 25;
            } else { //False == perempuan
                return 20;
            }
        } else {
            return 15; //Bila si manusia belum menikah
        }
        
    }

    //Untuk ambil pendapatan
    public double getPendapatan() {
        return getTunjangan(); //Karena berdasarkan tunjangan
    }

    //Output hasil dengan format sendiri
    public String toString() {
        return "Nama : " + nama + 
               "\nNIK : " + nik + 
               "\nJenis Kelamin : " + (jenisKelamin ? "Laki-laki" : "Perempuan") + 
               "\nPendapatan : " + getPendapatan();
    }
    
}
