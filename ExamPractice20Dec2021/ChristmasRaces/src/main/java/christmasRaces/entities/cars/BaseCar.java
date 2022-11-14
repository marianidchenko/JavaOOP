package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car{
    private String model;
    private int horsepower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsepower, double cubicCentimeters) {
        setModel(model);
        setHorsepower(horsepower);
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsepower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimeters/this.horsepower * laps;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    private void setModel(String model) {
        if (model.length() < 4) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, 4));
        }
        this.model = model;
    }
}
