package com.ularTangga.panels;

import javax.swing.*; // Komponen GUI
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.*;    // Layout dan warna
import java.awt.event.ActionListener; // Untuk aksi tombol

// Kelas ModePanel mewakili halaman pilihan mode permainan
public class ModePanel extends JPanel {

    // Konstruktor menerima dua listener tombol: untuk mode 1 pemain dan 2 pemain
    public ModePanel(ActionListener singlePlayerListener, ActionListener twoPlayerListener) {
        // Susun secara vertikal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(164,180,101)); // Latar belakang abu muda
        // Warna default dan hover      
        Color defaultColor = new Color(255, 207, 80);
        Color hoverColor = new Color(255, 222, 120); // warna lebih terang saat hover

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
        singleBtn.setBackground(defaultColor); // Warna latar default
        singleBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        singleBtn.setFocusPainted(false); // Hilangkan garis fokus jika ingin tampil bersih

        // Efek hover
        singleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                singleBtn.setBackground(hoverColor); // Saat mouse masuk
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                singleBtn.setBackground(defaultColor); // Saat mouse keluar
            }
        });
        singleBtn.addActionListener(singlePlayerListener); // Aksi saat diklik

        // Tombol 2 Pemain 
        JButton twoBtn = new JButton("2 Pemain");
        twoBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        twoBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font 
        twoBtn.setMaximumSize(new Dimension(220, 40)); // Ukuran maksimal tombol
        twoBtn.setBackground(defaultColor); // Warna latar default
        twoBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        twoBtn.setFocusPainted(false); // Hilangkan garis fokus jika ingin tampil bersih

        // Efek hover
        twoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                twoBtn.setBackground(hoverColor); // Saat mouse masuk
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                twoBtn.setBackground(defaultColor); // Saat mouse keluar
            }
        });
        twoBtn.addActionListener(twoPlayerListener); // Aksi saat diklik

        // Tambahkan semua ke panel
        add(modeLabel);
        add(singleBtn);
        add(Box.createVerticalStrut(10));
        add(twoBtn);
    }
}