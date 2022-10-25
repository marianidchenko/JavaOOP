package vehicles;

public class Bus extends AbstractVehicle {

    private static final double CONSUMPTION_INCREASE = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION_INCREASE, tankCapacity);
    }

    public String driveEmpty(double kilometers) {
        this.setFuelConsumption(this.getFuelConsumption() - CONSUMPTION_INCREASE);
        String result = super.drive(kilometers);
        this.setFuelConsumption(this.getFuelConsumption() + CONSUMPTION_INCREASE);
        return result;
    }
}
