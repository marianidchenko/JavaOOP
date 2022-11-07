package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {
    private final static double ARCHEOLOGIST_INITIAL_ENERGY = 60;
    public Archaeologist(String name) {
        super(name, ARCHEOLOGIST_INITIAL_ENERGY);
    }

}
