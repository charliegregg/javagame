package code.maps;

public class TileGrid {
    Tile[][] tiles;
    int width, height;

    public TileGrid(int width, int height) {
        this.tiles = new Tile[width][height];
        this.width = width;
        this.height = height;
    }
}
