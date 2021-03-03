import Calculations.IBUCalculator;

import java.io.FileNotFoundException;

public class RoughSmith {

    public static void main(String[] args ) throws FileNotFoundException { //Throws ifrån scanningen

        IBUCalculator test = new IBUCalculator(30.0,0.03,20.0,1.056, 60.0);
        test.calculateIBU();




    }

}
