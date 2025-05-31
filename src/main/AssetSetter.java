package main;


import entity.Tuberculosis;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setTuberculosis() {
        gamePanel.tuberculosis[0] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[0].x = gamePanel.scaledTileSize * 4;
        gamePanel.tuberculosis[0].y = -gamePanel.scaledTileSize;
        gamePanel.tuberculosis[0].isFirst = true;

        gamePanel.tuberculosis[1] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[1].x = gamePanel.scaledTileSize * 6;
        gamePanel.tuberculosis[1].y = -gamePanel.scaledTileSize * 4;

        gamePanel.tuberculosis[2] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[2].x = gamePanel.scaledTileSize * 7;
        gamePanel.tuberculosis[2].y = -gamePanel.scaledTileSize;

        gamePanel.tuberculosis[3] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[3].x = gamePanel.scaledTileSize * 9;
        gamePanel.tuberculosis[3].y = -gamePanel.scaledTileSize * 5;

        gamePanel.tuberculosis[4] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[4].x = gamePanel.scaledTileSize * 2;
        gamePanel.tuberculosis[4].y = -gamePanel.scaledTileSize * 5;

        gamePanel.tuberculosis[5] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[5].x = gamePanel.scaledTileSize * 5;
        gamePanel.tuberculosis[5].y = -gamePanel.scaledTileSize * 4;

        gamePanel.tuberculosis[6] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[6].x = gamePanel.scaledTileSize * 10;
        gamePanel.tuberculosis[6].y = -gamePanel.scaledTileSize;

        gamePanel.tuberculosis[7] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[7].x = gamePanel.scaledTileSize * 12;
        gamePanel.tuberculosis[7].y = -gamePanel.scaledTileSize * 2;

        gamePanel.tuberculosis[8] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[8].x = gamePanel.scaledTileSize;
        gamePanel.tuberculosis[8].y = -gamePanel.scaledTileSize * 4;

        gamePanel.tuberculosis[9] = new Tuberculosis(gamePanel);
        gamePanel.tuberculosis[9].x = gamePanel.scaledTileSize * 13;
        gamePanel.tuberculosis[9].y = -gamePanel.scaledTileSize * 5;
    }
}
