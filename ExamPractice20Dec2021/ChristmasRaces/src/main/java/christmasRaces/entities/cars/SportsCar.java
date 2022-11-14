package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 3000;

    public SportsCar(String model, int horsepower) {
        super(model, horsepower, DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsepower(int horsepower) {
        if (horsepower > 450 || horsepower < 250) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsepower));
        }
        super.setHorsepower(horsepower);
    }
}
