package code;

public class Vector2 {
    double x;
    double y;

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
    public void imul(double o) {
        this.x *= o;
        this.y *= o;
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
}
