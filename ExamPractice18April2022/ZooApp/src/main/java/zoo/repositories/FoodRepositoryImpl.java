package zoo.repositories;

import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository{
    private Collection<Food> foods;

    public FoodRepositoryImpl(Collection<Food> foods) {
        this.foods = new ArrayList<>();
    }

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean remove(Food food) {
        return this.foods.remove(food);
    }

    @Override
    public Food findByType(String type) {
        return this.foods.stream()
                .filter(f -> f.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }


}
