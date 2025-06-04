package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Biology Run");

        window.setResizable(false);
        window.setIconImage(ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("/player/player1.png"))));

        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameLoop();
    }
}