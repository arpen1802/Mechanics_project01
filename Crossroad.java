public class Crossroad {
    private int width;
    private int lightTime;

    public Crossroad(int width, int lightTime) {
        this.width = width; // 5-20
        this.lightTime = lightTime; // 2-5
    }

    public int getWidth() {
        return width;
    }

    public int getLightTime() {
        return lightTime;
    }
}
