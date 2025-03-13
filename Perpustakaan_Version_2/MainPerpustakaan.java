/* Pengembangan dari package Peroustakaan dengan menambahkan: 
    1. Tambahkan attribute ‘sinopsis’ (minimal 10 kata),
    2. Constructor pada semua attribute yang ada,
    3. Method hitung jumlah kata pada atribut synopsis,
    4. Method cek tingkat kesamaan, dengan parameter object lain dan nilai kembalian 0-
       100% sesuai kesamaan attribute kedua object,
    5. Method copy yang mengembalikan object yang nilainya sama.
*/

package Perpustakaan_Version_2;
import java.util.Scanner;

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
    
        //Array Tahun Buku
        int[] tahunBukuTeknologi = {2016, 2017, 2015, 2014, 2015};
        int[] tahunBukuFilsafat = {1984, 1929, 1782, 1950, 1781};
        int[] tahunBukuSejarah = {2001, 2001, 1945, 2009, 1993};
        int[] tahunBukuAgama = {610, 1952, 800, 100, 1923};
        int[] tahunBukuPsikologi = {2012, 1946, 1995, 2010, 2017};
        int[] tahunBukuPolitik = {2007, 2009, 1848, 2006, 1989};
        int[] tahunBukuFiksi = {2005, 1980, 2006, 2004, 2001};

        //Array Sinopsis Buku
        String[] sinopsisBukuTeknologi = {"Buku ini menjelaskan konsep dan aplikasi dari Internet of Things (IoT), termasuk cara menghubungkan perangkat\nke internet untuk menciptakan ekosistem pintar.",
                                          "Buku ini mengulas teknologi blockchain secara mendalam, membahas cara kerjanya, serta aplikasi praktisnya di\nberbagai sektor seperti keuangan dan logistik.",
                                          "Buku ini membahas tentang komputasi awan, termasuk infrastruktur cloud, layanan, dan manfaatnya dalam bisnis\ndan teknologi modern.",
                                          "Buku ini memberikan tips dan panduan bagi para pemula yang ingin sukses dalam dunia pemrograman, termasuk\nketerampilan teknis dan soft skills yang diperlukan.",
                                          "Buku ini mengajarkan langkah demi langkah cara membangun aplikasi Android, dari dasar hingga pengembangan\naplikasi yang kompleks dengan menggunakan Java."};
        String[] sinopsisBukuFilsafat = {"Buku ini mengulas tentang logika, metode ilmiah, dan filsafat sebagai dasar pemikiran dalam menghadapi\nperkembangan ilmu pengetahuan. Tan Malaka mengajukan pendekatan baru dalam pemikiran logis dan filsafat.",
                                         "Buku ini menekankan pentingnya pendidikan dalam perkembangan individu dan masyarakat, serta memaparkan bagaimana\nfilosofi pragmatisme Dewey dapat diterapkan dalam pendidikan.",
                                         "Buku karya Aristoteles ini membahas tentang prinsip-prinsip dasar dari eksistensi, substansi, dan penyebab yang\nada dalam alam semesta. Filsafat ini menjadi dasar bagi banyak aliran filsafat selanjutnya.",
                                         "Buku ini adalah kajian mendalam mengenai perkembangan filsafat Barat, dari filsafat Yunani kuno hingga filsafat\nkontemporer. Durant memberikan gambaran lengkap dari berbagai pemikir besar Barat.",
                                         "Buku monumental karya Kant ini mengkritisi batasan-batasan dan struktur pengetahuan manusia, serta menyelidiki\nbagaimana kita memahami dunia luar, dengan fokus pada hubungan antara pikiran dan dunia."};
        String[] sinopsisBukuSejarah = {"Buku ini memberikan kajian komprehensif tentang sejarah Indonesia dari masa kolonial hingga kemerdekaan, serta\ndampak perubahan sosial, politik, dan ekonomi di Indonesia modern.",
                                        "Buku ini menyajikan gambaran menyeluruh mengenai Indonesia, mulai dari sejarah, kebudayaan, ekonomi, politik,\nhingga isu-isu kontemporer yang memengaruhi negara ini.",
                                        "Buku ini adalah pidato bersejarah Sukarno yang mengumumkan proklamasi kemerdekaan Indonesia pada 17 Agustus 1945,\nyang memuat semangat perjuangan bangsa Indonesia untuk meraih kemerdekaan.",
                                        "Novel ini menceritakan perjalanan seorang pemuda asal desa yang belajar di pesantren, menemukan impian\ndan perjuangan hidup bersama teman-temannya di bawah Menara yang menjadi simbol harapan.",
                                        "Buku ini memberikan kajian mendalam tentang sejarah Indonesia dari masa kerajaan-kerajaan tradisional,\npenjajahan, hingga perjuangan menuju kemerdekaan, dengan fokus pada perkembangan bangsa Indonesia."};
        String[] sinopsisBukuAgama = {"Al-Qur'an adalah kitab suci agama Islam yang diyakini sebagai wahyu dari Tuhan yang diterima oleh Nabi Muhammad.\nBuku ini berisi petunjuk hidup dan pedoman moral bagi umat Muslim.",
                                      "Buku ini menjelaskan tentang hukum Islam yang berkaitan dengan ibadah dan kehidupan sehari-hari, berdasarkan sunnah\nNabi Muhammad. Fiqh Sunnah menjelaskan detail dari praktik ibadah dan etika Islam.",
                                      "Tafsir Al-Azhar adalah karya tafsir Al-Qur'an karya Hamka yang memberikan penjelasan mendalam tentang ayat-ayat\n Al-Qur'an dengan pendekatan yang mudah dipahami oleh umat Muslim.",
                                      "Alkitab adalah kitab suci agama Kristen yang terdiri dari Perjanjian Lama dan Perjanjian Baru. Ini berisi kisah-kisah,\najaran, dan wahyu Tuhan kepada umat manusia, dengan fokus pada ajaran Yesus Kristus.",
                                      "Buku ini adalah karya Kahlil Gibran yang membahas tentang mistisisme, cinta, dan hubungan manusia dengan Tuhan,\nmelalui perspektif sufisme yang mendalam dan puitis."};
        String[] sinopsisBukuPsikologi = {"Buku ini menjelaskan bagaimana kebiasaan terbentuk dan bagaimana kita bisa mengubahnya untuk mencapai\nkesuksesan, baik dalam kehidupan pribadi maupun profesional.",
                                          "Buku ini adalah refleksi Viktor Frankl tentang pengalamannya di kamp konsentrasi Nazi dan bagaimana pencarian\nmakna hidup dapat memberi kekuatan untuk bertahan hidup dalam situasi ekstrem.",
                                          "Buku ini membahas konsep kecerdasan emosional dan bagaimana pentingnya kemampuan mengelola emosi dalam\nmeraih kesuksesan dan kebahagiaan dalam kehidupan sehari-hari.",
                                          "Buku ini mengajak pembaca untuk menemukan kebahagiaan melalui sikap bersyukur dan menunjukkan manfaat serta\nkekuatan positif dari rasa syukur dalam kehidupan.",
                                          "Buku ini memberikan panduan praktis dan inspirasi untuk mencapai kebahagiaan dengan fokus pada pembentukan\nkebiasaan positif dan perubahan cara berpikir yang sehat."};
        String[] sinopsisBukuPolitik = {"Buku ini membahas posisi Indonesia dalam kancah politik global, menganalisis tantangan dan peluang yang\ndihadapi Indonesia dalam hubungan internasional dan diplomasi global.",
                                        "Buku ini membahas tentang konsep negara yang ideal, yaitu negara hukum yang demokratis dan berkeadilan,\nserta penerapan nilai-nilai konstitusional dalam kehidupan berbangsa dan bernegara.",
                                        "Buku ini adalah manifesto yang menegaskan pentingnya perjuangan kelas buruh dan menggagas revolusi untuk\nmenggulingkan kapitalisme dan menggantikannya dengan masyarakat tanpa kelas.",
                                        "Buku ini menekankan pentingnya perubahan mentalitas masyarakat Indonesia untuk menuju kemajuan, dengan\nmengedepankan nilai-nilai toleransi, kebebasan, dan demokrasi.",
                                        "Buku ini menyajikan analisis tentang teori-teori demokrasi dan bagaimana sistem demokrasi bekerja dalam\nmasyarakat modern, serta tantangan yang dihadapi oleh demokrasi dalam praktiknya."};
        String[] sinopsisBukuFiksi = {"Buku ini menceritakan kisah inspiratif tentang sekelompok anak-anak dari keluarga miskin yang berjuang untuk\nmendapatkan pendidikan di Belitung, serta persahabatan mereka yang luar biasa.",
                                      "Novel ini menceritakan kisah Minke, seorang pemuda pribumi yang terjebak dalam konflik sosial dan politik\nkolonial Belanda di awal abad 20, serta perjuangannya untuk menemukan identitas pribumi.",
                                      "Versi bahasa Inggris dari Laskar Pelangi, menceritakan kisah yang sama tentang perjuangan anak-anak di\nBelitung untuk memperoleh pendidikan dan meraih impian mereka.",
                                      "Buku ini mengisahkan tentang perjalanan cinta, persahabatan, dan ujian kehidupan seorang mahasiswa Indonesia\ndi Mesir yang berjuang untuk menjaga prinsip-prinsip agama dalam kehidupan.",
                                      "Novel ini bercerita tentang kehidupan masyarakat di sebuah desa kecil di Jawa, menggambarkan dinamika sosial,\ncinta, dan perjuangan hidup di tengah kemiskinan serta ketegangan yang melanda mereka."};



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
            bukuTeknologi[i] = new Buku(BukuTeknologi[i], new Penulis[]{penulisTeknologi[i]}, "Teknologi", sinopsisBukuTeknologi[i], tahunBukuTeknologi[i]);

        }

        Buku[] bukuFilsafat = new Buku[BukuFilsafat.length];
        for (int i = 0; i < BukuFilsafat.length; i++) {
            bukuFilsafat[i] = new Buku(BukuFilsafat[i], new Penulis[]{penulisFilsafat[i]}, "Filsafat", sinopsisBukuFilsafat[i], tahunBukuFilsafat[i]);
        }

        Buku[] bukuSejarah = new Buku[BukuSejarah.length];
        for (int i = 0; i < BukuSejarah.length; i++) {
            bukuSejarah[i] = new Buku(BukuSejarah[i], new Penulis[]{penulisSejarah[i]}, "Sejarah", sinopsisBukuSejarah[i], tahunBukuSejarah[i]);
        }

        Buku[] bukuAgama = new Buku[BukuAgama.length];
        for (int i = 0; i < BukuAgama.length; i++) {
            bukuAgama[i] = new Buku(BukuAgama[i], new Penulis[]{penulisAgama[i]}, "Agama", sinopsisBukuAgama[i], tahunBukuAgama[i]);
        }

        Buku[] bukuPsikologi = new Buku[BukuPsikologi.length];
        for (int i = 0; i < BukuPsikologi.length; i++) {
            bukuPsikologi[i] = new Buku(BukuPsikologi[i], new Penulis[]{penulisPsikologi[i]}, "Psikologi", sinopsisBukuPsikologi[i], tahunBukuPsikologi[i]);
        }

        Buku[] bukuPolitik = new Buku[BukuPolitik.length];
        for (int i = 0; i < BukuPolitik.length; i++) {
            bukuPolitik[i] = new Buku(BukuPolitik[i], new Penulis[]{penulisPolitik[i]}, "Politik", sinopsisBukuPolitik[i], tahunBukuPolitik[i]);
        }

        Buku[] bukuFiksi = new Buku[BukuFiksi.length];
        for (int i = 0; i < BukuFiksi.length; i++) {
            bukuFiksi[i] = new Buku(BukuFiksi[i], new Penulis[]{penulisFiksi[i]}, "Fiksi", sinopsisBukuFiksi[i], tahunBukuFiksi[i]);
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

        System.out.println("Apa yang ingin dilakukan:(1/2)\n1. Menampilkan sinopsis\n2. Membandingkan buku\n3. Menyalin buku");

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("\nMasukkan kategori buku(Teknologi/Filsafat/dst): ");
            String inputKategori = input.nextLine().trim(); //trim untuk menghapus spasi

            //Mencocokkan input dengan kategori
            if (inputKategori.equalsIgnoreCase("Teknologi")) {
                Buku.tampilkanSinopsis(kategoriTeknologi, input);
            } else if (inputKategori.equalsIgnoreCase("Filsafat")) {
                Buku.tampilkanSinopsis(kategoriFilsafat, input);
            } else if (inputKategori.equalsIgnoreCase("Sejarah")) {
                Buku.tampilkanSinopsis(kategoriSejarah, input);
            } else if (inputKategori.equalsIgnoreCase("Agama")) {
                Buku.tampilkanSinopsis(kategoriAgama, input);
            } else if (inputKategori.equalsIgnoreCase("Psikologi")) {
                Buku.tampilkanSinopsis(kategoriPsikologi, input);
            } else if (inputKategori.equalsIgnoreCase("Politik")) {
                Buku.tampilkanSinopsis(kategoriPolitik, input);
            } else if (inputKategori.equalsIgnoreCase("Fiksi")) {
                Buku.tampilkanSinopsis(kategoriFiksi, input);
            } else {System.out.println("Kategori tidak ditemukan!");}

        } else if (pilihan == 2) {
            System.out.print("\nMasukkan kategori buku 1: ");
            String inputKategori1 = input.nextLine().trim();
            System.out.print("Masukkan judul buku 1: ");
            String judulbuku1 = input.nextLine();

            System.out.print("\nMasukkan kategori buku 2: ");
            String inputKategori2 = input.nextLine().trim();
            System.out.print("Masukkan judul buku ke 2: ");
            String judulbuku2 = input.nextLine();

            Kategori kategoriPertama = null;
            Kategori kategoriKedua = null;

            
            //Mencocokkan input dengan kategori
            if (inputKategori1.equalsIgnoreCase("Teknologi")) {
                kategoriPertama = kategoriTeknologi;
            } else if (inputKategori1.equalsIgnoreCase("Filsafat")) {
                kategoriPertama = kategoriFilsafat;
            } else if (inputKategori1.equalsIgnoreCase("Sejarah")) {
                kategoriPertama = kategoriSejarah;
            } else if (inputKategori1.equalsIgnoreCase("Agama")) {
                kategoriPertama = kategoriAgama;
            } else if (inputKategori1.equalsIgnoreCase("Psikologi")) {
                kategoriPertama = kategoriPsikologi;
            } else if (inputKategori1.equalsIgnoreCase("Politik")) {
                kategoriPertama = kategoriPolitik;
            } else if (inputKategori1.equalsIgnoreCase("Fiksi")) {
                kategoriPertama = kategoriFiksi;
            }

            //Mencocokkan input dengan kategori
            if (inputKategori2.equalsIgnoreCase("Teknologi")) {
                kategoriKedua = kategoriTeknologi;
            } else if (inputKategori2.equalsIgnoreCase("Filsafat")) {
                kategoriKedua = kategoriFilsafat;
            } else if (inputKategori2.equalsIgnoreCase("Sejarah")) {
                kategoriKedua = kategoriSejarah;
            } else if (inputKategori2.equalsIgnoreCase("Agama")) {
                kategoriKedua = kategoriAgama;
            } else if (inputKategori2.equalsIgnoreCase("Psikologi")) {
                kategoriKedua = kategoriPsikologi;
            } else if (inputKategori2.equalsIgnoreCase("Politik")) {
                kategoriKedua = kategoriPolitik;
            } else if (inputKategori2.equalsIgnoreCase("Fiksi")) {
                kategoriKedua = kategoriFiksi;
            }

            if (kategoriPertama != null && kategoriKedua != null) {
                Buku.perbandinganBuku(kategoriPertama, kategoriKedua, judulbuku1, judulbuku2);
            } else {
                System.out.println("Salah satu kategori tidak ditemukan!");
            }


        } else if (pilihan == 3) {
            System.out.print("\nMasukkan kategori buku yang ingin disalin: ");
            String inputKategori = input.nextLine().trim();
            System.out.print("Masukkan judul buku: ");
            String inputJudul = input.nextLine();

            Kategori kategoricopy = null;
            if (inputKategori.equalsIgnoreCase("Teknologi")) {
                kategoricopy = kategoriTeknologi;
            } else if (inputKategori.equalsIgnoreCase("Filsafat")) {
                kategoricopy = kategoriFilsafat;
            } else if (inputKategori.equalsIgnoreCase("Sejarah")) {
                kategoricopy = kategoriSejarah;
            } else if (inputKategori.equalsIgnoreCase("Agama")) {
                kategoricopy = kategoriAgama;
            } else if (inputKategori.equalsIgnoreCase("Psikologi")) {
                kategoricopy = kategoriPsikologi;
            } else if (inputKategori.equalsIgnoreCase("Politik")) {
                kategoricopy = kategoriPolitik;
            } else if (inputKategori.equalsIgnoreCase("Fiksi")) {
                kategoricopy = kategoriFiksi;
            }

            if (kategoricopy != null) {
                Buku bukuAsli = null;

                for (Buku buku : kategoricopy.getListBuku()) {
                    if (buku.getJudul().equalsIgnoreCase(inputJudul)) {
                        bukuAsli = buku;
                        break;
                    }
                }

                if (bukuAsli != null) {
                    Buku bukuKW = bukuAsli.copy();
                    System.out.printf("Buku berhasil disalin: %s\nPenulis: %s\nTahun: %s\nSinopsis: %s", bukuKW.getJudul(), bukuKW.getPenulis()[0].getNama(), bukuKW.getTahun(), bukuKW.getSinopsis());
                } 
                
                else {
                    System.out.println("Buku tidak ditemukan.");
                }
            }
            else {
                System.out.println("Kategori tidak ditemukan.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }
        
    }

    public static void Header() {
        System.out.printf("%-12s%-40s%-13s%s\n", "Kategori", "Judul Buku", "Tahun", "Nama Penulis");
        System.out.println("==========================================================================================");
    }

    public static void printOut(Kategori kategori) {
        for (Buku buku : kategori.getListBuku()) {
            System.out.printf("%-12s%-40s%-13d", kategori.getNama(), buku.getJudul(), buku.getTahun());
            for (Penulis penulis : buku.getPenulis()) {
                System.out.println(penulis.getNama() + " ");
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }
    
}