package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar {

    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000;

    public MuscleCar(String model, int horsepower) {
        super(model, horsepower, DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    protected void setHorsepower(int horsepower) {
        if (horsepower > 600 || horsepower < 400) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsepower));
        }
        super.setHorsepower(horsepower);
    }
}

