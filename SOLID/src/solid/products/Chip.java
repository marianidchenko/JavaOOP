package solid.products;

public class Chip extends AbstractFood{
    private static final double  CALORIES_PER_100_GRAMS = 529;

    public Chip(double grams) {
        super(grams);
        this.caloriesPer100 = CALORIES_PER_100_GRAMS;
    }

}
