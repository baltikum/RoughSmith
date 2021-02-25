import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RoughSmith {

    public static void main(String[] args ) throws FileNotFoundException { //Throws ifrån scanningen

        IBUCalculator test = new IBUCalculator(30.0,0.03,20.0,1.056, 60.0);
        test.calculateIBU();




    }

}
