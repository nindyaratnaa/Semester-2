
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Data pemain tim A urut
        ArrayList<Pemain> TimA = new ArrayList<>(Arrays.asList(
            new Pemain(168, 50),
            new Pemain(170, 60),
            new Pemain(165, 56),
            new Pemain(168, 55),
            new Pemain(172, 60),
            new Pemain(170, 70),
            new Pemain(169, 66),
            new Pemain(165, 56),
            new Pemain(171, 72),
            new Pemain(166, 56)
        ));

        //Data pemain tim B urut
        ArrayList<Pemain> TimB = new ArrayList<>(Arrays.asList(
            new Pemain(170, 66),
            new Pemain(167, 60), 
            new Pemain(165, 59),
            new Pemain(166, 58),
            new Pemain(168, 58),
            new Pemain(175, 71),
            new Pemain(172, 68),
            new Pemain(171, 68),
            new Pemain(168, 65),
            new Pemain(169, 60)
        ));

        //Masukkan opsi inputan ataupun perintah yang ingin di lakukan
        System.out.println("Berikut opsi yang dapat anda lakukan");
        System.out.println("1. Jawaban soal no 1");
        System.out.println("2. Jawaban soal no 2");
        System.out.println("0. Keluar dari program");        
        
        while (true) {
            System.out.print("\nMasukkan pilihan anda (1/2): ");
            int opsi = input.nextInt();
            
            switch (opsi) {
                case 1:
                    System.out.println();
                    //List tinggi pemain secara ascending
                    System.out.println("Berikut merupakan jawaban dari soal pertama");    
                    System.out.println("a. Berdasarkan tinggi badan secara ascending dan decsending");
                    List<Pemain> sortTinggiAsc = new ArrayList<>();
                    sortTinggiAsc.addAll(TimA); //Menambahkan seluruh Tim A ke dalam array list tinggi baru untuk di jadikan satu dengan B
                    sortTinggiAsc.addAll(TimB); //Menambahkan seluruh Tim B ke dalam array list tinggi baru untuk di jadikan satu dengan A
                    Collections.sort(sortTinggiAsc); //Mengurutkan array list yang baru secara ascending
                    System.out.println("   Secara ascending:");
                    for (Pemain i : sortTinggiAsc) { //Looping hingga akhir array
                        System.out.println("     " + i);
                    }
                    
                    //List tinggi pemain secara descending
                    List<Pemain> sortTinggiDesc = new ArrayList<>(sortTinggiAsc);
                    Collections.reverse(sortTinggiDesc); //Membalik urutan array yang ascending menjadi descending
                    System.out.println("   Secara descending:");
                    for (Pemain i : sortTinggiDesc) { //Looping hingga akhir array
                        System.out.println("     " + i);
                    }
                    
                    System.out.println("b. Berdasarkan berat badan secara ascending dan decsending");
                    //List berat pemain secara ascending
                    List<Pemain> sortBeratAsc = new ArrayList<>();
                    sortBeratAsc.addAll(TimA); //Menambahkan seluruh Tim A ke dalam array list berat baru untuk di jadikan satu dengan B
                    sortBeratAsc.addAll(TimB); //Menambahkan seluruh Tim B ke dalam array list berat baru untuk di jadikan satu dengan A
                    Collections.sort(sortBeratAsc); //Mengurutkan array list yang baru secara ascending
                    System.out.println("   Secara ascending:");
                    for (Pemain i : sortBeratAsc) { //Looping hingga akhir array
                        System.out.println("     " + i);
                    }
                    
                    //List tinggi pemain secara descending
                    List<Pemain> sortBeratDesc = new ArrayList<>(sortBeratAsc);
                    Collections.reverse(sortBeratDesc); //Membalik urutan array yang ascending menjadi descending
                    System.out.println("   Secara descending:");
                    for (Pemain i : sortBeratDesc) { //Looping hingga akhir array
                        System.out.println("     " + i);
                    }
                    
                    System.out.println("c. Berdasarkan berat badan secara ascending dan decsending");
                    //Nilai maksimal dan minimal masing-masing tim
                    System.out.println("   Nilai minimal & maksimal Tim A:");
                    getMinMax(TimA);
                    
                    System.out.println("   Nilai minimal & maksimal Tim B:");
                    getMinMax(TimB);
                    
                    //Copy nilai Tim B ke TIm C
                    List<Pemain> TimC = new ArrayList<>(Collections.nCopies(TimB.size(), new Pemain(0, 0)));
                    Collections.copy(TimC, TimB);
                    System.out.println("d. Tim C merupakan duplikat dari Tim B:");
                    for (Pemain i : TimC) { //Looping hingga akhir array
                        System.out.println("     " + i);
                    }   

                break;
                    
                case 2:
                    System.out.println("b. Apakah ada yang memiliki tinggi tertentu di tim");
                    //Memanggil method untuk memastikan jumlah dari suatu nilai
                    System.out.println("   Tinggi 168 di Tim B: " + countByTinggi(TimB, 168));
                    System.out.println("   Tinggi 160 di Tim B: " + countByTinggi(TimB, 160));

                    System.out.println("c. Apakah ada yang memiliki tinggi tertentu di tim");
                    //Memanggil method untuk memastikan jumlah dari suatu nilai
                    System.out.println("   Berat 56 di Tim A: " + countByBerat(TimA, 56));
                    System.out.println("   Berat 53 di Tim A: " + countByBerat(TimA, 53));

                    //Apakah ada tinggi atau berat yang sama antara Tim A dan Tim B?
                    System.out.println("d. Apakah ada yang memiliki tinggi tertentu di tim");
                    Set<Integer> tinggiA = new HashSet<>(); //Untuk menyimpan tinggi Tim A
                    Set<Integer> beratA = new HashSet<>(); //Untuk menyimpan berat Tim A
                    for (Pemain p : TimA) {
                        tinggiA.add(p.getTinggi()); //Mengisi tinggi dan berat dengan data dari Tim A
                        beratA.add(p.getBerat());
                    }

                    boolean samaTinggi = false, samaBerat = false;
                    for (Pemain p : TimB) {
                        if (tinggiA.contains(p.getTinggi())) samaTinggi = true; //Jika get p pada Tim B ada yang cocok dengan tinggiA berarti ada yang sama
                        if (beratA.contains(p.getBerat())) samaBerat = true; //Jika get p pada Tim B ada yang cocok dengan beratA berarti ada yang sama
                    }

                    System.out.println("   Ada tinggi yang sama? " + (samaTinggi ? "Ya" : "Tidak"));
                    System.out.println("   Ada berat yang sama? " + (samaBerat ? "Ya" : "Tidak"));
                break;
                
                case 0:
                    System.out.println("Keluar dari program.");
                    System.exit(0); //Keluar atau end program
                    input.close();                    
                break;

                default:
                    System.out.println("Pilihan anda tidak valid, silahkan masukkan jawaban lain.");
                break;
            }
            
        }
    }
    
    static void getMinMax(List<Pemain> tim) {
        Pemain minTinggi = Collections.min(tim, Comparator.comparingInt(Pemain::getTinggi)); //Mencari nilai minimal dari tinggi berdasar daftar pemain dengan membandingkan tinggi dengan tinggi
        Pemain maxTinggi = Collections.max(tim, Comparator.comparingInt(Pemain::getTinggi)); //Mencari nilai maksimal dari tinggi berdasar daftar pemain dengan membandingkan tinggi dengan tinggi
        Pemain minBerat = Collections.min(tim, Comparator.comparingInt(Pemain::getBerat)); //Mencari nilai minimal dari berat berdasar daftar pemain dengan membandingkan berat dengan berat
        Pemain maxBerat = Collections.max(tim, Comparator.comparingInt(Pemain::getBerat)); //Mencari nilai maksimal dari berat berdasar daftar pemain dengan membandingkan berat dengan berat

        //Output nilai maksimal dan minimal
        System.out.println("     Tinggi Minimal: " + minTinggi.getTinggi());
        System.out.println("     Tinggi Maximal: " + maxTinggi.getTinggi());
        System.out.println("     Berat Minimal : " + minBerat.getBerat());
        System.out.println("     Berat Maximal : " + maxBerat.getBerat());
    }

    //Method untuk mencari banyak nilai dari suatu nilai (mencari jumlah tinggi pada tinggi tersebut)
    static int countByTinggi(List<Pemain> list, int tinggi) {
        int count = 0;
        for (Pemain p : list) { //Loop hingga setiap pemain dalam tim
            if (p.getTinggi() == tinggi) { //Membandingkan tinggi pada list dengan yang di bandingkan
                count++;
            }
        }
        return count;
    }

    //Method untuk mencari banyak nilai dari suatu nilai (mencari jumlah berat pada berat tersebut)
    static int countByBerat(List<Pemain> list, int berat) {
        int count = 0;
        for (Pemain p : list) { //Loop hingga setiap pemain dalam tim
            if (p.getBerat() == berat) { //Membandingkan berat pada list dengan yang di bandingkan
                count++;
            }
        }
        return count;
    }
}