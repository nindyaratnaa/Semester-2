package com.ularTangga.panels;

import javax.swing.*; // Komponen GUI (JPanel, JButton, JLabel, dll)
// import javax.swing.border.
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.*;    // Warna, layout, font
import java.awt.event.ActionListener; // Untuk menangani aksi tombol

// Kelas MenuPanel merupakan halaman/menu pertama yang muncul
public class MenuPanel extends JPanel {

    // Konstruktor menerima dua listener: satu untuk tombol "Mainkan", satu untuk "Lihat Riwayat"
    public MenuPanel(ActionListener mainkanListener, ActionListener riwayatListener) {
        // Mengatur layout secara vertikal (atas ke bawah)
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Mengatur warna latar panel hijau muda
        setBackground(new Color(164,180,101));
        // Warna default dan hover      
        Color defaultColor = new Color(255, 207, 80);
        Color hoverColor = new Color(255, 222, 120); // warna lebih terang saat hover


        // Label Judul
        JLabel titleLabel = new JLabel("== GAME ULAR TANGGA ==");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Ukuran dan gaya font
        titleLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0)); // Spasi atas & bawah

        // Tombol "Mainkan"
        JButton mainkanBtn = new JButton("Mainkan");
        mainkanBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        mainkanBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        mainkanBtn.setMaximumSize(new Dimension(200, 40)); // Ukuran maksimum tombol
        mainkanBtn.setBackground(defaultColor); // Warna latar default
        mainkanBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        mainkanBtn.setFocusPainted(false); // Hilangkan garis fokus jika ingin tampil bersih

        // Efek hover
        mainkanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainkanBtn.setBackground(hoverColor); // Saat mouse masuk
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainkanBtn.setBackground(defaultColor); // Saat mouse keluar
            }
        });
        mainkanBtn.addActionListener(mainkanListener); // Saat tombol diklik → eksekusi listener

        // Tombol "Lihat Riwayat" 
        JButton riwayatBtn = new JButton("Lihat Riwayat");
        riwayatBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        riwayatBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font
        riwayatBtn.setMaximumSize(new Dimension(200, 40)); // Ukuran maksimum tombol
        riwayatBtn.setBackground(new Color(255,207,80)); // Mengatur warna latar tombol
        riwayatBtn.setBackground(defaultColor); // Warna latar default
        riwayatBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        riwayatBtn.setFocusPainted(false); // Hilangkan garis fokus jika ingin tampil bersih

        // Efek hover
        riwayatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                riwayatBtn.setBackground(hoverColor); // Saat mouse masuk
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                riwayatBtn.setBackground(defaultColor); // Saat mouse keluar
            }
        });
        riwayatBtn.addActionListener(riwayatListener); // Saat tombol diklik → eksekusi listener

        // Menambahkan komponen ke panel, dari atas ke bawah
        add(titleLabel);
        add(mainkanBtn);
        add(Box.createVerticalStrut(10));
        add(riwayatBtn);
    }
}