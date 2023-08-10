package maps;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import maps.colliders.ColliderList;

public abstract class Tile {
    String[] TEXTURE_PATHS = new String[] {"res/tiles/grass.png"};
    private BufferedImage[] textures;
    private int frame_number = 0;

    private static ColliderList collider;

    abstract public void update(double deltaTime);

    public void draw(Graphics2D g, Vector2 offset) {
        g.drawImage(this.getTexture(), (int) (offset.x * GamePanel.SCREEN_TILE_SIZE), (int) (offset.y * GamePanel.SCREEN_TILE_SIZE), GamePanel.SCREEN_TILE_SIZE, GamePanel.SCREEN_TILE_SIZE, null);
    }

    private void loadImages() {
        if (this.textures == null) {
            this.textures = new BufferedImage[this.TEXTURE_PATHS.length];
            for (int i = 0; i < this.TEXTURE_PATHS.length; i++) {
                try {
                    this.textures[i] = ImageIO.read(getClass().getResourceAsStream(this.TEXTURE_PATHS[i]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public BufferedImage getTexture() {
        this.loadImages();
        return this.textures[frame_number];
    }
    public ColliderList getCollider() {
        return collider;
    }
}