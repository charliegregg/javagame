package maps.colliders;

import maps.Vector2;

public class CircleCollider extends Collider {
    public double radius;

    public CircleCollider(Vector2 pos, double radius) {
        this.pos = pos;
        this.radius = radius;
    }
    public boolean collide(BoxCollider o, Vector2 thisOffset) {
        return o.collide(this, thisOffset);
    }
    public boolean collide(CircleCollider o, Vector2 thisOffset) {
        return (this.radius + o.radius)*(this.radius + o.radius) 
              < this.pos.sub(o.pos).add(thisOffset).sizeSquared();
    }
    public boolean collide(PointCollider o, Vector2 thisOffset) {
        return this.radius*this.radius
              < this.pos.sub(o.pos).add(thisOffset).sizeSquared();
    }
}
