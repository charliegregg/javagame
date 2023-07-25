package code.maps.colliders;

import java.util.ArrayList;

import code.Vector2;

public class ColliderList {
    ArrayList<Collider> colliders;

    public ColliderList(ArrayList<Collider> colliders) {
        this.colliders = colliders;
    }
    public boolean collide(ColliderList o, Vector2 thisOffset) {
        for (int i = 0; i < this.colliders.size(); i++) {
            for (int j = 0; j < o.colliders.size(); j++) {
                if (this.colliders.get(i).collide(o.colliders.get(j), thisOffset)) {
                    return true;
                }
            }
        }
        return false;
    }
    public <T extends Collider> boolean collide(T o, Vector2 thisOffset) {
        ArrayList<Collider> list = new ArrayList<Collider>();
        list.add(o);
        return this.collide(new ColliderList(list), thisOffset);
    }
}
