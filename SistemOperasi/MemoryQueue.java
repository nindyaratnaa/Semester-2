/*Sebuah sistem operasi modern menangani manajemen proses dalam antrian memori
menggunakan struktur data queue (FIFO - First In, First Out) untuk menyimpan proses yang
sedang menunggu eksekusi di CPU.

Dalam sistem operasi, proses yang baru masuk akan ditempatkan di antrian memori dan
akan diproses sesuai urutan kedatangannya. Jika CPU sedang sibuk, proses akan menunggu di
antrian sebelum dieksekusi.

Tim pengembang sistem operasi ingin mengimplementasikan antrian memori
menggunakan array dalam Java, agar dapat menyimpan daftar proses dan mengelola
eksekusinya.

Anda diminta untuk mengimplementasikan antrian memori menggunakan array dalam
Java, di mana proses akan ditambahkan ke dalam antrian ketika tiba dan dieksekusi
berdasarkan urutan FIFO. */

package SistemOperasi;

import java.util.Scanner;

public class MemoryQueue {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Masukkan kapasitas queue: ");
            int capacity = input.nextInt();
            Queue processQueue = new Queue(capacity);
    
            //Menambahkan ID proses dan waktu pengerjaan
            for (int i = 0; i < capacity; i++) {
                System.out.print("Masukkan ID proses ke-" + (i + 1) + ": ");
                int processId = input.nextInt();
                System.out.print("Masukkan waktu pengerjaan (dalam detik) untuk proses " + processId + ": ");
                int processTime = input.nextInt();
                processQueue.addQueue(processId, processTime);
            }
    
            //Mengeksekusi semua proses FIFO
            processQueue.eksekusiFIFO();
    
            //Menampilkan chart
            processQueue.printChart();
    
            input.close();
    }
}
