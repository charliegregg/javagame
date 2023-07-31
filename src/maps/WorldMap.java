package maps;

import java.util.Set;
import java.util.HashSet;

public class WorldMap {
    private Set<Level> levels;

    public WorldMap() {
        this.levels = new HashSet<>();
    }
    public Level addLevel(Level level) {
        this.levels.add(level);
        return level;
    }
    public Set<Level> getLevels() {
        return this.levels
    }
}
