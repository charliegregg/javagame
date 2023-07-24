package code.maps;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    Map<Integer, Level> levels;
    int nextId;

    public WorldMap() {
        this.levels = new HashMap<Integer, Level>();
        this.nextId = 0;
    }
    public int addLevel(Level level) {
        this.levels.put(this.nextId, level);
        return this.nextId++;
    }
    public Level getLevel(int id) {
        return this.levels.get(id);
    }
}
