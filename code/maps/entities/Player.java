package code.maps.entities;

import code.Vector2;
import code.maps.Entity;

public class Player extends Entity {
    private static final Vector2 SIZE = new Vector2(1.8, 1.8);


    public Player(Vector2 pos) {
        super(pos);
    }
}