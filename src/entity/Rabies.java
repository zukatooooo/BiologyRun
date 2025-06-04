package entity;

import main.GamePanel;

import java.awt.*;

public class Rabies extends Entity{
    public Rabies(GamePanel gamePanel) {
        super(gamePanel);

        direction = "none";
        maxHealth = 150;
        health = maxHealth;
        attack = 2;

        collisionArea = new Rectangle(0, 0, gamePanel.scaledTileSize * 3, gamePanel.scaledTileSize);

        getRabiesImage();

        gamePanel.player.speak();
    }

    public void getRabiesImage() {
        side1 = getImage("/rabies/Rabies");
    }

    public void update() {

    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(side1, (gamePanel.screenWidth - (gamePanel.scaledTileSize * 3)) / 2, gamePanel.scaledTileSize, gamePanel.scaledTileSize * 3, gamePanel.scaledTileSize * 3, null);
    }
}
