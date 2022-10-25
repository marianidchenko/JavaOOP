package vehicles;

public class Car extends AbstractVehicle {

    private static final double CONSUMPTION_INCREASE = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION_INCREASE, tankCapacity);
    }
}
