package maps;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import maps.colliders.ColliderList;

public abstract class Entity {
    public Vector2 pos;
    private ColliderList collider;
    private BufferedImage texture;
    public Level level;

    public Entity(Vector2 pos) {
        this.pos = pos;
    }

    abstract public void update(double deltaTime);

    abstract public void draw(Graphics2D g, Vector2 offset);

    public ColliderList getCollider() {
        return collider;
    }
    public void setCollider(ColliderList collider) {
        this.collider = collider;
    }
    public BufferedImage getTexture() {
        return texture;
    }
    public void setTexture(String path) {
        try {
            this.texture = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean collide(TileGrid grid) {
        return grid.getTile(this.pos.floorx(), this.pos.floory()).getCollider().collide(collider,
                new Vector2(this.pos.floorx() - this.pos.x, this.pos.floory() - this.pos.y))
                || grid.getTile(this.pos.floorx() + 1, this.pos.floory()).getCollider().collide(collider,
                        new Vector2(this.pos.floorx() + 1 - this.pos.x, this.pos.floory() - this.pos.y))
                || grid.getTile(this.pos.floorx(), this.pos.floory() + 1).getCollider().collide(collider,
                        new Vector2(this.pos.floorx() - this.pos.x, this.pos.floory() + 1 - this.pos.y))
                || grid.getTile(this.pos.floorx() + 1, this.pos.floory() + 1).getCollider().collide(collider,
                        new Vector2(this.pos.floorx() + 1 - this.pos.x, this.pos.floory() + 1 - this.pos.y));
    }
}
