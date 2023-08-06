package maps.colliders;

import maps.Vector2;

public class ColliderList {
    Collider[] colliders;

    public ColliderList(Collider[] colliders) {
        this.colliders = colliders;
    }
    public boolean collide(ColliderList o, Vector2 thisOffset) {
        for (int i = 0; i < this.colliders.length; i++) {
            for (int j = 0; j < o.colliders.length; j++) {
                if (this.colliders[i].collide(o.colliders[j], thisOffset)) {
                    return true;
                }
            }
        }
        return false;
    }
    public <T extends Collider> boolean collide(T o, Vector2 thisOffset) {
        return this.collide(new ColliderList(new Collider[] {o}), thisOffset);
    }
}
