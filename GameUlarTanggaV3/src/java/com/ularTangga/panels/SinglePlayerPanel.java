package com.ularTangga.panels;

import javax.swing.*; // Import komponen GUI
import java.awt.*; // Import untuk layout dan warna
import java.awt.event.ActionListener; // Untuk menangani event klik tombol

// Kelas panel untuk mode 1 pemain (melawan bot)
public class SinglePlayerPanel extends JPanel {
    
    private JTextField namaField; // Input untuk nama pemain
    private JComboBox<String> levelBox; // Dropdown pilihan level bot

    // Konstruktor menerima listener untuk tombol lanjut
    public SinglePlayerPanel(ActionListener lanjutListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Layout vertikal
        setBackground(new Color(164,180,101)); // Warna latar

        // Judul Halaman
        JLabel titleLabel = new JLabel("Mode 1 Pemain");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Ukuran dan gaya font 
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0)); // Spasi

        // Label dan Text Field Nama 
        JLabel namaLabel = new JLabel("Masukkan Nama:");
        namaLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        namaLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font 

        namaField = new JTextField();
        namaField.setMaximumSize(new Dimension(250, 30)); // Ukuran field
        namaField.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        namaField.setBackground(new Color(254,250,224)); // Mengatur warna latar text field

        // Label dan ComboBox Level Bot 
        JLabel levelLabel = new JLabel("Pilih Level Bot:");
        levelLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        levelLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font 
        levelLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Spasi atas

        levelBox = new JComboBox<>(new String[]{"Mudah", "Sedang", "Sulit"}); //Pilihan level untuk bot
        levelBox.setMaximumSize(new Dimension(250, 30)); // Ukuran maksimal box
        levelBox.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        levelBox.setBackground(new Color(254,250,224)); // Mengatur warna latar box

        // Tombol "Lanjut"
        JButton lanjutBtn = new JButton("Lanjut");
        lanjutBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font 
        lanjutBtn.setMaximumSize(new Dimension(200, 40)); // Ukuran maksimal tombol
        lanjutBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        lanjutBtn.setBackground(new Color(255,207,80)); // Mengatur warna latar tombol
        lanjutBtn.addActionListener(lanjutListener); // Aksi tombol lanjut

        // Tambahkan semua komponen ke panel
        add(titleLabel);
        add(namaLabel);
        add(namaField);
        add(levelLabel);
        add(levelBox);
        add(lanjutBtn);
    }

    // Getter untuk mengambil nama pemain
    public String getNama() {
        return namaField.getText().trim();
    }

    // Getter untuk mengambil level yang dipilih
    public String getLevel() {
        return (String) levelBox.getSelectedItem();
    }
}