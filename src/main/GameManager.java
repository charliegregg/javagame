package main;

import java.awt.Graphics2D;

import maps.Level;
import maps.WorldMap;
import maps.entities.Player;



public class GameManager {
    WorldMap map;
    Level mainLevel;
    Player player;

    public GameManager() {
        this.map = new WorldMap();
        this.mainLevel = this.map.addLevel(new Level(10, 10));
        this.player = this.mainLevel.addEntity(new Player(new Vector2(5, 5)));
    }
    public void update() {
        this.player.update();
    }
    public void render(Graphics2D g) {
        this.player.draw();
    }
}
