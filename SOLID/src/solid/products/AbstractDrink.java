package solid.products;

public abstract class AbstractDrink implements Product{
    private double milliliters;
    public double density;
    public double caloriesPer100Grams;

    public AbstractDrink(double milliliters) {
        this.milliliters = milliliters;
    }

    @Override
    public double getCalories() {
        return (this.density * this.milliliters) * this.caloriesPer100Grams / 100;
    }

    public double getLiters() {
        return this.milliliters/1000;
    }

    public double getKilograms() {
        return this.milliliters * density / 1000;
    }
}
