package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {
    GamePanel gamePanel;

    public int x, y;
    public int speed;

    public BufferedImage side1, side2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle collisionArea = new Rectangle(16, 16, 32, 32);
    public boolean collision = false;

    String[] dialogues = new String[128];
    int dialogueIndex = 0;

    public int maxHealth;
    public Entity user;
    public int health;
    public int attack;
    public boolean isAlive = true;
    public boolean isFirst = false;
    public Projectile projectile;

    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public BufferedImage getImage(String url) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(url + ".png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return image;
    }

    public void draw(Graphics2D g2d) {
        if (isAlive) {
            BufferedImage bufferedImage = null;

            switch (direction) {
                case "right":
                    if (spriteNum == 1) {
                        bufferedImage = side1;
                    }
                    if (spriteNum == 2) {
                        bufferedImage = side2;
                    }
                    break;
                case "left", "up":
                    if (spriteNum == 1) {
                        bufferedImage = side2;
                    }
                    if (spriteNum == 2) {
                        bufferedImage = side1;
                    }
                    break;
            }

            g2d.drawImage(bufferedImage, x, y, gamePanel.scaledTileSize, gamePanel.scaledTileSize, null);
        }
    }
    public void speak() {

    }
}
