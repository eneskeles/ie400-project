import model.Graph;
import model.Point;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Graph graph = GraphReader.read("/Users/eneskeles/IdeaProjects/ie400-project/ie400-project/resources/data.xlsx");
        graph.computeEdges();
        GraphWriter.write(graph, "/Users/eneskeles/IdeaProjects/ie400-project/ie400-project/out/edgedata.dat");
    }
}
