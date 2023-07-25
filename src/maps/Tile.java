package code.maps;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import code.maps.colliders.ColliderList;

public abstract class Tile {
    final String[] TEXTURE_PATHS = new String[] {};
    private BufferedImage[] textures;
    private int frame_number = 0;

    private static ColliderList collider;

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