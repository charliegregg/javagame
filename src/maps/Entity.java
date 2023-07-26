package maps;

import java.awt.Graphics2D;

import maps.colliders.ColliderList;

public abstract class Entity {
    public Vector2 pos;
    private ColliderList collider;

    public Entity(Vector2 pos) {
        this.pos = pos;
    }

    abstract public void update();

    abstract public void draw(Graphics2D g, Vector2 offset);

    public ColliderList getCollider() {
        return collider;
    }
    public void setCollider(ColliderList collider) {
        this.collider = collider;
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
