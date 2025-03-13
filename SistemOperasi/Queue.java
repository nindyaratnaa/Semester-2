package SistemOperasi;

public class Queue {
    private int capacity;
    private int front;
    private int rear;
    private int[] queueArray;
    private int[] processTimes;  //Menyimpan waktu pengerjaan untuk setiap proses
    private int itemCount;

    //Konstruktor untuk inisialisasi antrian dengan kapasitas sesuai input
    public Queue(int size) {
        this.capacity = size;  //Kapasitas dengan inputan
        this.queueArray = new int[capacity];
        this.processTimes = new int[capacity]; //Array untuk menyimpan waktu pengerjaan proses
        this.front = 0;
        this.rear = -1;
        this.itemCount = 0;
    }

    //Menambahkan proses ke dalam antrian dengan waktu pengerjaan
    public void addQueue(int processId, int processTime) {
        if (itemCount == capacity) {
            System.out.println("Antrian penuh! Tidak bisa menambahkan proses.");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = processId; //Menambahkan processId pada array
        processTimes[rear] = processTime; //Menambahkan waktu pengerjaan pada array
        itemCount++;
        System.out.println("Proses " + processId + " dengan waktu pengerjaan " + processTime + " detik ditambahkan ke antrian.");
    }

    //Mengeksekusi proses dari antrian (FIFO)
    public void eksekusiFIFO() {
        if (itemCount == 0) {
            System.out.println("Antrian kosong! Tidak ada proses untuk dieksekusi.");
            return;
        }

        int totalRuntime = 0; //Untuk menghitung total waktu eksekusi
        System.out.println("\nProses sedang dijalankan...");

        //Menjalankan semua proses dalam antrian
        while (itemCount > 0) {
            int processId = queueArray[front];
            int processTime = processTimes[front];
            front = (front + 1) % capacity;
            itemCount--;
            System.out.println("Proses " + processId + " sedang berjalan...");

            //Mensimulasikan proses eksekusi
            long startTime = System.currentTimeMillis();
            long endTime = startTime + (processTime * 1000); 

            while (System.currentTimeMillis() < endTime) {

            }

            System.out.println("Proses " + processId + " selesai.");
            System.out.println("Waktu eksekusi: " + processTime + " detik.\n");
            totalRuntime += processTime;
        }

        System.out.println("\nTotal waktu eksekusi semua proses: " + totalRuntime + " detik.");
    }

    //Mengecek apakah antrian kosong
    public boolean isEmpty() {
        return itemCount == 0;
    }

    //Mengecek apakah antrian penuh
    public boolean isFull() {
        return itemCount == capacity;
    }

    public void printChart() {
        //Menampilkan chart dengan posisi waktu proses
        System.out.println("\nChart");
        int currentTime = 0;
        System.out.printf("%8s", " ");
        for (int i = 0; i < capacity; i++) {
           if (queueArray[i] != 0) {
                System.out.printf("%-15d", queueArray[i]);
                currentTime += processTimes[i];
           }
        }
        System.out.println();

        System.out.printf("%-15d",0); 
        currentTime = 0;
        for (int i = 0; i < capacity; i++) {
            if (queueArray[i] != 0) {
                currentTime += processTimes[i];
                System.out.printf("%-15d", currentTime);
            }
        }
        System.out.println();
    }
}
