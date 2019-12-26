package model;

import java.util.ArrayList;
import java.util.List;

public class Edge {
    private int firstPointIndex;
    private int secondPointIndex;
    private ArrayList<Point> path;

    public Edge(int firstPointIndex, int secondPointIndex, ArrayList<Point> path) {
        this.firstPointIndex = firstPointIndex;
        this.secondPointIndex = secondPointIndex;
        this.path = path;
    }

    public int getDistance() {
        if (this.path == null) {
            return (int)1e9;
        }
        else return path.size() - 1;
    }

    public int getFirstPointIndex() {
        return firstPointIndex;
    }

    public int getSecondPointIndex() {
        return secondPointIndex;
    }

    public ArrayList<Point> getPath() {
        return path;
    }

    public void setFirstPointIndex(int firstPointIndex) {
        this.firstPointIndex = firstPointIndex;
    }

    public void setSecondPointIndex(int secondPointIndex) {
        this.secondPointIndex = secondPointIndex;
    }

    public void setPath(ArrayList<Point> path) {
        this.path = path;
    }
}
