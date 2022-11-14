package christmasRaces.repositories.interfaces;

import christmasRaces.entities.races.Race;

import java.util.ArrayList;
import java.util.Collection;

public class RaceRepository implements Repository {
    private Collection<Race> models;

    public RaceRepository() {
        this.models = new ArrayList<Race>();
    }

    @Override
    public Object getByName(String name) {
        return this.models.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Race> getAll() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        this.models.add((Race) model);
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove((Race) model);
    }
}
