package solid.products;

public class Lemonade extends AbstractDrink{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(milliliters);
        this.caloriesPer100Grams = CALORIES_PER_100_GRAMS;
        this.density = DENSITY;
    }

}
