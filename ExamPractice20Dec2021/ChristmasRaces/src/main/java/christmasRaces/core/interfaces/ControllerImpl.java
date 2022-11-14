package christmasRaces.core.interfaces;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.CarRepository;
import christmasRaces.repositories.interfaces.DriverRepository;
import christmasRaces.repositories.interfaces.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ControllerImpl implements Controller {

    private DriverRepository drivers;
    private CarRepository cars;
    private RaceRepository races;

    public ControllerImpl(Repository drivers, Repository cars, Repository races) {
        this.drivers = (DriverRepository) drivers;
        this.cars = (CarRepository) cars;
        this.races = (RaceRepository) races;
    }

    @Override
    public String createDriver(String driver) {
        Driver currentDriver = new DriverImpl(driver, null, 0, false);
        if (drivers.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }
        this.drivers.add(currentDriver);
        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        }
        if (this.cars.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
        }
        this.cars.add(car);
        return String.format(OutputMessages.CAR_CREATED, car.getClass().getSimpleName(), model);
    }


    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (this.drivers.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        if (this.cars.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }
        Car car = (Car) this.cars.getByName(carModel);
        Driver driver = (Driver) this.drivers.getByName(driverName);
        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (this.races.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (this.drivers.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        Race race = (Race) this.races.getByName(raceName);
        Driver driver = (Driver) this.drivers.getByName(driverName);
        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = (Race) this.races.getByName(raceName);
        if (race == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        ArrayList<Driver> availableDrivers = new ArrayList<Driver>();
        for (Driver driver : this.drivers.getAll()){
            if (driver.getCanParticipate()) {
                availableDrivers.add(driver);
            }
        }
        if (availableDrivers.size() < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }
        Comparator<Driver> comp = new Comparator<>() {
            @Override
            public int compare(Driver o1, Driver o2) {
                return Double.compare(o2.getCar().calculateRacePoints(1), (o1.getCar().calculateRacePoints(1)));
            }
        };

        Collections.sort(availableDrivers, comp);
        availableDrivers.get(0).winRace();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.DRIVER_FIRST_POSITION + "\n", availableDrivers.get(0).getName(), raceName));
        sb.append(String.format(OutputMessages.DRIVER_SECOND_POSITION + "\n", availableDrivers.get(1).getName(), raceName));
        sb.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, availableDrivers.get(2).getName(), raceName));
        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        if (this.races.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        this.races.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
