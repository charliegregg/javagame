package main;

import java.awt.Graphics2D;

import maps.Level;
import maps.WorldMap;
import maps.entities.Player;
import maps.Vector2;

public class GameManager {
    WorldMap map;
    Level mainLevel;
    Player player;
    long lastUpdate;

    public GameManager() {
        this.map = new WorldMap();
        this.mainLevel = this.map.addLevel(new Level(10, 10));
        this.player = this.mainLevel.addEntity(new Player(new Vector2(5, 5)));
    }
    public void update() {
        long currentTime = System.nanoTime();
        double deltaTime = (currentTime - this.lastUpdate) / GamePanel.NANO_PER_SEC;
        this.lastUpdate = currentTime;
        this.player.level.update(deltaTime);
        this.player.update(deltaTime);
    }
    public void render(Graphics2D g) {
        this.player.level.draw(g)
        this.player.draw(g);
    }
}