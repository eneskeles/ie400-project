package model;

import Utils.EdgeFinder;
import java.util.ArrayList;

public class Graph {
    private ArrayList<Point> points;
    private ArrayList<Block> blocks;
    private ArrayList<Edge> edges;

    public Graph() {
        this.points = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Point> getPath(int firstPointIndex, int secondPointIndex) {
        for (Edge edge : this.edges) {
            if (firstPointIndex == edge.getFirstPointIndex() && secondPointIndex == edge.getSecondPointIndex())
                return edge.getPath();

            if (firstPointIndex == edge.getSecondPointIndex() && secondPointIndex == edge.getFirstPointIndex())
                return edge.getPath();
        }
        return null;
    }

    public void computeEdges() {
        this.edges = EdgeFinder.find(this);
    }
}
