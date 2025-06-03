package main;

import entity.*;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    /*
        SCREEN SETTINGS

            These settings define the size of the game window based on a grid of tiles
     */

    final int scale = 1; // scaling factor for lites

    final int originalTileSize = 64; // 64x64 pixels tile
    public final int scaledTileSize = originalTileSize * scale; // scaled tile size (in this situation it stays same 64x64 pixels)

    public final int maxScreenCol = 16; // set how many columns of tiles can be in one window
    public final int maxScreenRow = 12; // set how many rows of tiles can be in one window

    public final int screenWidth = maxScreenCol * scaledTileSize; // calculate max screen width with scaled tiles and column number (1024 pixels)
    public final int screenHeight = maxScreenRow * scaledTileSize; // calculate max screen width with scaled tiles and row number (576 pixels)

    /*
        FPS
     */

    public final int fps = 60;

    public int level = 0;

    /*
        SYSTEM
     */

    KeyHandler keyHandler = new KeyHandler(this);
    Thread gameLoop;
    TileManager tileManager = new TileManager(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public UI ui = new UI(this);
    Sound music = new Sound();
    Sound soundEffect = new Sound();
    AssetSetter assetSetter = new AssetSetter(this);

    /*
        PLAYER AND ENTITY
     */

    public Player player = new Player(this, keyHandler);
    public Tuberculosis[] tuberculosis = new Tuberculosis[10];
    public Cytomegalovirus[] cytomegalovirus = new Cytomegalovirus[10];
    public Lactobacteria[] lactobacteria = new Lactobacteria[10];
    public ArrayList<Projectile> projectiles = new ArrayList<>();
    public Rabies rabies = new Rabies(this);

    /*
        GAME STATES
     */

    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogState = 3;
    public final int defeatState = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setUpGame() {
        assetSetter.setTuberculosis();
        playMusic(0);
        gameState = titleState;
    }

    public void startGameLoop() {
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameLoop != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1) {
                // UPDATE
                update();

                // DRAW
                repaint();

                delta--;
            }
        }
    }

    public void update() {
        if(gameState == playState) {
            music.play();
            player.update();
            if(level == 0) {
                for (int i = 0; i < tuberculosis.length; i++) {
                    if (tuberculosis[i] != null) {
                        tuberculosis[i].update();
                    }
                }
            }

            else if(level == 1) {
                for (int i = 0; i < cytomegalovirus.length; i++) {
                    if (cytomegalovirus[i] != null) {
                        cytomegalovirus[i].update();
                    }
                }
            }

            else if(level == 2) {
                for (int i = 0; i < lactobacteria.length; i++) {
                    if (lactobacteria[i] != null) {
                        lactobacteria[i].update();
                    }
                }
            }
            else if(level == 3) {
                rabies.update();
            }
            for(int i = 0; i < projectiles.size(); i++) {
                if(projectiles.get(i) != null){
                    if(projectiles.get(i).isAlive){
                        projectiles.get(i).update();
                    }
                    if(!projectiles.get(i).isAlive){
                        projectiles.remove(i);
                    }
                }
            }
        }
        if(gameState == pauseState) {
            music.stop();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if(gameState == titleState) {
            ui.draw(g2d);
        }
        else {

            tileManager.draw(g2d);

            player.draw(g2d);

            if(level == 0) {
                for (int i = 0; i < tuberculosis.length; i++) {
                    if (tuberculosis[i] != null) {
                        tuberculosis[i].draw(g2d);
                    }
                }
            }
            else if(level == 1) {
                for (int i = 0; i < cytomegalovirus.length; i++) {
                    if (cytomegalovirus[i] != null) {
                        cytomegalovirus[i].draw(g2d);
                    }
                }
            }
            else if(level == 2) {
                for (int i = 0; i < lactobacteria.length; i++) {
                    if (lactobacteria[i] != null) {
                        lactobacteria[i].draw(g2d);
                    }
                }
            }
            else if(level == 3) {
                rabies.draw(g2d);
            }
            for(int i = 0; i < projectiles.size(); i++) {
                if(projectiles.get(i) != null) {
                    projectiles.get(i).draw(g2d);
                }
            }

            ui.draw(g2d);

        }

        g2d.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);

        music.play();
        music.loop();

    }

    public void stopMusic() {
        music.stop();
    }
    public void playSE(int i) {
        soundEffect.setFile(i);

        soundEffect.play();
    }
}
