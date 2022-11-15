package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ExplorerRepository implements Repository{
    private Collection<Explorer> explorers;

    public ExplorerRepository(Collection<Explorer> explorers) {
        this.explorers = new ArrayList<Explorer>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(explorers);
    }

    @Override
    public void add(Object entity) {
        this.explorers.add((Explorer) entity);
    }

    @Override
    public boolean remove(Object entity) {
        return this.explorers.remove((Explorer) entity);
    }

    @Override
    public Object byName(String name) {
        return this.explorers.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
