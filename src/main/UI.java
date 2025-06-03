package main;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gamePanel;
    Graphics2D g2d;
    Font title, main, subtext;
    public String currentDialog = "";
    public int commandNum = 0;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        InputStream inputStream1 = getClass().getResourceAsStream("/font/MkhedruliGrungeRegular-5yP4v.ttf");
        InputStream inputStream2 = getClass().getResourceAsStream("/font/CheezySnackDEMO-Regular.ttf");

        try {
            main = Font.createFont(Font.TRUETYPE_FONT, inputStream1);
            title = Font.createFont(Font.TRUETYPE_FONT, inputStream2);
        }
        catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2d) {
        this.g2d = g2d;

        g2d.setFont(main);
        g2d.setColor(Color.WHITE);

        if(gamePanel.gameState == gamePanel.titleState) {
            drawTitleScreen();
        }
        if(gamePanel.gameState == gamePanel.playState) {

        }
        if(gamePanel.gameState == gamePanel.pauseState) {
            drawPauseScreen();
        }
        if(gamePanel.gameState == gamePanel.dialogState) {
            drawDialogScreen();
        }
    }

    public void drawPauseScreen() {
        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 60F));
        String text = "Game Paused";

        int x = getXCenteredText(text);
        int y = gamePanel.scaledTileSize * 4;

        g2d.drawString(text, x, y);

        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 40F));

        text = "Resume Game";
        x = getXCenteredText(text);
        y += gamePanel.scaledTileSize * 2;

        if(commandNum == 0){
            g2d.drawString(">", x - (gamePanel.scaledTileSize / 2), y - 5);
        }

        g2d.drawString(text, x, y);

        text = "Back To Title Screen";
        x = getXCenteredText(text);
        y += gamePanel.scaledTileSize;

        if(commandNum == 1){
            g2d.drawString(">", x - (gamePanel.scaledTileSize / 2), y - 5);
        }

        g2d.drawString(text, x, y);
    }

    public int getXCenteredText(String text) {
        int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
        int x = (gamePanel.screenWidth - length) / 2;

        return x;
    }

    public void drawDialogScreen() {
        int x = gamePanel.scaledTileSize;
        int y = gamePanel.scaledTileSize * 7;
        int width = gamePanel.scaledTileSize * 14;
        int height = gamePanel.scaledTileSize * 4;

        drawSubWindow(x, y, width, height);

        x += gamePanel.scaledTileSize / 2;
        y += (gamePanel.scaledTileSize / 2) + 10;

        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 26F));

        if (currentDialog != null) {
            for (String line : currentDialog.split("\n")) {
                g2d.drawString(line, x, y);
                y += gamePanel.scaledTileSize / 2;
            }
        }
        else {
            gamePanel.gameState = gamePanel.playState;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 200);

        g2d.setColor(c);
        g2d.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);

        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawTitleScreen() {
        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "Biology Run";

        int x = getXCenteredText(text);
        int y = gamePanel.scaledTileSize * 3;

        g2d.setColor(Color.GRAY);
        g2d.drawString(text, x + 3, y + 3);

        g2d.setColor(Color.WHITE);
        g2d.drawString(text, x, y);

        x = (gamePanel.screenWidth - (gamePanel.scaledTileSize * 2)) / 2;
        y = gamePanel.scaledTileSize * 4;

        g2d.drawImage(gamePanel.player.side1, x, y, gamePanel.scaledTileSize * 2, gamePanel.scaledTileSize * 2, null);

        g2d.setFont(g2d.getFont().deriveFont(Font.PLAIN, 50F));

        text = "Start Game";
        x = getXCenteredText(text);
        y += gamePanel.scaledTileSize * 3;

        if(commandNum == 0){
            g2d.drawString(">", x - (gamePanel.scaledTileSize / 2), y - 5);
        }

        g2d.drawString(text, x, y);

        text = "Tutorial";
        x = getXCenteredText(text);
        y += gamePanel.scaledTileSize;

        if(commandNum == 1){
            g2d.drawString(">", x - (gamePanel.scaledTileSize / 2), y - 5);
        }

        g2d.drawString(text, x, y);

        text = "Quit Game";
        x = getXCenteredText(text);
        y += gamePanel.scaledTileSize;

        if(commandNum == 2){
            g2d.drawString(">", x - (gamePanel.scaledTileSize / 2), y - 5);
        }

        g2d.drawString(text, x, y);
    }
}
