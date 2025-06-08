package com.ularTangga.panels;

import javax.swing.*; // Untuk komponen GUI seperti JPanel, JLabel, JTextField
import java.awt.*; // Untuk layout dan warna
import java.awt.event.ActionListener; // Untuk aksi tombol

// Panel untuk mode 2 pemain (user vs user)
public class TwoPlayerPanel extends JPanel {

    private JTextField nama1Field; // Input nama pemain 1
    private JTextField nama2Field; // Input nama pemain 2

    // Konstruktor menerima listener untuk tombol lanjut
    public TwoPlayerPanel(ActionListener lanjutListener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Komponen ditumpuk vertikal
        setBackground(new Color(164,180,101)); // Warna latar

        // Judul Panel
        JLabel titleLabel = new JLabel("Mode 2 Pemain");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Ukuran dan gaya font 
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        // Input Nama Pemain 1 
        JLabel nama1Label = new JLabel("Nama Pemain 1:");
        nama1Label.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        nama1Label.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font 

        nama1Field = new JTextField();
        nama1Field.setMaximumSize(new Dimension(250, 30)); // Ukuran maksimal text field
        nama1Field.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        nama1Field.setBackground(new Color(254,250,224)); // Mengatur warna latar text field

        // Input Nama Pemain 2 
        JLabel nama2Label = new JLabel("Nama Pemain 2:");
        nama2Label.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        nama2Label.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font 
        nama2Label.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Spasi atas

        nama2Field = new JTextField();
        nama2Field.setMaximumSize(new Dimension(250, 30)); // Ukuran maksimal text field
        nama2Field.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        nama2Field.setBackground(new Color(254,250,224)); // Mengatur warna latar text field

        // Tombol Lanjut 
        JButton lanjutBtn = new JButton("Lanjut");
        lanjutBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font 
        lanjutBtn.setMaximumSize(new Dimension(200, 40));  // Ukuran maksimal tombol
        lanjutBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        lanjutBtn.setBackground(new Color(255,207,80)); // Mengatur warna latar tombol
        lanjutBtn.addActionListener(lanjutListener); // Aksi saat tombol ditekan

        // Tambahkan semua ke panel
        add(titleLabel);
        add(nama1Label);
        add(nama1Field);
        add(nama2Label);
        add(nama2Field);
        add(lanjutBtn);
    }

    // Getter untuk nama pemain 1
    public String getNamaPemain1() {
        return nama1Field.getText().trim();
    }

    // Getter untuk nama pemain 2
    public String getNamaPemain2() {
        return nama2Field.getText().trim();
    }
}