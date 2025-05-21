import java.io.File;

public class HapusFile {
 public static void main(String[] args) {
        File folder = new File("D:/Semester 2/Java/Praktikum/OperasiFIle/HasilUjiCOba"); //Harus sesuai path nyaa jangan salah hapus
        if (folder.exists() && folder.isDirectory()) {
            File[] fileDiDalam = folder.listFiles();

            //Hapus semua file di dalam folder
            for (File file : fileDiDalam) {
                if (file.isFile()) {
                    file.delete();
                }
            }

            // Hapus folder-nya
            if (folder.delete()) {
                System.out.println("Folder dan semua file di dalamnya berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus folder.");
            }
        } else {
            System.out.println("Folder tidak ditemukan atau bukan direktori.");
        }
    }
}