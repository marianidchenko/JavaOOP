package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
    private static final long DEFAULT_INITIAL_ENERGY = 40;

    public GlacierExplorer(String name) {
        super(name, DEFAULT_INITIAL_ENERGY);
    }
}
