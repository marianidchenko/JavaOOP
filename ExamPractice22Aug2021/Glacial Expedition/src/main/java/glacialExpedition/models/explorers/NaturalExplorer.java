package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final long DEFAULT_INITIAL_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, DEFAULT_INITIAL_ENERGY);
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(0, this.getEnergy() - 7));
    }
}
