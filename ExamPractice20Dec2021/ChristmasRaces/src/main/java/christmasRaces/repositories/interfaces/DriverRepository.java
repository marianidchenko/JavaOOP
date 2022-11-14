package christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class DriverRepository implements Repository {
    private Collection<Driver> models;

    public DriverRepository() {
        this.models = new ArrayList<Driver>();
    }

    @Override
    public Object getByName(String name) {
        return this.models.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Driver> getAll() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        this.models.add((Driver) model);
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove((Driver) model);
    }
}
