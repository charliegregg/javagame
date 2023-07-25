package main;

import java.awt.Graphics2D;

import code.maps.Level;
import code.maps.WorldMap;

public class GameManager {
    WorldMap map;
    int mainLevelId;
    Level mainLevel;

    public GameManager() {
        this.map = new WorldMap();
        this.mainLevelId = this.map.addLevel(new Level(10, 10));
        this.mainLevel = this.map.getLevel(this.mainLevelId);
        this.mainLevel.
    }
    public void update() {

    }
    public void render(Graphics2D g) {

    }
}
