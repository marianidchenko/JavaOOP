package farm;

public class Tiger extends Feline{
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eatFood(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            super.eatFood(food);
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
