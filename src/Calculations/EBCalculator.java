package Calculations;

import Ingredients.Grain;


import static java.lang.Math.pow;

public class EBCalculator {
    /**
     * A Malt Color Units (MCU) is the color of each grain times the grain weight in pounds
     * divided by the batch volume in gallons. When more than one fermentable is used,
     * the MCU color is calculated for each fermentable and then added together.
     *
     * MCU = (Grain Color * Grain Weight lbs.)/Volume in Gallons
     *
     * This works great for beers that are light in color but due to the fact that light
     * absorbance is logarithmic and not linear we need to use the Morey equation
     *
     *
     * SRM_Color = 1.4922 * [MCU ^ 0.6859] -- Good for beer colors < 50 SRM
     *
     *
     */

    private final Grain grain;
    private final Double volume; // gallons
    private final Double mcu;
    private final Double srm;
    private final Double ebc;

    public EBCalculator(Grain grain, Double volume) {
        this.grain = grain;
        this.volume = volume;
        this.mcu = calculateMCU();
        this.srm = calculateMoreyEquationSRM();
        this.ebc = convertSRMtoEBC(srm);
    }

    private Double calculateMCU() {
        return (grain.getColor()*grain.getAmount()/volume);
    }

    private Double calculateMoreyEquationSRM() {
        return (1.4922*(pow(this.mcu,0.6859)));
    }

    public Double getSRM() {
        return srm;
    }
    public Double getEBC() {
        return ebc;
    }

    public Double convertEBCtoSRM(Double value) { return value/1.97; }
    public Double convertSRMtoEBC(Double value) { return value*1.97; }
}
