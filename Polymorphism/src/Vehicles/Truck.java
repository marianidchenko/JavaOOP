package vehicles;

public class Truck extends AbstractVehicle {

    private static final double CONSUMPTION_INCREASE = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION_INCREASE);
    }

    @Override
    public String drive(double kilometers) {
        return super.drive(kilometers);
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters * 0.95);
    }
}
