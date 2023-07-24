package code.maps;

import code.maps.tiles.Edge;

public class TileGrid {
    private Tile[][] tiles;
    int width, height;

    public TileGrid(int width, int height) {
        this.tiles = new Tile[width][height];
        this.width = width;
        this.height = height;
    }
    public void setTile(int x, int y, Tile tile) {
        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            return;
        }
        this.tiles[x][y] = tile;
    }
    public Tile getTile(int x, int y) {
        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            return new Edge();
        }
        return this.tiles[x][y];
    }
}
