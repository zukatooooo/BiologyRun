package entity;

import main.GamePanel;

import java.awt.*;

public class Lactobacteria extends Entity{
    public Lactobacteria(GamePanel gamePanel) {
        super(gamePanel);

        direction = "left";
        speed = 4;
        maxHealth = 100;
        health = maxHealth;
        attack = 1;

        collisionArea = new Rectangle(16, 16, 32, 32);

        getLactobacteriaImages();
    }

    public void getLactobacteriaImages() {
        side1 = getImage("/lactobacteria/lactobacteria1");
        side2 = getImage("/lactobacteria/lactobacteria2");
    }

    public void update() {
        y += speed;

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        isAlive = y < gamePanel.screenHeight + gamePanel.scaledTileSize;

        if(health <= 0) {
            isAlive = false;
        }

        if(!isAlive) {
            x = gamePanel.scaledTileSize + (int)(Math.random() * ((gamePanel.scaledTileSize * 14 - gamePanel.scaledTileSize) + 1));
            y = -gamePanel.scaledTileSize + (int)(Math.random() * ((-gamePanel.scaledTileSize * 3 + gamePanel.scaledTileSize) + 1));
            health = maxHealth;
        }
        if(isFirst && gamePanel.lactobacteria[0].y > gamePanel.scaledTileSize) {
            gamePanel.lactobacteria[0].isFirst = false;
            gamePanel.player.speak();
        }
    }
}
