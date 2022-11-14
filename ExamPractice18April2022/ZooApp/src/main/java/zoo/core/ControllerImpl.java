package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        switch (areaType) {
            case "LandArea":
               this.areas.add(new LandArea(areaName));
               break;
            case "WaterArea":
                this.areas.add(new WaterArea(areaName));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        switch (foodType) {
            case "Meat":
                this.foodRepository.add(new Meat());
                break;
            case "Vegetable":
                this.foodRepository.add(new Vegetable());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = this.foodRepository.findByType(foodType);
        Area area = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }
        assert area != null;
        area.addFood(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = areas.stream().filter(f -> f.getName().equals(areaName)).findFirst().orElse(null);
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                if (!area.getClass().getSimpleName().equals("WaterArea")) {
                    return ConstantMessages.AREA_NOT_SUITABLE;
                }
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                if (!area.getClass().getSimpleName().equals("LandArea")) {
                    return ConstantMessages.AREA_NOT_SUITABLE;
                }
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
        try {
            area.addAnimal(animal);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } catch (IllegalStateException e) {
            return ExceptionMessages.NOT_ENOUGH_CAPACITY;
        }
    }

    @Override
    public String feedAnimal(String areaName) {
        int fedCount = 0;
        Area area = areas.stream().filter(f -> f.getName().equals(areaName)).findFirst().orElse(null);
        assert area != null;
        for (Animal animal: area.getAnimals()) {
            animal.eat();
            fedCount++;
        }
        return String.format(ConstantMessages.ANIMALS_FED, fedCount);
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = this.areas.stream().filter(f -> f.getName().equals(areaName)).findFirst().orElse(null);
        double result = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, result);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area area: this.areas) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
