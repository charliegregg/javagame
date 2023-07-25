package code.maps.colliders;

import code.Vector2;

public class PointCollider extends Collider {

    public PointCollider(Vector2 pos) {
        this.pos = pos;
    }
    public boolean collide(BoxCollider o, Vector2 thisOffset) {
        return o.collide(this, thisOffset.neg());
    }
    public boolean collide(CircleCollider o, Vector2 thisOffset) {
        return o.collide(this, thisOffset.neg());
    }
    public boolean collide(PointCollider o, Vector2 thisOffset) {
        return this.pos.add(thisOffset).equals(o.pos);
    }
}
