

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import main.GamePanel;
import maps.Entity;
import maps.Vector2;
import maps.colliders.CircleCollider;
import maps.colliders.Collider;
import maps.colliders.ColliderList;

public class Player extends Entity {
    KeyHandler keyH;

    public Player(Vector2 pos, KeyHandler keyH) {
        super(pos);
        this.keyH = keyH;
        this.setCollider(new ColliderList(new Collider[] {
            new CircleCollider(pos, 0.8)
        }));
        this.setTexture("/res/player.png");
    }
    public void update() {

    }
    public void draw(Graphics2D g, Vector2 offset) {
        Vector2 at = this.pos.sub(offset).sub(new Vector2(1, 1)).mul(new Vector2(GamePanel.SCREEN_TILE_SIZE, GamePanel.SCREEN_TILE_SIZE));
        g.drawImage(this.texture, at.floorx(), at.floory(), GamePanel.SCREEN_TILE_SIZE, GamePanel.SCREEN_TILE_SIZE, null);
    }
}