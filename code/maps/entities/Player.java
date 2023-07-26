package code.maps.entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import code.GamePanel;
import code.Vector2;
import code.maps.Entity;
import code.maps.colliders.CircleCollider;
import code.maps.colliders.ColliderList;

public class Player extends Entity {
    BufferedImage texture;

    public Player(Vector2 pos) {
        super(pos);
        this.setCollider(new ColliderList(new ArrayList<>(Arrays.asList(
            new CircleCollider(pos, 0.4)
        ))));
        try {
            this.texture = ImageIO.read(getClass().getResourceAsStream(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {

    }
    public void draw(Graphics2D g) {
        g.drawImage(this.texture, x, 0, GamePanel.SCREEN_TILE_SIZE, GamePanel.SCREEN_TILE_SIZE, null);
    }
}
