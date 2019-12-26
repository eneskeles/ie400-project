package utils;

import model.Block;
import model.Edge;
import model.Graph;
import model.Point;

import java.util.*;

public class EdgeFinder {
    public static ArrayList<Edge> find(Graph graph) {
        ArrayList<Point> points = graph.getPoints();
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < points.size(); ++i) {

            for (int j = i + 1; j < points.size(); ++j) {
                ArrayList<Point> path;
                if (points.get(i).getX() <= points.get(j).getX() && points.get(i).getY() <= points.get(j).getY()) {
                    path = bfs(points.get(i), points.get(j), graph.getBlocks());
                } else {
                    path = bfs(points.get(j), points.get(i), graph.getBlocks());
                }
                edges.add(new Edge(i, j, path));
            }
        }

        return edges;
    }

    private static ArrayList<Point> bfs(Point start, Point end, ArrayList<Block> blocks) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        HashMap<Point, Point> predecessor = new HashMap<>();

        while (!queue.isEmpty()) {
            Point current = queue.remove();

            boolean intersects = false;
            for (Block block : blocks) {
                if (block.intersects(current)) {
                    intersects = true;
                    break;
                }
            }

            if (!intersects) {
                if (current.equals(end)) {
                    return findPath(start, end, predecessor);
                }

                Point right = new Point(current.getX() + 1, current.getY());
                Point top = new Point(current.getX(), current.getY() + 1);

                if (!predecessor.containsKey(right) && right.inBounds(start, end)) {
                    queue.add(right);
                    predecessor.put(right, current);
                }

                if (!predecessor.containsKey(top) && top.inBounds(start, end)) {
                    queue.add(top);
                    predecessor.put(top, current);
                }
            }
        }

        return null;
    }

    private static ArrayList<Point> findPath(Point start, Point end, HashMap<Point, Point> predecessor) {
        ArrayList<Point> path = new ArrayList<>();
        Point current = end;

        while (current != null && !current.equals(start)) {
            path.add(0, current);
            current = predecessor.get(current);
        }

        path.add(0, start);
        return path;
    }

}

