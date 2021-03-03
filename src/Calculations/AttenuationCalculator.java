package Calculations;

public class AttenuationCalculator {
    private final Double og;
    private final Double fg;
    private final Double attenuation;

    public AttenuationCalculator(Double og, Double fg ) {
        this.og = og;
        this.fg = fg;
        this.attenuation = calculateAttenuation();
    }

    private Double calculateAttenuation() {
        return (((og-fg)/(og-1.0))*100.0);
    }

    public Double calculateAttenuation(Double og, Double fg ) {
        return (((og-fg)/(og-1.0))*100.0);
    }

    public Double getAttenuation() { return attenuation; }

}
