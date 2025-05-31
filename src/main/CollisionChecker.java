package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
        int entityLeftX = entity.x + entity.collisionArea.x;
        int entityRightX = entity.x + entity.collisionArea.x + entity.collisionArea.width;

        int entityTopY = entity.y + entity.collisionArea.y;
        int entityBottomY = entity.y + entity.collisionArea.y + entity.collisionArea.height;

        int entityLeftCol = entityLeftX / gamePanel.scaledTileSize;
        int entityRightCol = entityRightX / gamePanel.scaledTileSize;

        int entityTopRow = entityTopY / gamePanel.scaledTileSize;
        int entityBottomRow = entityBottomY / gamePanel.scaledTileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gamePanel.scaledTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision) {
                    entity.collision = true;
                }
                break;
            case "down":
                entityBottomRow = (entityTopY + entity.speed) / gamePanel.scaledTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision) {
                    entity.collision = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gamePanel.scaledTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision) {
                    entity.collision = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX + entity.speed) / gamePanel.scaledTileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileManager.tiles[tileNum1].collision || gamePanel.tileManager.tiles[tileNum2].collision) {
                    entity.collision = true;
                }
                break;
        }
    }

    public int checkEntity(Entity entity, Entity[] target) {
        int index = -1;

        for(int i = 0; i < target.length; i++) {
            entity.collisionArea.x = entity.x + entity.collisionArea.x;
            entity.collisionArea.y = entity.y + entity.collisionArea.y;

            target[i].collisionArea.x = target[i].x + target[i].collisionArea.x;
            target[i].collisionArea.y = target[i].y + target[i].collisionArea.y;

            if (target[i] == null) continue;

            switch (entity.direction){
                case "up":
                    entity.collisionArea.y -= entity.speed;
                    if(entity.collisionArea.intersects(target[i].collisionArea)) {
                        entity.collision = true;
                        index = i;
                    }
                    break;
                case "down":
                    entity.collisionArea.y += entity.speed;
                    if(entity.collisionArea.intersects(target[i].collisionArea)) {
                        entity.collision = true;
                        index = i;
                    }
                    break;
                case "left":
                    entity.collisionArea.x -= entity.speed;
                    if(entity.collisionArea.intersects(target[i].collisionArea)) {
                        entity.collision = true;
                        index = i;
                    }
                    break;
                case "right":
                    entity.collisionArea.x += entity.speed;
                    if(entity.collisionArea.intersects(target[i].collisionArea)) {
                        entity.collision = true;
                        index = i;
                    }
                    break;
            }


        }
        return index;
    }
}
