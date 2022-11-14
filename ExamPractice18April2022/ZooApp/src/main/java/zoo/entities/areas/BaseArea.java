package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return this.animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return this.foods;
    }

    @Override
    public int sumCalories() {
        int totalCalories = 0;
        for (Food food: this.foods) {
            totalCalories += food.getCalories();
        }
        return totalCalories;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.animals.size() >= capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : this.animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s)", this.getName(), this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        if (this.animals.size() > 0) {
            sb.append(String.format("Animals: %s", String.join(" ", this.animals.stream()
                    .map(Animal::getName)
                    .collect(Collectors.toList()))));
        } else {
            sb.append("Animals: none");
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Foods: %d", this.foods.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Calories: %d", this.foods.stream().mapToInt(Food::getCalories).sum()));
        return sb.toString();
    }
}
