package farm;

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
        return String.format("%s [%s, %s, %f, %s, %d]",
                this.getAnimalType(), this.getAnimalName(),
                this.getBreed(), this.getAnimalWeight(),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
