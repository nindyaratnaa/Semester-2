package com.ularTangga;

import com.ularTangga.panels.*; // Mengimport panel yang akan di gunakan
import com.ularTangga.game.GameLogic; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private GameLogic gameLogic;

    // Inisialisasi panel-panel
    private MenuPanel menuPanel;
    private ModePanel modePanel;
    private SinglePlayerPanel singlePlayerPanel;
    private TwoPlayerPanel twoPlayerPanel;
    private GamePanel gamePanel;
    private HistoryPanel historyPanel;

    public Main() {
        super("Game Ular Tangga");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);

        gameLogic = new GameLogic();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Panel riwayat pemenang (harus dibuat sebelum GamePanel karena dipakai di sana)
        historyPanel = new HistoryPanel(e -> showPage("MENU"));

        // Panel game utama
        gamePanel = new GamePanel(
            e -> System.exit(0),
            e -> {
                historyPanel.refreshHistory(); // Memuat ulang dari file agar tetap update
                showPage("HISTORY");
            },
            e -> {
                gamePanel.getGameLogic().reset();
                showPage("MODE");
            }
        );

        // Menu awal
        menuPanel = new MenuPanel(
            e -> showPage("MODE"),
            e -> {
                historyPanel.refreshHistory(); // Memuat ulang dari file agar tetap update
                showPage("HISTORY");
            }
        );

        // Mode pilih 1p / 2p
        modePanel = new ModePanel(
            e -> showPage("SINGLE_PLAYER"),
            e -> showPage("TWO_PLAYER")
        );

        // Form input untuk single player
        singlePlayerPanel = new SinglePlayerPanel(e -> {
            String playerName = singlePlayerPanel.getNama();
            String levelStr = singlePlayerPanel.getLevel();
            int level = switch (levelStr) {
                case "Sedang" -> 2;
                case "Sulit" -> 3;
                default -> 1;
            };

            if (!playerName.isEmpty()) {
                gameLogic.reset();
                gamePanel.startGame(playerName, "BOT", true, level);
                showPage("GAME");
            } else {
                JOptionPane.showMessageDialog(this, "Nama pemain tidak boleh kosong!");
            }
        });

        // Form input untuk 2 player
        twoPlayerPanel = new TwoPlayerPanel(e -> {
            String player1 = twoPlayerPanel.getNamaPemain1();
            String player2 = twoPlayerPanel.getNamaPemain2();

            if (!player1.isEmpty() && !player2.isEmpty()) {
                gameLogic.reset();
                gamePanel.startGame(player1, player2, false, 0);
                showPage("GAME");
            } else {
                JOptionPane.showMessageDialog(this, "Nama pemain tidak boleh kosong!");
            }
        });

        // Tambahkan semua panel ke CardLayout
        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(modePanel, "MODE");
        mainPanel.add(singlePlayerPanel, "SINGLE_PLAYER");
        mainPanel.add(twoPlayerPanel, "TWO_PLAYER");
        mainPanel.add(gamePanel, "GAME");
        mainPanel.add(historyPanel, "HISTORY");

        add(mainPanel);
        showPage("MENU");
    }

    // Ganti tampilan sesuai nama panel
    private void showPage(String page) {
        cardLayout.show(mainPanel, page);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}