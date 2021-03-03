package Calculations;

import Ingredients.Yeast;

public class FGCalculator {
    /**
     * org - final = total
     *
     * Final Gravity = 1 + ((Total Gravity Points * (1 - Attenuation Percent)) / 1000)
     *
     */
    private final Double gravity;
    private final Yeast yeast;
    private final Double fg;

    public FGCalculator(Double gravity, Yeast yeast) {
        this.gravity = gravity;
        this.yeast = yeast;
        this.fg = calculateFG();
    }

    private double calculateFG(){
        return (gravity *(1.0-yeast.getAttenuation())/1000.0);
    }

    public Double calculateFG(Double gravity, Yeast yeast) {
        return (gravity *(1.0-yeast.getAttenuation())/1000.0);
    }

    public Double getFG() { return fg; }


}
