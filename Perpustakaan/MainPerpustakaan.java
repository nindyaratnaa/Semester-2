package Perpustakaan;

public class MainPerpustakaan {
    public static void main(String[] args) {
        //Array Judul Buku
        String[] BukuTeknologi = {"Internet of Things", "Teknologi Blockchain", "Komputasi Awan", "Kiat Sukses Menjadi Programmer", "Membangun Aplikasi Android"};
        String[] BukuFilsafat = {"Madilog", "Filsafat Proses", "Metafisika", "Sejarah Filsafat Barat", "Critique of Pure Reason"};
        String[] BukuSejarah = {"Sejarah Indonesia Modern", "Indonesia: A Country Study", "Indonesia Merdeka", "Negeri 5 Menara", "Sejarah Nasional Indonesia"};
        String[] BukuAgama = {"Al-Qur'an", "Fiqh Sunnah", "Tafsir Al-Azhar", "The Bible (Alkitab)", "Sufi dan Cinta"};
        String[] BukuPsikologi = {"The Power of Habit", "Man's Search for Meaning", "Psikologi Populer", "Bersyukur Itu Indah", "Menggapai Kebahagiaan"};
        String[] BukuPolitik = {"Indonesia dalam Pusaran Politik Global", "Negara Paripurna", "The Communist Manifesto", "Revolusi Mental", "Teori Demokrasi"};
        String[] BukuFiksi = {"Laskar Pelangi", "Bumi Manusia", "The Rainbow Troops", "Ayat-Ayat Cinta", "Di Tanah Lada"}; 

        //Array Penulis
        String[] namaPenulisTeknologi = {"Arief Widhiyasa", "Muhammad A. D. Al Farabi", "Asep Japar", "Dedy Akhmad", "Agus Kurniawan"};
        String[] namaPenulisFilsafat = {"Tan Malaka", "John Dewey", "Aristoteles", "Will Durant", "Immanuel Kant"};
        String[] namaPenulisSejarah = {"M.C. Ricklefs", "Robert Cribb", "Sukarno", "Ahmad Fuadi", "Sartono Kartodirdjo"};
        String[] namaPenulisAgama = {"Muhammad", "Sayyid Sabiq", "Hamka", "(Various Authors)", "Kahlil Gibran"};
        String[] namaPenulisPsikologi = {"Charles Duhigg", "Viktor Frankl", "Daniel Goleman", "T. S. Sutanto", "Z. H. J. Nur Alim"};
        String[] namaPenulisPolitik = {"Anwar Ibrahim", "Jimly Asshiddiqie", "Karl Marx & Friedrich Engels", "Gus Dur (Abdurrahman Wahid)", "Robert Dahl"};
        String[] namaPenulisFiksi = {"Andrea Hirata", "Pramoedya Ananta Toer", "Andrea Hirata", "Habiburrahman El Shirazy", "Ahmad Tohari"}; 
    
        //Objek Penulis
        Penulis[] penulisTeknologi = new Penulis[namaPenulisTeknologi.length];
        for (int i = 0; i < namaPenulisTeknologi.length; i++) {
            penulisTeknologi[i] = new Penulis(namaPenulisTeknologi[i]);
        }

        Penulis[] penulisFilsafat = new Penulis[namaPenulisFilsafat.length];
        for (int i = 0; i < namaPenulisFilsafat.length; i++) {
            penulisFilsafat[i] = new Penulis(namaPenulisFilsafat[i]);
        }

        Penulis[] penulisSejarah = new Penulis[namaPenulisSejarah.length];
        for (int i = 0; i < namaPenulisSejarah.length; i++) {
            penulisSejarah[i] = new Penulis(namaPenulisSejarah[i]);
        }

        Penulis[] penulisAgama = new Penulis[namaPenulisAgama.length];
        for (int i = 0; i < namaPenulisAgama.length; i++) {
            penulisAgama[i] = new Penulis(namaPenulisAgama[i]);
        }

        Penulis[] penulisPsikologi = new Penulis[namaPenulisPsikologi.length];
        for (int i = 0; i < namaPenulisPsikologi.length; i++) {
            penulisPsikologi[i] = new Penulis(namaPenulisPsikologi[i]);
        }

        Penulis[] penulisPolitik = new Penulis[namaPenulisPolitik.length];
        for (int i = 0; i < namaPenulisPolitik.length; i++) {
            penulisPolitik[i] = new Penulis(namaPenulisPolitik[i]);
        }

        Penulis[] penulisFiksi = new Penulis[namaPenulisFiksi.length];
        for (int i = 0; i < namaPenulisFiksi.length; i++) {
            penulisFiksi[i] = new Penulis(namaPenulisFiksi[i]);
        }

        //Objek Buku
        Buku[] bukuTeknologi = new Buku[BukuTeknologi.length];
        for (int i = 0; i < BukuTeknologi.length; i++) {
            bukuTeknologi[i] = new Buku(BukuTeknologi[i], new Penulis[]{penulisTeknologi[i]}, "Teknologi");
        }

        Buku[] bukuFilsafat = new Buku[BukuFilsafat.length];
        for (int i = 0; i < BukuFilsafat.length; i++) {
            bukuFilsafat[i] = new Buku(BukuFilsafat[i], new Penulis[]{penulisFilsafat[i]}, "Filsafat");
        }

        Buku[] bukuSejarah = new Buku[BukuSejarah.length];
        for (int i = 0; i < BukuSejarah.length; i++) {
            bukuSejarah[i] = new Buku(BukuSejarah[i], new Penulis[]{penulisSejarah[i]}, "Sejarah");
        }

        Buku[] bukuAgama = new Buku[BukuAgama.length];
        for (int i = 0; i < BukuAgama.length; i++) {
            bukuAgama[i] = new Buku(BukuAgama[i], new Penulis[]{penulisAgama[i]}, "Agama");
        }

        Buku[] bukuPsikologi = new Buku[BukuPsikologi.length];
        for (int i = 0; i < BukuPsikologi.length; i++) {
            bukuPsikologi[i] = new Buku(BukuPsikologi[i], new Penulis[]{penulisPsikologi[i]}, "Psikologi");
        }

        Buku[] bukuPolitik = new Buku[BukuPolitik.length];
        for (int i = 0; i < BukuPolitik.length; i++) {
            bukuPolitik[i] = new Buku(BukuPolitik[i], new Penulis[]{penulisPolitik[i]}, "Politik");
        }

        Buku[] bukuFiksi = new Buku[BukuFiksi.length];
        for (int i = 0; i < BukuFiksi.length; i++) {
            bukuFiksi[i] = new Buku(BukuFiksi[i], new Penulis[]{penulisFiksi[i]}, "Fiksi");
        }

        //Kategori buku
        Kategori kategoriTeknologi = new Kategori("Teknologi", bukuTeknologi);
        Kategori kategoriFilsafat = new Kategori("Filsafat", bukuFilsafat);
        Kategori kategoriSejarah = new Kategori("Sejarah", bukuSejarah);
        Kategori kategoriAgama = new Kategori("Agama", bukuAgama);
        Kategori kategoriPsikologi = new Kategori("Psikologi", bukuPsikologi);
        Kategori kategoriPolitik = new Kategori("Politik", bukuPolitik);
        Kategori kategoriFiksi = new Kategori("Fiksi", bukuFiksi);

        Header();
        printOut(kategoriTeknologi);
        printOut(kategoriFilsafat);
        printOut(kategoriSejarah);
        printOut(kategoriAgama);
        printOut(kategoriPsikologi);
        printOut(kategoriPolitik);
        printOut(kategoriFiksi);
    }

    public static void Header() {
        System.out.printf("%-12s%-40s%s\n", "Kategori", "Judul Buku", "Nama Penulis");
        System.out.println("================================================================================");
    }

    public static void printOut(Kategori kategori) {
        for (Buku buku : kategori.getListBuku()) {
            System.out.printf("%-12s%-40s", kategori.getNama(), buku.getJudul());
            for (Penulis penulis : buku.getPenulis()) {
                System.out.println(penulis.getNama() + " ");
            }
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}