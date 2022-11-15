package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StateRepository implements Repository{

    private Collection<State> states;

    public StateRepository() {
        this.states = new ArrayList<State>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(states);
    }

    @Override
    public void add(Object entity) {
        this.states.add((State) entity);
    }

    @Override
    public boolean remove(Object entity) {
        return this.states.remove((State) entity);
    }

    @Override
    public Object byName(String name) {
        return this.states.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }
}
