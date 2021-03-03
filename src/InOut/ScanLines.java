package InOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScanLines {
    private Scanner scanner;
    ArrayList<String> lines;

    public ScanLines(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
        this.lines = new ArrayList<>();
        while ( scanner.hasNext() ) {
            lines.add(scanner.nextLine());
        }
    }
    public ArrayList<String> getLines(){ return lines; }

}
