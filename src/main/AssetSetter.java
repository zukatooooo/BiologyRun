package main;


import entity.Cytomegalovirus;
import entity.Lactobacteria;
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

        //cytomegalovirus

        gamePanel.cytomegalovirus[0] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[0].x = gamePanel.scaledTileSize * 4;
        gamePanel.cytomegalovirus[0].y = -gamePanel.scaledTileSize;
        gamePanel.cytomegalovirus[0].isFirst = true;

        gamePanel.cytomegalovirus[1] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[1].x = gamePanel.scaledTileSize * 6;
        gamePanel.cytomegalovirus[1].y = -gamePanel.scaledTileSize * 4;

        gamePanel.cytomegalovirus[2] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[2].x = gamePanel.scaledTileSize * 7;
        gamePanel.cytomegalovirus[2].y = -gamePanel.scaledTileSize;

        gamePanel.cytomegalovirus[3] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[3].x = gamePanel.scaledTileSize * 9;
        gamePanel.cytomegalovirus[3].y = -gamePanel.scaledTileSize * 5;

        gamePanel.cytomegalovirus[4] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[4].x = gamePanel.scaledTileSize * 2;
        gamePanel.cytomegalovirus[4].y = -gamePanel.scaledTileSize * 5;

        gamePanel.cytomegalovirus[5] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[5].x = gamePanel.scaledTileSize * 5;
        gamePanel.cytomegalovirus[5].y = -gamePanel.scaledTileSize * 4;

        gamePanel.cytomegalovirus[6] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[6].x = gamePanel.scaledTileSize * 10;
        gamePanel.cytomegalovirus[6].y = -gamePanel.scaledTileSize;

        gamePanel.cytomegalovirus[7] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[7].x = gamePanel.scaledTileSize * 12;
        gamePanel.cytomegalovirus[7].y = -gamePanel.scaledTileSize * 2;

        gamePanel.cytomegalovirus[8] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[8].x = gamePanel.scaledTileSize;
        gamePanel.cytomegalovirus[8].y = -gamePanel.scaledTileSize * 4;

        gamePanel.cytomegalovirus[9] = new Cytomegalovirus(gamePanel);
        gamePanel.cytomegalovirus[9].x = gamePanel.scaledTileSize * 13;
        gamePanel.cytomegalovirus[9].y = -gamePanel.scaledTileSize * 5;

        //lactobacteria

        gamePanel.lactobacteria[0] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[0].x = gamePanel.scaledTileSize * 4;
        gamePanel.lactobacteria[0].y = -gamePanel.scaledTileSize;
        gamePanel.lactobacteria[0].isFirst = true;

        gamePanel.lactobacteria[1] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[1].x = gamePanel.scaledTileSize * 6;
        gamePanel.lactobacteria[1].y = -gamePanel.scaledTileSize * 4;

        gamePanel.lactobacteria[2] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[2].x = gamePanel.scaledTileSize * 7;
        gamePanel.lactobacteria[2].y = -gamePanel.scaledTileSize;

        gamePanel.lactobacteria[3] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[3].x = gamePanel.scaledTileSize * 9;
        gamePanel.lactobacteria[3].y = -gamePanel.scaledTileSize * 5;

        gamePanel.lactobacteria[4] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[4].x = gamePanel.scaledTileSize * 2;
        gamePanel.lactobacteria[4].y = -gamePanel.scaledTileSize * 5;

        gamePanel.lactobacteria[5] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[5].x = gamePanel.scaledTileSize * 5;
        gamePanel.lactobacteria[5].y = -gamePanel.scaledTileSize * 4;

        gamePanel.lactobacteria[6] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[6].x = gamePanel.scaledTileSize * 10;
        gamePanel.lactobacteria[6].y = -gamePanel.scaledTileSize;

        gamePanel.lactobacteria[7] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[7].x = gamePanel.scaledTileSize * 12;
        gamePanel.lactobacteria[7].y = -gamePanel.scaledTileSize * 2;

        gamePanel.lactobacteria[8] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[8].x = gamePanel.scaledTileSize;
        gamePanel.lactobacteria[8].y = -gamePanel.scaledTileSize * 4;

        gamePanel.lactobacteria[9] = new Lactobacteria(gamePanel);
        gamePanel.lactobacteria[9].x = gamePanel.scaledTileSize * 13;
        gamePanel.lactobacteria[9].y = -gamePanel.scaledTileSize * 5;
    }
}
