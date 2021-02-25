
import java.util.ArrayList;

public class ScanTable {
    ArrayList<String> lines;
    ArrayList<Double> lineParts;
    ArrayList<ArrayList<Double>> table;

    public ScanTable(ArrayList<String> lines ) {
        this.lines = lines;
        this.lineParts = new ArrayList<>(30);
        this.table = new ArrayList<>(30);

        for ( String str : lines ) {
            String[] temp = str.split("\t");
            for ( int i = 0; i<temp.length; i++ ) {
                lineParts.add(Double.parseDouble(temp[i]));
            }
            table.add(lineParts);
            lineParts = new ArrayList<>();
        }
    }
    public ArrayList<ArrayList<Double>> getTable(){ return table; }
}
