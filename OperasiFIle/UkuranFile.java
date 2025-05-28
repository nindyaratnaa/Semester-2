import java.io.File;

public class UkuranFile {    
    public static void main(String[] args) {
    File file = new File("D:/Semester 2/Java/Praktikum/OperasiFIle/HasilUjiCoba"); 

        if (file.exists()) {
            long sizeInBytes = file.length();

            if (sizeInBytes < 1024 * 1024) {
                double sizeInKB = sizeInBytes / 1024.0;
                System.out.printf("Ukuran file: %.2f KB%n", sizeInKB);
            } else {
                double sizeInMB = sizeInBytes / (1024.0 * 1024.0);
                System.out.printf("Ukuran file: %.2f MB%n", sizeInMB);
            }
        } else {
            System.out.println("File tidak ditemukan.");
        }
    }
}
