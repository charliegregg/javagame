package code.maps;

public class Level {
    TileGrid floor;
    TileGrid blocks;

    public Level(int width, int height) {
        this.floor = new TileGrid(width, height);
        this.blocks = new TileGrid(width, height);
    }
}
