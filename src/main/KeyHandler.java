package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gamePanel;
    public boolean leftPressed, rightPressed, shootKeyPressed;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(gamePanel.gameState == gamePanel.dialogState) {
            if(code == KeyEvent.VK_ENTER) {
                gamePanel.player.speak();
            }
        }

        else if(gamePanel.gameState == gamePanel.titleState) {
            if(code == KeyEvent.VK_UP && gamePanel.ui.commandNum > 0) {
                gamePanel.ui.commandNum--;
            }
            if(code == KeyEvent.VK_DOWN && gamePanel.ui.commandNum < 2) {
                gamePanel.ui.commandNum++;
            }
            if(code == KeyEvent.VK_ENTER) {
                switch (gamePanel.ui.commandNum) {
                    case 0:
                        gamePanel.gameState = gamePanel.dialogState;
                        gamePanel.player.speak();
                        gamePanel.music.stop();
                        gamePanel.playMusic(1);
                        break;
                    case 1:
                        gamePanel.ui.commandNum = 0;
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }
            }
        }

        else if(gamePanel.gameState == gamePanel.pauseState) {
            if(code == KeyEvent.VK_UP && gamePanel.ui.commandNum > 0) {
                gamePanel.ui.commandNum--;
            }
            if(code == KeyEvent.VK_DOWN && gamePanel.ui.commandNum < 2) {
                gamePanel.ui.commandNum++;
            }
            if(code == KeyEvent.VK_ENTER) {
                switch (gamePanel.ui.commandNum) {
                    case 0:
                        gamePanel.gameState = gamePanel.playState;
                        break;
                    case 1:
                        gamePanel.ui.commandNum = 0;
                        gamePanel.gameState = gamePanel.titleState;
                        gamePanel.music.stop();
                        gamePanel.playMusic(0);
                        break;
                }
            }
        }

        else if(gamePanel.gameState == gamePanel.playState) {

            if(code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }

            if(code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }

            if(code == KeyEvent.VK_SPACE) {
                shootKeyPressed = true;
            }
        }

        if(code == KeyEvent.VK_ESCAPE) {
            if(gamePanel.gameState == gamePanel.playState) {
                gamePanel.gameState = gamePanel.pauseState;
            }
            else if(gamePanel.gameState == gamePanel.pauseState) {
                gamePanel.gameState = gamePanel.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if(code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        if(code == KeyEvent.VK_SPACE) {
            shootKeyPressed = false;
        }
    }
}
