package code.maps.colliders;

import code.Vector2;

public class BoxCollider extends Collider {
    public Vector2 size;

    public BoxCollider(Vector2 pos, Vector2 size) {
        this.pos = pos;
        this.size = size;
    }
    public boolean collide(BoxCollider o, Vector2 thisOffset) {
        Vector2 
            thisStart = this.pos.add(thisOffset),
            thisEnd = thisStart.add(this.size),
            oEnd = o.pos.add(o.size);
        return o.pos.x < thisEnd.x 
            && o.pos.y < thisEnd.y
            && oEnd.x > thisStart.x
            && oEnd.y > thisStart.y;
    }
    public boolean collide(CircleCollider o, Vector2 thisOffset) {
        Vector2 
            thisStart = this.pos.add(thisOffset),
            thisEnd = thisStart.add(this.size);

        boolean left = o.pos.x < thisStart.x,
               right = o.pos.x > thisEnd.x,
                  up = o.pos.y < thisStart.y,
                down = o.pos.y > thisEnd.y;
        
        if (left && up) {
            return thisStart.sub(o.pos).sizeSquared() < o.radius*o.radius;
        }
        if (right && up) {
            return thisStart.insertx(thisEnd).sub(o.pos).sizeSquared() < o.radius*o.radius;
        }
        if (left && down) {
            return thisStart.inserty(thisEnd).sub(o.pos).sizeSquared() < o.radius*o.radius;
        }
        if (right && down) {
            return thisEnd.sub(o.pos).sizeSquared() < o.radius*o.radius;
        }

        if (left) {
            return thisStart.sub(o.pos).x < o.radius;
        }
        if (right) {
            return o.pos.sub(thisEnd).x < o.radius;
        }
        if (up) {
            return thisStart.sub(o.pos).y < o.radius;
        }
        // if (down || !down)
        return o.pos.sub(thisEnd).y < o.radius;
    }
    public boolean collide(PointCollider o, Vector2 thisOffset) {
        Vector2 
            thisStart = this.pos.add(thisOffset),
            thisEnd = thisStart.add(this.size);
        return o.pos.x < thisEnd.x 
            && o.pos.y < thisEnd.y
            && o.pos.x > thisStart.x
            && o.pos.y > thisStart.y;
    }
}
