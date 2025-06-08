package com.ularTangga.panels;

// import com.ularTangga.game.GameLogic;
import com.ularTangga.game.*;
import com.ularTangga.utils.FileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.logging.FileHandler;

public class GamePanel extends JPanel {

    // Inisialisasi komponen UI
    private JLabel statusLabel;
    private JButton rollDiceBtn;
    private JButton keluarBtn;
    private JButton riwayatBtn;
    private JButton mainkanLagiBtn;

    // Logika game dan board game
    private GameLogic gameLogic;
    private BoardPanel boardPanel;

    // Mode permainan
    private boolean isSinglePlayer;
    private int level;

    // Konstruktor
    public GamePanel(ActionListener keluarListener,
                     ActionListener riwayatListener,
                     ActionListener mainkanLagiListener) {

        // Inisialisasi logika game    
        gameLogic = new GameLogic();

        setLayout(new BorderLayout());
        setBackground(new Color(164,180,101)); // Mengatur warna latar

        // Panel atas
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(164,180,101)); // Mengatur warna latar panel

        JLabel titleLabel = new JLabel("Permainan Ular Tangga");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Ukuran dan gaya font
        titleLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0)); // Spasi atas & bawah

        statusLabel = new JLabel("Tekan 'Lempar Dadu' untuk mulai");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font
        statusLabel.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0)); // Spasi atas & bawah

        topPanel.add(titleLabel);
        topPanel.add(statusLabel);
        add(topPanel, BorderLayout.NORTH);

        // Panel papan atau tengah
        boardPanel = new BoardPanel();
        add(boardPanel, BorderLayout.CENTER);

        // Panel bawah (tombol)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(164,180,101)); // Mengatur warna latar panel
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        // Tombol "Lempar Dadu"
        rollDiceBtn = new JButton("Lempar Dadu");
        rollDiceBtn.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan gaya font
        rollDiceBtn.setMaximumSize(new Dimension(200, 40)); // Ukuran maksimum tombol
        rollDiceBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        rollDiceBtn.setBackground(new Color(255,207,80)); // Mengatur warna latar tombol
        rollDiceBtn.setEnabled(false);

        // Aksi saat tombol "Lempar Dadu" diklik
        rollDiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pemain pemain = gameLogic.getCurrentPemain(); // Ambil pemain saat imi
                int dice = pemain.lemparDadu(); // Lempar dadu
                JOptionPane.showMessageDialog(GamePanel.this, "Dadu: " + dice); // Menampilkan pesan hasil lempar dadu

                boardPanel.resetBoard(); // Hapus highlight papan
                gameLogic.moveCurrentPlayer(dice); // Gerakkan bidak pemain

                int p1Pos = gameLogic.getPemain1().getPosisi();
                int p2Pos = gameLogic.getPemain2().getPosisi();

                // HIghlight posisi bidak pemain  di board
                boardPanel.resetBoard(); // Reset papan
                if (p1Pos > 0) boardPanel.highlightPosition(p1Pos, Color.BLUE);
                if (p2Pos > 0) boardPanel.highlightPosition(p2Pos, Color.RED);

                // MCek apakah pemain menag
                if (gameLogic.isCurrentPlayerWin()) {
                    String pemenang = pemain.getNama();
                    String lawan = gameLogic.getPemain1() == pemain ? gameLogic.getPemain2().getNama() : gameLogic.getPemain1().getNama();

                    // Penjelasan siapa yang menang
                    String deskripsiMenang;
                    if (isSinglePlayer && pemain.isBot()) {
                        deskripsiMenang = pemenang + " (BOT Level " + level + ") menang melawan " + lawan;
                    } else if (isSinglePlayer) {
                        deskripsiMenang = pemenang + " menang melawan BOT (Level: " + level + ")";
                    } else {
                        deskripsiMenang = pemenang + " menang melawan " + lawan;
                    }

                    // Disimpan ke riwayat
                    FileHandler.saveHistory(deskripsiMenang);
                    // Menampilkan pesan pemenang game
                    JOptionPane.showMessageDialog(GamePanel.this, "Pemenangnya adalah: " + pemenang);

                    gameLogic.reset(); // Resert game
                    boardPanel.resetBoard(); // Reset papan
                    statusLabel.setText("Tekan 'Lempar Dadu' untuk mulai lagi");
                    rollDiceBtn.setEnabled(false);
                    return;
                }

                // Ganti giliran
                gameLogic.switchTurn();
                statusLabel.setText("Giliran " + gameLogic.getCurrentPemain().getNama());

                // Jika giliran single player dan bot
                if (isSinglePlayer && gameLogic.getCurrentPemain().isBot()) {
                    rollDiceBtn.setEnabled(false); // Disable tombol sementara

                    // Delay 1 detik agar terasa seperti bot berpikir
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Pemain bot = gameLogic.getCurrentPemain();
                            int botDice = bot.lemparDadu();
                            JOptionPane.showMessageDialog(GamePanel.this, "BOT melempar dadu: " + botDice);

                            // boardPanel.resetBoard(); //Hapus highlight bidak materi
                            gameLogic.moveCurrentPlayer(botDice);

                            int p1Pos = gameLogic.getPemain1().getPosisi();
                            int p2Pos = gameLogic.getPemain2().getPosisi();

                            // HIghlight posisi bidak pemain  di board
                            boardPanel.resetBoard(); // Reset papan
                            if (p1Pos > 0) boardPanel.highlightPosition(p1Pos, Color.BLUE);
                            if (p2Pos > 0) boardPanel.highlightPosition(p2Pos, Color.RED);
                            // boardPanel.resetBoard(); // Reset papan


                            if (gameLogic.isCurrentPlayerWin()) {
                                String pemenang = bot.getNama();
                                String lawan = gameLogic.getPemain1() == bot ? gameLogic.getPemain2().getNama() : gameLogic.getPemain1().getNama();

                                String deskripsiMenang = pemenang + " (BOT Level " + level + ") menang melawan " + lawan;
                                FileHandler.saveHistory(deskripsiMenang);

                                JOptionPane.showMessageDialog(GamePanel.this, "Pemenangnya adalah: " + pemenang);

                                gameLogic.reset(); // Resert game
                                boardPanel.resetBoard(); // Reset papan
                                statusLabel.setText("Tekan 'Lempar Dadu' untuk mulai lagi");
                                rollDiceBtn.setEnabled(false);
                            } else {
                                gameLogic.switchTurn();
                                statusLabel.setText("Giliran " + gameLogic.getCurrentPemain().getNama());
                                rollDiceBtn.setEnabled(true);
                            }
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });

        // Tombol "Keluar"
        keluarBtn = new JButton("Keluar");
        keluarBtn.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font
        keluarBtn.setMaximumSize(new Dimension(150, 35)); // Ukuran maksimum tombol
        keluarBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        keluarBtn.setBackground(new Color(255,242,142)); // Mengatur warna latar tombol
        keluarBtn.addActionListener(keluarListener); // Saat tombol diklik → eksekusi listener

        // Tombol "Lihat Riwayat"
        riwayatBtn = new JButton("Lihat Riwayat");
        riwayatBtn.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font
        riwayatBtn.setMaximumSize(new Dimension(150, 35)); // Ukuran maksimum tombol
        riwayatBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        riwayatBtn.setBackground(new Color(255,242,142)); // Mengatur warna latar tombol
        riwayatBtn.addActionListener(riwayatListener); // Saat tombol diklik → eksekusi listener

        // Tombol "Mainkan Lagi"
        mainkanLagiBtn = new JButton("Mainkan Lagi");
        mainkanLagiBtn.setFont(new Font("Arial", Font.PLAIN, 16)); // Ukuran dan gaya font
        mainkanLagiBtn.setMaximumSize(new Dimension(150, 35)); // Ukuran maksimum tombol
        mainkanLagiBtn.setAlignmentX(CENTER_ALIGNMENT); // Letakkan di tengah horizontal
        mainkanLagiBtn.setBackground(new Color(255,242,142)); // Mengatur warna latar tombol
        mainkanLagiBtn.addActionListener(mainkanLagiListener); // Saat tombol diklik → eksekusi listener

        // Menambahkan komponen ke panel, dari atas ke bawah
        bottomPanel.add(rollDiceBtn);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(keluarBtn);
        bottomPanel.add(Box.createVerticalStrut(5));
        bottomPanel.add(riwayatBtn);
        bottomPanel.add(Box.createVerticalStrut(5));
        bottomPanel.add(mainkanLagiBtn);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void startGame(String player1, String player2, boolean isSinglePlayer, int level) {
        this.isSinglePlayer = isSinglePlayer;
        this.level = level;

        Pemain p1 = new PemainManusia(player1);
        Pemain p2 = isSinglePlayer ? new PemainBot("BOT", level) : new PemainManusia(player2);

        gameLogic.setPemain(p1, p2);
        gameLogic.reset();
        boardPanel.resetBoard();

        rollDiceBtn.setEnabled(true);
        statusLabel.setText("Giliran " + gameLogic.getCurrentPemain().getNama());
    }

    public void setPlayers(String player1, String player2) {
        Pemain p1 = new PemainManusia(player1);
        Pemain p2 = new PemainManusia(player2);

        gameLogic.setPemain(p1, p2);
        gameLogic.reset();
        boardPanel.resetBoard();

        rollDiceBtn.setEnabled(true);
        statusLabel.setText("Giliran " + gameLogic.getCurrentPemain().getNama());
    }
}