package Hidup_Mahasiswa_Pekerja;

public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;
    
    //Konstruktor mahasiswa filkom
    public MahasiswaFILKOM(String nim, double ipk, String nama, String nik, boolean jenisKelamin, boolean menikah) {
        super (nama, nik, jenisKelamin, menikah); //Karena di ambil dari parents
        this.nim = nim;
        this.ipk = ipk;
    }
    
    //Getter setter
    public String getNim() {
        return nim;
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIpk() {
        return ipk;
    }
    
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    //Untuk ambil beasiswa dri IPK
    public double getBeasiswa() {
        if (ipk >= 3.5) {
            return 75;
        } else if (ipk >= 3.0 ) {
            return 50;
        }
        return 0; //Jika tidak memenuhi syarat
    }

    //Ambil status mahasiswa dari NIM ke angkatan dan status
    public String getStatus() {
        int angkatan = Integer.parseInt(nim.substring(0, 2)); //Ambil angkatan 2 karakter awal nim
        String prodi; //Inisiasi variabel
        
        switch (nim.charAt(6)) { //Ambil indeks ke 6 karena di mulai dari 0, lalu di gantikan dengan prodi
            case '2' :
                prodi = "Teknik Informatika";
                break;
            case '3' :
                prodi = "Teknik Komputer";
                break;
            case '4' :
                prodi = "Sistem Informasi";
                break;
            case '6' :
                prodi = "Pendidikan Teknologi Informasi";
                break;
            case '7' :
                prodi = "Teknologi Informasi";
                break;
            default :
                prodi = "Tidak diketahui";
                break;
        }
        return prodi + ", 20" + angkatan; //Dengan asumsi seluruh angkatan merupakan tahun 2000++
    }

    @Override //Output mahasiswa filkom
    public String toString() {
        return "Nama : " + getNama() +
                "\nNIK : " + getNik() +
                "\nJenis Kelamin : " + (isJenisKelamin() ? "Laki-laki" : "Perempuan") +
                "\nPendapatan : " + (getPendapatan() + getBeasiswa()) +
                "\nNIM : " + nim +
                "\nIPK : " + ipk +
                "\nStatus : " + getStatus();
}

}
