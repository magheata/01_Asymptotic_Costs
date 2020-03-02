package Domain.DTO;

public class Point {

    private int x;
    private long y;

    public Point(int x, long y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public long getY() {
        return this.y;
    }
}
