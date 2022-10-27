package solid.products;

public abstract class AbstractFood implements Product {
    public double grams;
    public double caloriesPer100;

    public AbstractFood(double grams) {
        this.grams = grams;
    }

    @Override
    public double getCalories() {
        return (this.caloriesPer100 / 100) * this.grams;
    }
}
