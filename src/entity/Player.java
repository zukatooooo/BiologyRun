package entity;

import main.GamePanel;
import main.KeyHandler;
import object.Antibodies;

import java.awt.*;

public class Player extends Entity {
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(gamePanel);
        this.keyHandler = keyHandler;

        setDefValues();
        getPlayerImage();
        setDialogues();
    }

    public void setDefValues()  {
        x = (gamePanel.screenWidth - gamePanel.scaledTileSize) / 2 ;
        y = gamePanel.screenHeight - gamePanel.scaledTileSize;

        collisionArea = new Rectangle(24, 24, 16, 16);

        speed = 6;
        direction = "right";
        projectile = new Antibodies(gamePanel);
    }

    public void getPlayerImage() {
        side1 = getImage("/player/player1");
        side2 = getImage("/player/player2");
    }

    public void setDialogues() {
        dialogues[0] = "გამარჯობა!";
        dialogues[1] = "მე ვარ დახვეწილი იმუნური სისტემის რობოტი, რომლის დავალებაცაა\n" +
                        "გაანადგუროს ამ ორგანიზმში ყველაფერი მავნე.";
        dialogues[2] = "შენ შეგიძლია უბრალოდ დიმ დამიძახო.";
        dialogues[3] = "მე მჭირდება შენი დახმარება, რომ დავეხმარო ამ ორგანიზმს.";
        dialogues[4] = "კაია! ჩვენი პირველი დანიშნულების ადგილია ფილტვები.";

        dialogues[6] = "ესენი არიან ტუბერკულოზის ბაქტერიაბი.\n\n" +
                        "საზიზღრები არიან. ისინი იმალებიან მაკროფაგების შიგნით და\n" +
                        "მასპინძელ უჯრედში წლები უჩინრად ცხოვრობენ.\n\n" +
                        "შეიზლება გაგიჩდეს კითხვა თუ რატომ არ გაუმკლავდა\n" +
                        "მათ იმუნური სისტემა?";
        dialogues[7] = "ყველაფერი ერთი მარტივი მიზეზის გამო.\n\n" +
                        "ამ ბაქტერიებს განსაკუთრებული უჯრედის კედელი აქვთ სქელი და ცხიმოვანი\n" +
                        "მათ არ ეშინიათ მჟავების და არ იშლებიან მარტივად.\n\n" +
                        "ზუსტად ამის გამო მათ შეუძლიათ წლების განმავლობაშ შეუმჩნებლად ცხოვრება\n" +
                        "და ნებისმიერ მომენტიში გამოვლინება.";
    }

    public void update() {
        if (keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.rightPressed) {
                direction = "right";
            } else {
                direction = "left";
            }

            /*
                CHECK COLLISION
             */
            collision = false;
            gamePanel.collisionChecker.checkTile(this);

            if (!collision) {
                switch (direction) {
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
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
        if(keyHandler.shootKeyPressed && !projectile.isAlive) {
            projectile.set(x, y, "up", true, this);

            gamePanel.projectiles.add(projectile);
        }
    }

    public void speak() {
        if (dialogueIndex != 5 && dialogueIndex != 8) {
            gamePanel.ui.currentDialog = dialogues[dialogueIndex];
            dialogueIndex++;
        } else {
            dialogueIndex++;
            gamePanel.ui.currentDialog = dialogues[dialogueIndex];
            gamePanel.gameState = gamePanel.playState;
        }
    }
}
