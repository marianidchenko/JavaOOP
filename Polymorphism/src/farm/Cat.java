package farm;

import java.text.DecimalFormat;

public class Cat extends Feline {
    String breed;
    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        setBreed(breed);
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("###.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(), this.getAnimalName(),
                this.getBreed(), format.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
