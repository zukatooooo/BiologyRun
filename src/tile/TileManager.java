package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tiles;
    public int mapTileNum[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tiles = new Tile[3];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tiles[1] = new Tile();
            tiles[1].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wallRight.png"));
            tiles[1].collision = true;

            tiles[2] = new Tile();
            tiles[2].bufferedImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wallLeft.png"));
            tiles[2].collision = true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/map/map.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
                String line = bufferedReader.readLine();

                while(col < gamePanel.maxScreenCol) {
                    String numbers[]  = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;

                    col++;
                }
                if(col == gamePanel.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
            int tileNum = mapTileNum[col][row];

            g2d.drawImage(tiles[tileNum].bufferedImage, x, y, gamePanel.scaledTileSize, gamePanel.scaledTileSize, null);
            col++;
            x += gamePanel.scaledTileSize;

            if(col == gamePanel.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gamePanel.scaledTileSize;
            }
        }

    }
}
