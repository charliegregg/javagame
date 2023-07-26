package main;

import java.awt.Graphics2D;

import maps.Level;
import maps.WorldMap;



public class GameManager {
    WorldMap map;
    int mainLevelId;
    Level mainLevel;

    public GameManager() {
        this.map = new WorldMap();
        this.mainLevelId = this.map.addLevel(new Level(10, 10));
        this.mainLevel = this.map.getLevel(this.mainLevelId);
        this.mainLevel.addEntity(new Player);
    }
    public void update() {

    }
    public void render(Graphics2D g) {

    }
}
