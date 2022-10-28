package solid.products;

public abstract class AbstractFood implements Product {
    private double grams;
    public double caloriesPer100;

    public AbstractFood(double grams) {
        this.grams = grams;
    }

    @Override
    public double getCalories() {
        return (this.caloriesPer100 / 100) * this.grams;
    }

    public double getKilograms() {
        return this.grams/1000;
    }
}
