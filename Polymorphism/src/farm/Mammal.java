package farm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        setLivingRegion(livingRegion);
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }


    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("###.##");
        return String.format("%s[%s, %s, %s, %d]",
                this.getAnimalType(), this.getAnimalName(),
                format.format(this.getAnimalWeight()), this.getLivingRegion(),
                this.getFoodEaten());
    }
}
