package solid.products;

public class Coke extends AbstractDrink{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;


    public Coke(double milliliters) {
        super(milliliters);
        this.density = DENSITY;
        this.caloriesPer100Grams = CALORIES_PER_100_GRAMS;
    }
}
