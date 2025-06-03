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
                        "შეიძლება გაგიჩდეს კითხვა თუ, რატომ არ გაუმკლავდა\n" +
                        "მათ იმუნური სისტემა?";
        dialogues[7] = "ყველაფერი ერთი მარტივი მიზეზის გამო.\n\n" +
                        "ამ ბაქტერიებს განსაკუთრებული უჯრედის კედელი აქვთ: სქელი და ცხიმოვანი\n" +
                        "მათ არ ეშინიათ მჟავების და არ იშლებიან მარტივად.\n\n" +
                        "ზუსტად ამის გამო მათ შეუძლიათ წლების განმავლობაშ შეუმჩნებლად ცხოვრება\n" +
                        "და ნებისმიერ მომენტიში გამოვლინება.";
        dialogues[8] = "ტუბერკულოზის ბაქტერიები არიან აერობები. მათ არ შეუძლიათ ჰაერის გარეშე\n" +
                        "ცხოვრება, ზუსტად ამიტომ ისინი ცხოვრობენ ფილტვებში, სადაც ჟანგბადი\n" +
                        "ყოველთვის არის.";
        dialogues[9] = "ორგანიზმშიც ისინი ჰაერის საშუალებით ხვდებიან. საიდანაც, შემდეგ,\n" +
                        "ფილტვებშ გადადიან.\n";
        dialogues[10] = "დავადების სიმპტომები კი უფრო შემაწუხებელია.\n" +
                        "ხველა, სისუსტე, დაბალი სიცხე, ღამით ოფლიანობა, მადის გაქრობა\n";
        dialogues[11] = "გვიანი სიმპტომები კი უფრო საშინელია.\n" +
                        "სისხლიანი ხველა, მკვეთრად წონაშ დაკლება, ტკივილი გულმკერდის არეში\n" +
                        "ფილტვის ქსოვილის გაწყვეტა და ჰაერის უკმარისობა.\n";
        dialogues[12] = "ტუბერკულოზის თავიდნ ასაცილებლად შეგიძლია ვაქცინა გაიკეთო, რომელიც.\n" +
                        "დაგიცავს მისი მძიმე ფორმებისგან.";

        dialogues[14] = "ყოჩაღ მშვენიერი ნამუშევარია.\n" +
                        "შენ შეძელი ტუბერკულოზის ბაქტერიების განადგურება!!!";
        dialogues[15] = "ჩვენი საქმე ფილტვებში დამთავრებულია.";
        dialogues[16] = "ბზზზზზზზზ\n\n" +
                        "~ !@$%!@^!@$^#&#^!@$#! !@$%@1@!$! !@#$! !!!\n\n" +
                        "კაი გასაგებია ახლავე გავემართები მაქეთკენ!";
        dialogues[17] = "ახლა მითხრეს, რომ ეს ორგანიზმი ციტომეგალოვირუსითაც ყოფილა დაავადებული\n" +
                        "და ახლა, როდესაც ორგანიზმი დასუსტებულია მან გამოიჩინა თავი.";
        dialogues[18] = "ვირუსის კორდინატები ჩამიგდეს და მაჩვენებს, რომ ღვიძლში არის \n" +
                        "კონცენტრირებული.\n" +
                        "თუ გვინდა, რომ ამ ორგანიზმს დავეხმაროთ\n" +
                        "მაშინ სწრაფად უნდა დავიძვრად ფილტვებისკენ!";

        dialogues[20] = "აი ეს საძაგელი ვირუსებიც!";
        dialogues[21] = "ეს ვირუსი შედგება დნმ-ისგან, ცილოვანი კაპსიდისგან და ლიპიდური გარსისგან";
        dialogues[22] = "და როცა ორგანიზმში შედის იმალება და მხოლოდ იმუნური სისტემის\n" +
                        "დაქვეითებისას იჩენს თავის. მაგიტომ არ მომწონს ის!";
        dialogues[23] = "ის ვირუსი შეიძლება მრავალი გზით მოხვდეს შენს ორგანიზმში, მაგალითად:\n" +
                        "ნერწყვით, სქესობრივი გზით, დედიდან ნაყოფში და სისხლის გადასხმითაც კი";
        dialogues[24] = "ადრეულ სტადიაზე ციტომეგალოვირუსი გამოიწვევს:\n" +
                        "მაღალ ტემპერატურას, დაღლილობას, ყელისა და კუნტების ტკივილს და\n" +
                        "ლიმფური კვანძების გადიდებას.";

        dialogues[70] = "ebaaaaat";

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

        int nextDialogTime = gamePanel.fps * 20;
        time++;

        if(time > nextDialogTime) {
            gamePanel.player.speak();
            gamePanel.level++;
            time = 0;
        }
    }

    public void speak() {
        gamePanel.gameState = gamePanel.dialogState;

        if (dialogues[dialogueIndex] != null) {
            gamePanel.ui.currentDialog = dialogues[dialogueIndex];
            System.out.println(dialogueIndex);
            dialogueIndex++;
        } else {
            dialogueIndex++;
            gamePanel.gameState = gamePanel.playState;
            gamePanel.ui.currentDialog = dialogues[dialogueIndex];
        }
    }
}
