package code.maps;

import java.util.HashMap;

public class WorldMap {
    Map<int, Level> levels;
    int nextId;

    public WorldMap() {
        this.levels = new HashMap<int, Level>();
        this.nextId = 0;
    }
    public int addLevel(Level level) {
        this.levels.put(this.nextId, level);
        return this.nextId++;
    }
    public getLevel(int id) {
        return this.levels.get(id);
    }
}
