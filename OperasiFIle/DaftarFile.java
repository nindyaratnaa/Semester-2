import java.io.File;

public class DaftarFile {
    public static void main(String[] args) {
        File folder = new File("D:/Semester 2/Java/Praktikum/OperasiFIle/HasilUjiCOba"); //Ini haru sesuai path kalo ga gitu gabisa

        if (folder.exists() && folder.isDirectory()) {
            File[] daftarFile = folder.listFiles();

            System.out.println("Daftar file di dalam folder:");

            for (File file : daftarFile) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Folder tidak ditemukan atau bukan direktori.");
        }
    }
}