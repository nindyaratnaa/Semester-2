package MbekCafee;

public class KambingJumboMbek {
    private static final double HARGA_MANDI = 5000;
    private static final double HARGA_GROOMING = 7000;
    private static final double DISKON_GEMUK = 0.15;
    private static final double PAJAK = 0.05;

    private String namaKambing;
    private int berat;
    private String jenisPerawatan;

    public KambingJumboMbek(String nama, int berat, String jenis) {
        this.namaKambing = nama;
        this.berat = berat;
        this.jenisPerawatan = jenis;
    }

	private double hitungBiayaDasar() {
       // Tuliskan Kodemu Disini
       // Menghitung biaya dasar dari jenis perawatan dan berat mbek
       // Pake turnery biar singkat aja si
        return jenisPerawatan.equals("mandi")? HARGA_MANDI * berat : HARGA_GROOMING * berat;
    }

    
    private double hitungDiskon() {
       // Tuliskan Kodemu Disini
       // Cek berat kambing >= 21 ga
       // Pake turnery juga sama biar singkat
        return berat >= 21? DISKON_GEMUK * hitungBiayaDasar() : 0;
    }

    public static double hitungPajak(double subtotal) {
        // Tuliskan Kodemu Disini
        // Intinya ikkutin soal aja si ada pajak 5% dari total biaya setelah diskon.
        return PAJAK * subtotal;
    }

    
    public void cetakNota() {
        // Menyimpan nilai krn sebelumnya method return
        double nilaiBiayaDasar = hitungBiayaDasar(); // Harga belum diskon
        double nilaiDiskon = hitungDiskon(); // Nilai diskonya
        double nilaiSetengahFinal = nilaiBiayaDasar - nilaiDiskon; // Harga sebelum pajak
        double pajakPemda = hitungPajak(nilaiSetengahFinal); // 5% Pajaknya
        double nilaiFINAL = nilaiSetengahFinal + pajakPemda; // Biaya yang dibayar
        
        // Nama kambing gratisan pake equalsignorecase jd ga sensitif
        boolean kambingGratisan = namaKambing.equalsIgnoreCase("mbek") || namaKambing.equalsIgnoreCase("mbeek") || namaKambing.equalsIgnoreCase("mbeeek");
        
        // Ini tinggal inputin dari inisasi di awal itu
        System.out.println("============ NOTA KAMBING JUMBO ============");
        System.out.printf("Nama Kambing: %s\n", namaKambing);// Tuliskan Kodemu Disini 
        System.out.printf("Berat: %d kg\n", berat);// Tuliskan Kodemu Disini
        System.out.printf("Jenis Perawatan: %s\n", jenisPerawatan);// Tuliskan Kodemu Disini
        System.out.printf("Biaya Dasar: Rp %.1f\n", nilaiBiayaDasar);// Tuliskan Kodemu Disini
        System.out.printf("Diskon: Rp %.1f\n", nilaiDiskon);// Tuliskan Kodemu Disini
        System.out.printf("Subtotal: Rp %.1f\n", nilaiSetengahFinal);// Tuliskan Kodemu Disini
        System.out.printf("Pajak: Rp %.1f\n", pajakPemda);// Tuliskan Kodemu Disini
        System.out.printf("Total Biaya: Rp %.1f\n", kambingGratisan? 0.0 : nilaiFINAL);// Tuliskan Kodemu Disini
        System.out.println("============================================");

        // Pesan unik untuk Mbek
        // Tuliskan Kodemu Disini
        // Output unik nnti dibedakan berdasar nama kambing
        // Pake turnery biar singkat aja lebih rapu pula
        System.out.printf("Terima kasih, %s %s\n", namaKambing, kambingGratisan? 
                            "! Kambing Jumbo selalu gratis, ya!" 
                          : "! Nanti kambingmu kami kembalikan... atau jadi menu special");
    }
}