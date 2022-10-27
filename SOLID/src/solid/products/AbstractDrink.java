package solid.products;

public abstract class AbstractDrink implements Product{
    public double milliliters;
    public double density;
    public double caloriesPer100Grams;

    public AbstractDrink(double milliliters) {
        this.milliliters = milliliters;
    }

    @Override
    public double getCalories() {
        return (this.density * this.milliliters) * this.caloriesPer100Grams / 100;
    }
}
