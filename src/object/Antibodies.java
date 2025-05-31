package object;

import entity.Projectile;
import main.GamePanel;

import java.awt.*;

public class Antibodies extends Projectile {
    GamePanel gamePanel;

    public Antibodies(GamePanel gamePanel) {
        super(gamePanel);
        this.gamePanel = gamePanel;

        collisionArea = new Rectangle(8, 8, 48, 48);

        speed = 15;
        maxHealth = 65;
        health = maxHealth;
        attack = 1;
        isAlive = false;

        getAntibodiesImage();
    }

    public void getAntibodiesImage() {
        side1 = getImage("/projectile/antibodies");
        side2 = getImage("/projectile/antibodies");
    }
}
