import model.Edge;
import model.Graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GraphWriter {
    public static void write(Graph graph, String outputPath) {
        String toWrite = "";
        toWrite += "n = " + graph.getPoints().size() + ";\n";
        toWrite += "dist = [\n";
        for (Edge edge : graph.getEdges()) {
            if (edge.getPath() == null) {
                toWrite = toWrite + (int)1e9 + "\n";
            } else {
                toWrite = toWrite + edge.getPath().size() + "\n";
            }
        }
        toWrite += "];\n";


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
            writer.write(toWrite);
            writer.close();
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }
}
