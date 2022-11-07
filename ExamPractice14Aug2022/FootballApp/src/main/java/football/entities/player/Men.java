package football.entities.player;

public class Men extends BasePlayer{
    private static final double DEFAULT_KILOGRAMS = 85.50;
    private static final int STRENGTH_INCREASE = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, DEFAULT_KILOGRAMS, strength);
    }

    // TODO Can only play on natural grass


    @Override
    public void stimulation() {
        setStrength(this.getStrength() + STRENGTH_INCREASE);
    }
}
