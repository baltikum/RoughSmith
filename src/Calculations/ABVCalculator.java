package Calculations;

public class ABVCalculator {

    /**
     * Alcohol by volume Calculator
     * (76.08 * (og-fg) / (1.775-og)) * (fg / 0.794)  = ABV
     *
     */

    private final Double og;
    private final Double fg;
    private final Double abv;

    public ABVCalculator(Double og, Double fg ) {
        this.og = og;
        this.fg = fg;
        this.abv = calculateABV();
    }

    private Double calculateABV() {
        return ((76.08 * (og-fg) / (1.775-og)) * (fg / 0.794));
    }

    public Double calculateABV(Double og, Double fg ) {
        return ((76.08 * (og-fg) / (1.775-og)) * (fg / 0.794));
    }

    public Double getABV() { return abv; }

}
