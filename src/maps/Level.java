package maps;


import java.awt.Graphics2D;
import java.util.ArrayList;

public class Level {
    private TileGrid floor;
    private TileGrid blocks;
    private ArrayList<Entity> entities;

    public Level(int width, int height) {
        this.floor = new TileGrid(width, height);
        this.blocks = new TileGrid(width, height);
        this.entities = new ArrayList<>();
    }
    public Entity addEntity(Entity entity) {
        this.entities.add(entity);
        return entity;
    }
    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }
    public ArrayList<Entity> getEntities() {
        return this.entities;
    }
    public void setTile(int x, int y, Tile tile, boolean floor) {
        if (floor) {
            this.floor.setTile(x, y, tile);
        } else {
            this.blocks.setTile(x, y, tile);
        }
    }
    public void setTile(int x, int y, Tile tile) {
        this.setTile(x, y, tile, false);
    }
    public Tile getTile(int x, int y, boolean floor) {
        if (floor) {
            return this.floor.getTile(x, y);
        }
        return this.floor.getTile(x, y);
    }
    public void update(double deltaTime) {
        for (Entity entity : this.entities) {
            entity.update(deltaTime);
        }
    }
    public void draw(Graphics2D g, Vector2 cameraPos) {
        for (int x = 0; x < this.floor.width; x++) {
            for (int y = 0; y < this.floor.height; y++) {
                this.floor.getTile(x, y).draw(g, new Vector2(x, y).sub(cameraPos));
            }
        }
        for (int x = 0; x < this.blocks.width; x++) {
            for (int y = 0; y < this.blocks.height; y++) {
                this.blocks.getTile(x, y).draw(g, new Vector2(x, y).sub(cameraPos));
            }
        }
        for (Entity entity : this.entities) {
            entity.draw(g, entity.pos.sub(cameraPos));
        }
    }
}
