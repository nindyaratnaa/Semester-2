/* I. Buatlah sebuah klas abstract Kue yang memiliki attribut dan method sebagai berikut
        - nama : String
        - harga : double
        + hitungHarga()** : double
        + toString : String (menampilkan nama kue dan harga)
        ** abstract

    II. Buatlah 2 subklas dari klas Kue yaitu
        a. KuePesanan
            - berat : double
            + hitungHarga() : double
              Hitung harga berdasarkan harga x berat
        b. KueJadi
            - jumlah : double
            + hitungHarga() : double
              Hitung harga berdasarkan harga x jumlah x 2

    III. Berdasarkan 2 kelas tersebut, buatlah :
        1. Array yang terdiri dari 20 kue
        2. Isikan 20 objek kue dengan berbagai jenis kue (KuePesanan atau KueJadi)
        3. Dari array tersebut :
            a. Tampilkan semua kue dan harus ditampilkan jenis kuenya
            b. Hitung total harga yang didapat dari semua jenis kue
            c. Hitung total harga dan total berat dari KuePesanan
            d. Hitung total harga dan total jumlah dari KueJadi
            e. Tampilkan informasi kue dengan harga (harga akhir) terbesar */

            package Toko_Kue;
            import java.util.Scanner;
            
            public class MainProgram {
                public static void main(String[] args) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("1. Data kue dari sistem");
                    System.out.println("2. Memasukkan data kue sendiri");
                    System.out.print("Masukkan pilihan anda (1/2): ");
                    int pilihan = input.nextInt(); //Input piilhan pengguna
                    System.out.println();
                    
                    Kue[] daftarKue = new Kue[20]; //Banyak kue 20
                    double totalHargaSeluruh = 0; //Total harga seluruh kue
                    double totalBeratKue = 0; //Total berat dari kue pesanan
                    double totalHargaPesanan = 0; //Total harga kue pesanan
                    double totalJumlahKue = 0; //Total jumlah kue jadi
                    double totalHargaJadi = 0; //Total harga kue jadi
            
                    switch (pilihan) {
                        case 1:
                            //Indeks array di mulai dari 0
                            daftarKue[0] = new KueJadi("Lidah kucing", 40000, 2);
                            daftarKue[1] = new KuePesanan("Lapis legit", 155000, 250);
                            daftarKue[2] = new KueJadi("Nastar nanas", 124000, 1);
                            daftarKue[3] = new KuePesanan("Brwonis kukus", 45000, 150);
                            daftarKue[4] = new KueJadi("Semprit", 35000, 3);
                            daftarKue[5] = new KuePesanan("Bolu gulung", 75000, 75);
                            daftarKue[6] = new KueJadi("Semprong", 25000, 3);
                            daftarKue[7] = new KuePesanan("Spikoe", 65000, 105);
                            daftarKue[8] = new KueJadi("Sagu keju", 65000, 4);
                            daftarKue[9] = new KuePesanan("Pukis", 30000, 15);
                            daftarKue[10] = new KueJadi("Kastengels", 110000, 2);
                            daftarKue[11] = new KuePesanan("Lapis prunes", 35000, 55);
                            daftarKue[12] = new KueJadi("Brownis kering", 25000, 1);
                            daftarKue[13] = new KuePesanan("Nagasari", 25000, 10);
                            daftarKue[14] = new KueJadi("Kembang goyang", 25000, 3);
                            daftarKue[15] = new KuePesanan("Bika ambon", 145000, 45);
                            daftarKue[16] = new KueJadi("Kue salju", 25000, 3);
                            daftarKue[17] = new KuePesanan("Dadae gulung", 15000, 25);
                            daftarKue[18] = new KueJadi("Kue kacang", 55000, 2);
                            daftarKue[19] = new KuePesanan("Cucur", 5000, 20);
                            
                            //Untuk menyimpan kue yang mahal nnt
                            Kue kueMahal = daftarKue[0];
            
                            for (Kue i : daftarKue) {
                                System.out.println(i); //Print daftar kue
                                double harga = i.hitungHarga();
                                totalHargaSeluruh += harga; //Menjumlahkan harga tiap kue
                                
                                if (i.getClass() == KueJadi.class) { //Get class untuk mengambil class dan mencek apakah sama apa tidak
                                    KueJadi j = (KueJadi) i; //Var j isinya i
                                    totalJumlahKue += j.getJumlah(); //Menjumlah semua kue jadi
                                    totalHargaJadi += harga; //Menjumlah harga kue jadi
                                } else if (i.getClass() == KuePesanan.class) { //Get class untuk mengambil class dan mencek apakah sama apa tidak
                                    KuePesanan p = (KuePesanan) i; //Var p isinya i
                                    totalBeratKue += p.getberat(); //Menjumlah berat kue pesanan seluruhnya
                                    totalHargaPesanan += harga; //Menjumlah harga kue pesanan
                                }                        
            
                                if (harga > kueMahal.hitungHarga()) {
                                    kueMahal = i; //Kue mahal akan di gantikan i jika memenuhi syarat
                                }
                            }
                        
                            //Output
                            System.out.printf("\nTotal harga seluruh kue adalah Rp %,.2f", totalHargaSeluruh);
                            System.out.printf("\nTotal harga dan total berat dari KuePesanan Rp %,.2f dan berat %.2f gram", totalHargaPesanan, totalBeratKue);
                            System.out.printf("\nTotal harga dan total jumlah dari KueJadi Rp %,.2f dan %.0f buah", totalHargaJadi, totalJumlahKue);
                            System.out.printf("\nKue dengan harga terbesar adalah: \n%s", kueMahal);
                            input.close();
                            break;
                        
                        case 2:
                                System.out.println("Input data untuk 20 kue");
                                System.out.print("Masukkan harga per kue untuk kue jadi: "); //Informasi dan input harga kue 1 kue jadi
                                double hargaPerKue = input.nextDouble();
                                System.out.print("Masukkan harga per gram untuk kue pesanan: "); //Informasi dan input harga gram kue pesanan
                                double hargaPerGram = input.nextDouble();
                                double harga; //Inisialisasi var
            
                                for (int i = 0; i < daftarKue.length; i++) { //Diulang sepanjang array daftar kue
                                    System.out.println("\nKue ke " + (i + 1)); //Karena di mulai dari 0
                                    System.out.print("1. Kue jadi\n2. Kue pesanan\nPilih jenis kue: ");
                                    int pilihanKue = input.nextInt();
                                    input.nextLine(); //Membersihkan newline
            
                                    System.out.print("Masukkan nama kue: "); //input nama kue
                                    String namaKue = input.nextLine();
            
                                    if (pilihanKue == 1) {
                                        System.out.print("Jumlah kue jadi: ");
                                        double jumlahKueJadi = input.nextDouble();
                                        harga = jumlahKueJadi * hargaPerKue; //Harga perkue di kali banyak kue
                                        daftarKue[i] = new KueJadi(namaKue, harga, jumlahKueJadi); //Membuat object kue jadi
                                    } else if (pilihanKue == 2) {
                                        System.out.print("Berat kue pesanan (gram): ");
                                        double jumlahKuePesanan = input.nextDouble();
                                        harga = hargaPerGram * jumlahKuePesanan; //Harga gram awal di kali gram kue 
                                        daftarKue[i] = new KuePesanan (namaKue, harga, jumlahKuePesanan); //Membuat object kue pesanan
                                    }
                                }
            
                                Kue kueMahal1 = daftarKue[0]; //Untuk menyimpan kue mahal nnti
                                System.out.println(); //Memberi jarak antar output
                                
                                for (Kue i : daftarKue) {
                                    System.out.println(i);
                                    harga = i.hitungHarga();
                                    totalHargaSeluruh += harga;
                            
                                    if (i.getClass() == KueJadi.class) { //Get class untuk mengambil class dan mencek apakah sama apa tidak
                                        KueJadi j = (KueJadi) i; //Var j isinya i
                                        totalJumlahKue += j.getJumlah(); //Menjumlah jumlah kue jadi seluruhnya
                                        totalHargaJadi += harga; //Menjumlah harga kue jadi
                                    } else if (i.getClass() == KuePesanan.class) { //Get class untuk mengambil class dan mencek apakah sama apa tidak
                                        KuePesanan p = (KuePesanan) i; //Var p isinya i
                                        totalBeratKue += p.getberat(); //Menjumlah berat kue pesanan seluruhnya
                                        totalHargaPesanan += harga; //Menjumlah harga kue pesanan
                                    }
                            
                                    if (i.hitungHarga() > kueMahal1.hitungHarga()) {
                                        kueMahal1 = i; //Kue mahal 1 akan di gantikan i jika memenuhi syarat
                                    }
                                }
            
                                //Output
                                System.out.printf("\nTotal harga seluruh kue adalah Rp %,.2f", totalHargaSeluruh);
                                System.out.printf("\nTotal harga dan total berat dari KuePesanan Rp %,.2f dan berat %.2f gram", totalHargaPesanan, totalBeratKue);
                                System.out.printf("\nTotal harga dan total jumlah dari KueJadi Rp %,.2f dan %.0f buah", totalHargaJadi, totalJumlahKue);
                                System.out.printf("\nKue dengan harga terbesar adalah: \n%s", kueMahal1);
                            break;
            
                        default: //Jika input di luar pilihan di sediakan
                            System.out.println("Pilihan tidak valid!");
                            break;
                    }
                }            
            
            }
                        