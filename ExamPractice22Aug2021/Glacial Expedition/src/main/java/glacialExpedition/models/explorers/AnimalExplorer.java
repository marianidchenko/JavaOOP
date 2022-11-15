package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{
    private static final long DEFAULT_INITIAL_ENERGY = 100;

    public AnimalExplorer(String name) {
        super(name, DEFAULT_INITIAL_ENERGY);
    }
}
