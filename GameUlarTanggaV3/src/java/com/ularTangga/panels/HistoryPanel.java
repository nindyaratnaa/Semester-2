package com.ularTangga.panels;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import com.ularTangga.utils.FileHandler;


public class HistoryPanel extends JPanel {
    private JTextArea historyArea;
    private JButton kembaliBtn;
    private List<String> history = FileHandler.loadHistory();

    public HistoryPanel(ActionListener kembaliListener) {
        setLayout(new BorderLayout());
        setBackground(new Color(164,180,101));  // Mengatur warna latar
        // Warna default dan hover      
        Color defaultColor = new Color(255, 207, 80);
        Color hoverColor = new Color(255, 222, 120); // warna lebih terang saat hover        

        // Judul
        JLabel titleLabel = new JLabel("Riwayat Pemenang");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22)); // Ukuran dan gaya font 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Area Teks Riwayat
        historyArea = new JTextArea();
        historyArea.setEditable(false);  // Mengatur text area tidak bisa di edit pengguna
        historyArea.setBackground(new Color(254,250,224)); // Mengatur warna latar text area
        historyArea.setFont(new Font("Monospaced", Font.PLAIN, 16)); // Ukuran dan gaya font 
        historyArea.setMargin(new Insets(10, 10, 10, 10)); // Margin text area 

        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.CENTER);

        // Tombol "Kembali"
        kembaliBtn = new JButton("Kembali");
        kembaliBtn.setFont(new Font("Arial", Font.PLAIN, 16));// Ukuran dan gaya font 
        kembaliBtn.setPreferredSize(new Dimension(120, 40)); // Ukuran tombol
        kembaliBtn.setBackground(defaultColor); // Warna latar default
        kembaliBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        kembaliBtn.setFocusPainted(false); // Hilangkan garis fokus jika ingin tampil bersih

        // Efek hover
        kembaliBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kembaliBtn.setBackground(hoverColor); // Saat mouse masuk
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kembaliBtn.setBackground(defaultColor); // Saat mouse keluar
            }
        });
        kembaliBtn.addActionListener(kembaliListener); // Saat tombol diklik → eksekusi listener

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(164,180,101));
        bottomPanel.add(kembaliBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        setHistory(history);
    }

    // Tambahkan entri baru ke riwayat
    // public void addHistory(String entry) {
    //     history.add(entry);
    //     setHistory(history);
    // }

    // Set semua riwayat dari list
    public void setHistory(List<String> historyList) {
        StringBuilder sb = new StringBuilder();
        for (String entry : historyList) {
            sb.append(entry).append("\n");
        }
        historyArea.setText(sb.toString());
    }

    // (Opsional) Tambahkan getter jika ingin akses dari luar
    // public List<String> getHistory() {
    //     return history;
    // }

    public void refreshHistory() {
        this.history = FileHandler.loadHistory();
        setHistory(this.history);
    }
}