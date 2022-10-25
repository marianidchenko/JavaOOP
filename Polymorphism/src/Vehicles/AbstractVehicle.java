package vehicles;

import java.text.DecimalFormat;

public class AbstractVehicle implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    private double tankCapacity;


    public AbstractVehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            System.out.println("Fuel quantity must be a positive number");
            return;
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double kilometers) {
        DecimalFormat format = new DecimalFormat("###.##");
        double fuelNeeded = kilometers * this.getFuelConsumption();
        if (fuelNeeded <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(kilometers));
        }
        return this.getClass().getSimpleName() + " needs refueling";
    }

    @Override
    public void refuel(double liters) {
        if (this.getFuelQuantity() + liters > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
