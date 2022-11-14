package christmasRaces.repositories.interfaces;

import christmasRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;

public class CarRepository implements Repository {
    private Collection<Car> models;

    public CarRepository() {
        this.models = new ArrayList<Car>();
    }

    @Override
    public Object getByName(String name) {
        return this.models.stream().filter(x -> x.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        this.models.add((Car) model);
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove((Car) model);
    }
}
