package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>(capacity);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        } else {
            this.name = name;
        }
    }

    @Override
    public int sumEnergy() {
        int totalEnergy = 0;
        for (Supplement s : this.supplements) {
            totalEnergy += s.getEnergy();
        }
        return totalEnergy;
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() < capacity) {
            this.players.add(player);
        } else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player p : this.players) {
            p.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):\n", this.name, this.getClass().getSimpleName()));
        if (this.players.size() > 0) {
            for (Player p : this.players) {
                sb.append(String.format("Player: %s\n", String.join(" ", this.players.stream().map(Player::getName).collect(Collectors.toList()))));
            }
        } else {
            sb.append("Player: none\n");
        }
        sb.append(String.format("Supplement: %d\n", this.supplements.size()));
        sb.append(String.format("Energy: %d", this.sumEnergy()));
        return sb.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
