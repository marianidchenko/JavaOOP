package solid.products;

public class Chocolate extends AbstractFood{
    public static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(grams);
        this.caloriesPer100 = CALORIES_PER_100_GRAMS;
    }
}
