package entity;

import main.GamePanel;

public class Projectile extends Entity {
    public Projectile(GamePanel gamePanel) {
        super(gamePanel);
    }
    public void set(int x, int y, String direction, boolean isAlive, Entity user) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isAlive = isAlive;
        this.user = user;
        this.health = this.maxHealth;

    }
    public void update() {

        if(user == gamePanel.player){
            System.out.println("before hit");
            int tuberculosisIndex = gamePanel.collisionChecker.checkEntity(this, gamePanel.tuberculosis);
            if(tuberculosisIndex != -1) {
                gamePanel.tuberculosis[tuberculosisIndex].health -= attack;
                System.out.println("hit tuber");
            }

        }
        switch(direction) {
            case "up":
                y -= speed;
                break;
            case "down":
                y += speed;
                break;
        }

        health--;
        if(health <= 0) {
            isAlive = false;
        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }
}
