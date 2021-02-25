import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class IBUCalculator {

    private ArrayList<ArrayList<Double>> hopsUtilTable;
    private Double og;
    private Double volume;
    private Double alpha;
    private double hopUtil;
    private double boilTime;
    private Double gram;


    public IBUCalculator(Double gram,Double alpha, Double volume, Double og ,Double boilTime) throws FileNotFoundException {
        ScanLines temp= new ScanLines(new File("HopUtilValues.txt"));
        ArrayList<String>lines = temp.getLines();
        ScanTable scanToTable = new ScanTable(lines);
        this.hopsUtilTable = scanToTable.getTable();
        this.alpha = alpha;
        this.volume = volume;
        this.og = og;
        this.boilTime = boilTime;
        this.gram = gram;
        this.hopUtil = resolveHopsUtilTable();
    }

    public Double calculateIBU() {
        return (((gram*1000) * alpha * hopUtil )/ volume);
    }
    private Double resolveHopsUtilTable() {
        int b = 0;
        int a = 0;
        Double value = -1.0;
        Double[] indexA = {0.0,3.0,6.0,9.0,12.0,15.0,18.0,21.0,24.0,27.0,30.0,33.0,36.0,39.0,42.0,45.0,48.0,51.0,54.0,57.0,60.0,70.0,80.0,90.0,120.0};
        Double[] indexB = {1.030,1.040,1.050,1.060,1.070,1.080,1.090,1.100,1.110,1.120,1.130};


        for ( int i = 0; i<indexA.length; i++ ) {
            if ( this.boilTime < indexA[i] ) {
                a = i-1;
                break;
            }
        }

        for ( int i = 0; i<indexB.length; i++ ) {
            if ( this.og < indexB[i] ) {
                b = i; // Dåligt steg i tabellen egentligen.
                break;
            }
        }
        if ( a != -1 ) {
            value = hopsUtilTable.get(a).get(b);
        }
        return value;
    }
    public void printHopsUtilTable() {
        StringBuilder str = new StringBuilder();

        for( ArrayList<Double> valueTable : hopsUtilTable ) {
            for ( Double value : valueTable ) {
                str.append(value + "\t");
            }
            str.append("\n");
        }
        System.out.print(str.toString());
    }
}
