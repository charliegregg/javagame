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
}
