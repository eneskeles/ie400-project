package model;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // start point is located in lower left corner
    // end point is located in upper right corner
    public boolean inBounds(Point start, Point end) {
        return (this.x >= start.x && this.x <= end.x) && (this.y >= start.y && this.y <= end.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point))
            return false;
        return (this.x == ((Point)other).x && this.y == ((Point)other).y);
    }

}
