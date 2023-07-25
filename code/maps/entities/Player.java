package code.maps.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

import code.Vector2;
import code.maps.Entity;
import code.maps.colliders.CircleCollider;
import code.maps.colliders.ColliderList;

public class Player extends Entity {

    public Player(Vector2 pos) {
        super(pos);
        this.setCollider(new ColliderList(new ArrayList<>(Arrays.asList(
            new CircleCollider(pos, 0.4)
        ))));
        this.getCollider();
    }
    public void update() {

    }
    public void draw(Graphics2D g) {
        
    }
}