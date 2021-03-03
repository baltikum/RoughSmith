package Ingredients;

public abstract class Grain extends Ingredient {
    private Double extract, color, amount; // aamount i lbs här då beräkningar ofta görs i lbs.
    public Double getExtract(){ return extract; };
    public Double getColor(){ return color; };
    public Double getAmount(){ return amount; };
}
