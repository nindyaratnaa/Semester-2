package com.ularTangga.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BoardPanel extends JPanel {
    private JLabel[] cells = new JLabel[100];  // 100 kotak papan
    private BufferedImage snakeLadderImage;

    public BoardPanel() {
        setLayout(new GridLayout(10, 10)); // Mengatur ukuran grid papan permainan
        setPreferredSize(new Dimension(600, 600)); // Ukuran papan permainan

        // Load gambar ular dan tangga
        try {
            snakeLadderImage = ImageIO.read(new File("src/resources/images/BoardGame.png"));
        } catch (IOException e) {
            e.printStackTrace();
            // Kalau gagal load, snakeLadderImage jadi null
        }

        // Menulis angka pada grid dari kiri ke kanan 
        boolean leftToRight;
        for (int row = 9; row >= 0; row--) {
            leftToRight = ((10 - row) % 2 == 0);
            if (leftToRight) {
                for (int col = 0; col < 10; col++) {
                    int cellNum = row * 10 + col + 1;
                    JLabel cell = createCell(cellNum);
                    cells[cellNum - 1] = cell;
                    add(cell);
                }
            } else {
                for (int col = 9; col >= 0; col--) {
                    int cellNum = row * 10 + col + 1;
                    JLabel cell = createCell(cellNum);
                    cells[cellNum - 1] = cell;
                    add(cell);
                }
            }
        }
    }

    private JLabel createCell(int cellNum) {
        JLabel cell = new JLabel(String.valueOf(cellNum), SwingConstants.CENTER);
        cell.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Gaya border
        cell.setOpaque(false);
        cell.setFont(new Font("Arial", Font.BOLD, 14)); // Ukuran dan gaya font 
        return cell;
    }

    // Gambar background ular dan tangga di panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (snakeLadderImage != null) {
            // Gambar gambar agar memenuhi panel (skalakan)
            g.drawImage(snakeLadderImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Method untuk mengubah warna posisi pemain
    public void highlightPosition(int pos, Color color) {
        if (pos < 1 || pos > 100) return;
        cells[pos - 1].setOpaque(true);
        cells[pos - 1].setBackground(color);
        cells[pos - 1].repaint();
    }

    // Reset semua kotak jadi putih
    public void resetBoard() {
        for (JLabel cell : cells) {
            cell.setOpaque(false);
            // cell.setBackground(new Color(255, 255, 255, 50));  // putih semi transparan
            cell.repaint();
        }
    }
}
