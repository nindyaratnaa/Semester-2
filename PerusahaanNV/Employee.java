package PerusahaanNV;

public class Employee implements Payable {
    private int registrationNumber; //Nomor registrasi karyawan
    private String name;            //Nama karyawan
    private int salaryPerMonth;     //Gaji bulanan
    private Invoice[] invoices;     //Daftar invoice belanjaan karyawan

    //Konstruktor
    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    //Mengimplementasikan method dari interface Payable. Menghitung total gaji bersih setelah dikurangi total belanja.
    @Override
    public int getPayableAmount() {
        int totalInvoice = 0;
        for (Invoice invoice : invoices) {
            totalInvoice += invoice.getPayableAmount();
        }
        return salaryPerMonth - totalInvoice;
    }

    //Mengoverride toString() untuk menampilkan struk belanja dalam format rapi (mirip tabel).
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("========================================================\n");
        out.append("               Struk Belanja Koperasi\n");
        out.append("========================================================\n");
        out.append(String.format("Nama Karyawan   : %s\n", name));
        out.append(String.format("No Registrasi   : %d\n", registrationNumber));
        out.append(String.format("Gaji Bulanan    : Rp %,.0f\n", (double)salaryPerMonth));
        out.append("--------------------------------------------------------\n");
        out.append(String.format("%-19s %-11s %-13s %-10s\n", "Produk", "Jumlah", "Harga", "Total"));
        out.append("--------------------------------------------------------\n");

        int totalInvoice = 0;
        for (Invoice invoice : invoices) {
            out.append(invoice.toString()).append("\n"); //Memanggil toString dari setiap invoice
            totalInvoice += invoice.getPayableAmount();  //Menjumlah total belanja
        }

        out.append("--------------------------------------------------------\n");
        out.append(String.format("Total belanja                           Rp %,13.0f\n", (double)totalInvoice));
        out.append(String.format("Gaji Setelah Potong Belanja             Rp %,13.0f\n", (double)getPayableAmount()));
        return out.toString();
    }
}