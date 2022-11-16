package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private ToyRepository toys;
    private Collection<House> houses;
    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        switch (type) {
            case "ShortHouse":
                this.houses.add(new ShortHouse(name));
                break;
            case "LongHouse":
                this.houses.add(new LongHouse(name));
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        switch (type) {
            case "Ball":
                this.toys.buyToy(new Ball());
                break;
            case "Mouse":
                this.toys.buyToy(new Mouse());
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        this.toys.removeToy(toy);
        assert house != null;
        house.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);
        assert house != null;
        switch (catType) {
            case "LonghairCat":
                Cat longhairCat = new LonghairCat(catName, catBreed, price);
                if (!house.getClass().getSimpleName().equals("LongHouse")) {
                    return UNSUITABLE_HOUSE;
                }
                house.addCat(longhairCat);
                break;
            case "ShorthairCat":
                Cat shorthairCat = new ShorthairCat(catName, catBreed, price);
                if (!house.getClass().getSimpleName().equals("ShortHouse")) {
                    return UNSUITABLE_HOUSE;
                }
                house.addCat(shorthairCat);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);
        assert house != null;
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);
        assert house != null;
        double total = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        total += house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(VALUE_HOUSE, houseName, total);
    }

    @Override
    public String getStatistics() {
        return String.join("\n", this.houses.stream()
                .map(House::getStatistics)
                .collect(Collectors.toList()));
    }
}
