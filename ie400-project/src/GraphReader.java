import model.Block;
import model.Graph;
import model.Point;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class GraphReader {
    public static Graph read(String filepath) {
        Graph graph = new Graph();

        try {
            FileInputStream excelFile = new FileInputStream(new File(filepath));
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet pointsSheet = workbook.getSheetAt(0);
            Sheet blocksSheet = workbook.getSheetAt(1);

            Iterator<Row> iterator = pointsSheet.iterator();
            iterator.next(); // pass the header line

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                int x = (int)cellIterator.next().getNumericCellValue();
                int y = (int)cellIterator.next().getNumericCellValue();
                graph.getPoints().add(new Point(x, y));
            }

            iterator = blocksSheet.iterator();
            iterator.next(); // pass the header lines
            iterator.next(); // pass the header lines

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                int x = (int)cellIterator.next().getNumericCellValue();
                int y = (int)cellIterator.next().getNumericCellValue();
                int width = (int)cellIterator.next().getNumericCellValue();
                int height = (int)cellIterator.next().getNumericCellValue();
                graph.getBlocks().add(new Block(x, y, width, height));
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        return graph;
    }

    public static void main(String[] args) {
        Graph graph = GraphReader.read("resources/data.xlsx");
        System.out.println(graph.getPoints());
    }
}
