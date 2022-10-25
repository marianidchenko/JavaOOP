package farm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            super.eatFood(food);
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
