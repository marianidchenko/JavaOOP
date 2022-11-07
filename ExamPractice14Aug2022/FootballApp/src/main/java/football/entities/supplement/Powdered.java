package football.entities.supplement;

public class Powdered extends BaseSupplement{
    private final static int DEFAULT_ENERGY = 120;
    private static final double DEFAULT_PRICE = 15;

    public Powdered() {
        super(DEFAULT_ENERGY, DEFAULT_PRICE);
    }
}
