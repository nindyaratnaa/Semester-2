package Hidup_Mahasiswa_Pekerja;

public class TestProgram {
    public static void main(String[] args) {
        System.out.println("=== TEST CASE MANUSIA ===");

        Manusia lakiMenikah = new Manusia("Hazel", "1234567890", true, true);
        Manusia perempuanMenikah = new Manusia("Devi", "0987654321", false, true);
        Manusia belumMenikah = new Manusia("Rey", "1122334455", false, false);

        System.out.println("\n1. Laki-laki Menikah");
        System.out.println(lakiMenikah);

        System.out.println("\n2. Perempuan Menikah");
        System.out.println(perempuanMenikah);

        System.out.println("\n3. Belum Menikah");
        System.out.println(belumMenikah);


        System.out.println("\n\n=== TEST CASE MAHASISWA FILKOM ===");

        MahasiswaFILKOM ipkKurang = new MahasiswaFILKOM("215150700111000", 2.8, "Alvin", "123", true, false);
        MahasiswaFILKOM ipkSedang = new MahasiswaFILKOM("215150300111000", 3.3, "Amel", "124", false, false);
        MahasiswaFILKOM ipkTinggi = new MahasiswaFILKOM("215150400111000", 3.9, "Gopi", "125", true, false);

        System.out.println("\n1. IPK < 3");
        System.out.println(ipkKurang);

        System.out.println("\n2. IPK 3.0 - 3.5");
        System.out.println(ipkSedang);

        System.out.println("\n3. IPK 3.5 - 4");
        System.out.println(ipkTinggi);


        System.out.println("\n\n=== TEST CASE PEKERJA ===");

        Pekerja pekerja2Tahun = new Pekerja(3000, 2023, 4, 1, 2, "Weda", "111", true, true);
        Pekerja pekerja9Tahun = new Pekerja(4000, 2016, 4, 1, 0, "Khai", "112", false, true);
        Pekerja pekerja20Tahun = new Pekerja(5000, 2005, 4, 1, 10, "Gantang", "113", true, true);

        System.out.println("\n1. Lama bekerja 2 tahun, anak 2");
        System.out.println(pekerja2Tahun);

        System.out.println("\n2. Lama bekerja 9 tahun");
        System.out.println(pekerja9Tahun);

        System.out.println("\n3. Lama bekerja 20 tahun, anak 10");
        System.out.println(pekerja20Tahun);


        System.out.println("\n\n=== TEST CASE MANAGER ===");

        Manager manager15Tahun = new Manager("HRD", 7500, 2010, 4, 1, 3, "Bayu", "114", true, true);

        System.out.println("\nManager, lama bekerja 15 tahun, gaji $7500");
        System.out.println(manager15Tahun);
    }
}
