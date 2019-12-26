package model;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Point> points;
    private ArrayList<Block> blocks;

    public Graph() {
        this.points = new ArrayList<>();
        this.blocks = new ArrayList<>();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}
