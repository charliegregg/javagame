package code.maps;

import java.awt.Graphics2D;

import code.Vector2;
import code.maps.colliders.Collider;

public abstract class Entity {
    public Vector2 pos;
    private static Collider collider;

    public Entity(Vector2 pos) {
        this.pos = pos;
    }
    public void update() {

    }
    public void draw(Graphics2D g) {
        
    }
    public Collider getCollider() {
        return collider;
    }
    public boolean collide(TileGrid grid) {
        return grid.getTile(this.pos.floorx(), this.pos.floory()).getCollider().collide(collider, new Vector2(this.pos.floorx() - this.pos.x, this.pos.floory() - this.pos.y))
          || grid.getTile(this.pos.floorx()+1, this.pos.floory()).getCollider().collide(collider, new Vector2(this.pos.floorx()+1 - this.pos.x, this.pos.floory() - this.pos.y))
          || grid.getTile(this.pos.floorx(), this.pos.floory()+1).getCollider().collide(collider, new Vector2(this.pos.floorx() - this.pos.x, this.pos.floory()+1 - this.pos.y))
        || grid.getTile(this.pos.floorx()+1, this.pos.floory()+1).getCollider().collide(collider, new Vector2(this.pos.floorx()+1 - this.pos.x, this.pos.floory()+1 - this.pos.y));
    }
}
