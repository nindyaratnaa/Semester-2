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
        return 0;
    }

    //Ambil status mahasiswa dari NIM ke angkatan dan status
    public String getStatus() {
        int angkatan = Integer.parseInt(nim.substring(0, 2));
        String prodi;
        
        switch (nim.charAt(6)) {
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
        return prodi + ", 20" + angkatan;
    }

    @Override //Output manusia + mahasiswa filkom
    public String toString() {
        return "nama : " + getNama() +
                "\nnik : " + getNik() +
                "\njenisKelamin : " + (isJenisKelamin() ? "Laki-laki" : "Perempuan") +
                "\npendapatan : " + (getPendapatan() + getBeasiswa()) +
                "\nnim : " + nim +
                "\nipk : " + ipk +
                "\nstatus : " + getStatus();
}

}
