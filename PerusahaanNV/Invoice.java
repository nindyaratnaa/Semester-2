package PerusahaanNV;

public class Invoice implements Payable {
    private String productName;  //Nama produk/barang
    private int quantity;        //Jumlah barang dibeli
    private int pricePerItem;    //Harga per satuan barang

    //Konstruktor untuk mengisi data invoice
    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    //Getter 
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    //Method dari interface Payable — menghitung total harga (qty x harga satuan)
    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    //Override toString untuk menampilkan invoice dalam bentuk tabel 
    @Override
    public String toString() {
        return String.format("%-8s %15s %,15.0f %,15.0f", productName, quantity, (double)pricePerItem, (double)getPayableAmount());
    }
}
