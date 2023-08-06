package maps.ents;

import java.awt.Graphics2D;

import main.GamePanel;
import main.KeyHandler;
import maps.Entity;
import maps.Vector2;
import maps.colliders.CircleCollider;
import maps.colliders.Collider;
import maps.colliders.ColliderList;

public class Player extends Entity {
    KeyHandler keyH;
    double speed = 2;
    
    public Player(Vector2 pos, KeyHandler keyH) {
        super(pos);
        this.keyH = keyH;
        this.setCollider(new ColliderList(new Collider[] {
            new CircleCollider(pos, 0.8)
        }));
        this.setTexture("/res/player.png");
    }
    public void update(double deltaTime) {
        Vector2 move = new Vector2(0, 0);
        if (this.keyH.is("W")) {
            move.iadd(new Vector2(0, -1));
        }
        if (this.keyH.is("A")) {
            move.iadd(new Vector2(-1, 0));
        }
        if (this.keyH.is("S")) {
            move.iadd(new Vector2(0, 1));
        }
        if (this.keyH.is("D")) {
            move.iadd(new Vector2(1, 0));
        }
        if (move.sizeSquared() > 0) {
            move.inormalize();
            this.pos = this.pos.add(move.mul(deltaTime * this.speed));
        }
    }
    public void draw(Graphics2D g, Vector2 offset) {
        Vector2 at = this.pos.sub(offset).sub(new Vector2(1, 1)).mul(new Vector2(GamePanel.SCREEN_TILE_SIZE, GamePanel.SCREEN_TILE_SIZE));
        g.drawImage(this.getTexture(), at.floorx(), at.floory(), GamePanel.SCREEN_TILE_SIZE, GamePanel.SCREEN_TILE_SIZE, null);
    }
}