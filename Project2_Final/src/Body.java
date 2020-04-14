public class Body {
    private double x;
    private double y;
    private int mass;
    private double friction;

    public Body(double x, double y, int mass, double friction) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.friction = friction;
    }

    public int getMass() {
        return mass;
    }

    public double getFriction() {
        return friction;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
