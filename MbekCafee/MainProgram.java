package MbekCafee;

import java.util.Scanner;

class MainProgram {
    // DILARANG MENGEDIT KELAS MAIN
    // JIKA MENGEDIT NILAI = 0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input nama kambing
        String nama = "";
        while (true) {
            nama = scanner.nextLine().trim();
            if (nama.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Mbek! Nama kambing harus pakai huruf, bukan angka!");
            }
        }

        // Input berat
        int berat = 0;
        while (true) {
            try {
                berat = Integer.parseInt(scanner.nextLine().trim());
                if (berat < 1) {
                    System.out.println("Kambing hantu? Masukkan berat yang valid, hooman!");
                } else if (berat > 50) {
                    System.out.println("Wah, ini kambing atau sapi?");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Berat tidak valid! Kambing kami bukan hologram!");
            }
        }

        // Input jenis perawatan
        String jenis = "";
        while (true) {
            jenis = scanner.nextLine().trim().toLowerCase();
            if (jenis.equals("mandi") || jenis.equals("grooming")) {
                break;
            } else {
                System.out.println("Pilih 'mandi' atau 'grooming'! Kambingmu mau jadi artis?");
            }
        }

        // Proses dan cetak nota
        KambingJumboMbek kambing = new KambingJumboMbek(nama, berat, jenis);
        kambing.cetakNota();

        scanner.close();
    }    
}