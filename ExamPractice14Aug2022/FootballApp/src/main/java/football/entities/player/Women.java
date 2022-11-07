package football.entities.player;

public class Women extends BasePlayer{
    private static final double DEFAULT_KILOGRAMS = 60.00;
    private static final int STRENGTH_INCREASE = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, DEFAULT_KILOGRAMS, strength);
    }

    // TODO Can only play on artificial turf


    @Override
    public void stimulation() {
        setStrength(this.getStrength() + STRENGTH_INCREASE);
    }


}
