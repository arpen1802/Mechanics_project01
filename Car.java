public class Car {
    private double speed;
    private float dist;
    private float positiveAcc;
    private float negativeAcc;

    public Car(double speed, int dist, int positiveAcc, int negativeAcc){
        this.speed = speed;
        this.dist = dist;
        this.positiveAcc = positiveAcc;
        this.negativeAcc = negativeAcc;
    }

    public double getSpeed() {
        return speed;
    }

    public float getDist() {
        return dist;
    }

    public float getPositiveAcc() {
        return positiveAcc;
    }

    public float getNegativeAcc() {
        return negativeAcc;
    }
}
