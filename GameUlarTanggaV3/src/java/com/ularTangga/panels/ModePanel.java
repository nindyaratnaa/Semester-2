package com.ularTangga.panels;

import javax.swing.*; // Komponen GUI
import java.awt.*;    // Layout dan warna
import java.awt.event.ActionListener; // Untuk aksi tombol

// Kelas ModePanel mewakili halaman pilihan mode permainan
public class ModePanel extends JPanel {

    // Konstruktor menerima dua listener tombol: untuk mode 1 pemain dan 2 pemain
    public ModePanel(ActionListener singlePlayerListener, ActionListener twoPlayerListener) {
        // Susun secara vertikal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(164,180,101)); // Latar belakang abu muda

        // Judul
        JLabel modeLabel = new JLabel("Pilih Mode Permainan");
        modeLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        modeLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Ukuran dan gaya font 
        modeLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0)); // Spasi vertikal

        // Tombol 1 Pemain 
        JButton singleBtn = new JButton("1 Pemain (vs Bot)");
        singleBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        singleBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font 
        singleBtn.setMaximumSize(new Dimension(220, 40)); // Ukuran maksimal tombol
        singleBtn.setBackground(new Color(255,207,80)); // Mengatur warna latar tombol
        singleBtn.addActionListener(singlePlayerListener); // Aksi saat diklik

        // Tombol 2 Pemain 
        JButton twoBtn = new JButton("2 Pemain");
        twoBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        twoBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font 
        twoBtn.setMaximumSize(new Dimension(220, 40)); // Ukuran maksimal tombol
        // twoBtn.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Spasi atas
        twoBtn.setBackground(new Color(255,207,80)); // Mengatur warna latar tombol
        twoBtn.addActionListener(twoPlayerListener); // Aksi saat diklik

        // Tambahkan semua ke panel
        add(modeLabel);
        add(singleBtn);
        add(twoBtn);
    }
}