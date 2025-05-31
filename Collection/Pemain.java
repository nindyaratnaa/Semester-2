public class Pemain implements Comparable<Pemain> {
    int tinggi;
    int berat;

    public Pemain(int tinggi, int berat) {
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public int getTinggi() {
        return tinggi;
    }

    public int getBerat() {
        return berat;
    }

    @Override
    public int compareTo(Pemain other) {
        return Integer.compare(this.tinggi, other.tinggi); // default by tinggi
    }

    @Override
    public String toString() {
        return "Tinggi: " + tinggi + ", Berat: " + berat + "";
    }
}
