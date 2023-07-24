package code.maps.colliders;

import code.Vector2;

public abstract class Collider {
    public Vector2 pos;
    abstract boolean collide(BoxCollider o, Vector2 thisOffset);
    abstract boolean collide(CircleCollider o, Vector2 thisOffset);
    abstract boolean collide(PointCollider o, Vector2 thisOffset);
    public <T extends Collider> boolean collide(T o, Vector2 thisOffset) {
        if (o instanceof BoxCollider) {
            return this.collide((BoxCollider) o, thisOffset);
        }
        if (o instanceof CircleCollider) {
            return this.collide((CircleCollider) o, thisOffset);
        }
        if (o instanceof PointCollider) {
            return this.collide((PointCollider) o, thisOffset);
        }
        return false;
    }
}
