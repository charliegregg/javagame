package maps;


public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2() {
        this(0, 0);
    }
    public Vector2(Vector2 o) {
        this(o.x, o.y);
    }
    public Vector2 add(Vector2 o) {
        return new Vector2(this.x + o.x, this.y + o.y);
    }
    public void iadd(Vector2 o) {
        this.x += o.x;
        this.y += o.y;
    }
    public Vector2 sub(Vector2 o) {
        return new Vector2(this.x - o.x, this.y - o.y);
    }
    public void isub(Vector2 o) {
        this.x -= o.x;
        this.y -= o.y;
    }
    public Vector2 mul(double o) {
        return new Vector2(this.x * o, this.y * o);
    }
    public Vector2 mul(Vector2 o) {
        return new Vector2(this.x * o.x, this.y * o.y);
    }
    public void imul(double o) {
        this.x *= o;
        this.y *= o;
    }
    public void imul(Vector2 o) {
        this.x *= o.x;
        this.y *= o.y;
    }
    public Vector2 div(double o) {
        return new Vector2(this.x / o, this.y / o);
    }
    public void idiv(double o) {
        this.x /= o;
        this.y /= o;
    }
    public double dot(Vector2 o) {
        return this.x * o.x + this.y * o.y;
    }
    public int floorx() {
        return (int) Math.floor(this.x);
    }
    public int floory() {
        return (int) Math.floor(this.y);
    }
    public double size() {
        return Math.hypot(this.x, this.y);
    }
    public double sizeSquared() {
        return this.dot(this);
    }
    public Vector2 insertx(double x) {
        return new Vector2(x, this.y);
    }
    public Vector2 inserty(double y) {
        return new Vector2(this.x, y);
    }
    public Vector2 insertx(Vector2 getx) {
        return new Vector2(getx.x, this.y);
    }
    public Vector2 inserty(Vector2 gety) {
        return new Vector2(this.x, gety.y);
    }
    public Vector2 neg() {
        return new Vector2(-this.x, -this.y);
    }
    public Vector2 normalize() {
        return this.div(this.size());
    }
    public void inormalize() {
        this.idiv(this.size());
    }
    public Vector2 lerp(Vector2 o, double t) {
        return this.mul(1 - t).add(o.mul(t));
    }
    public Vector2 floor() {
        return new Vector2(Math.floor(this.x), Math.floor(this.y));
    }
    public Vector2 ceil() {
        return new Vector2(Math.ceil(this.x), Math.ceil(this.y));
    }
    public Vector2 round() {
        return new Vector2(Math.round(this.x), Math.round(this.y));
    }
    public Vector2 abs() {
        return new Vector2(Math.abs(this.x), Math.abs(this.y));
    }
    public Vector2 min(Vector2 o) {
        return new Vector2(Math.min(this.x, o.x), Math.min(this.y, o.y));
    }
    public Vector2 max(Vector2 o) {
        return new Vector2(Math.max(this.x, o.x), Math.max(this.y, o.y));
    }
    public Vector2 clamp(Vector2 min, Vector2 max) {
        return this.max(min).min(max);
    }
    public Vector2 clamp(double min, double max) {
        return this.max(new Vector2(min, min)).min(new Vector2(max, max));
    }
    public Vector2 rotate(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Vector2(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }
    public Vector2 rotateAround(Vector2 point, double angle) {
        return this.sub(point).rotate(angle).add(point);
    }
}
