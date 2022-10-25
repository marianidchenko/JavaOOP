package vehicles;

public class Car extends AbstractVehicle {

    private static final double CONSUMPTION_INCREASE = 0.9;


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION_INCREASE);
    }

    @Override
    public String drive(double kilometers) {
        return super.drive(kilometers);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
    }
}
