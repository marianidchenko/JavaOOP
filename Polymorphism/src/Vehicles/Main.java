package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfoTokens = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInfoTokens[1]);
        double carConsumption = Double.parseDouble(carInfoTokens[2]);
        double carCapacity = Double.parseDouble(carInfoTokens[3]);
        Car car = new Car(carFuelQuantity, carConsumption, carCapacity);

        String[] truckInfoTokens = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInfoTokens[1]);
        double truckConsumption = Double.parseDouble(truckInfoTokens[2]);
        double truckCapacity = Double.parseDouble(truckInfoTokens[3]);
        Truck truck = new Truck(truckFuelQuantity, truckConsumption, truckCapacity);

        String[] busInfoTokens = scanner.nextLine().split(" ");
        double busFuelQuantity = Double.parseDouble(busInfoTokens[1]);
        double busConsumption = Double.parseDouble(busInfoTokens[2]);
        double busCapacity = Double.parseDouble(busInfoTokens[3]);
        Bus bus = new Bus(busFuelQuantity, busConsumption, busCapacity);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split(" ");
            switch (commandTokens[1]) {
                case "Car":
                    if (commandTokens[0].equals("Drive")) {
                        System.out.println(car.drive(Double.parseDouble(commandTokens[2])));
                    } else if (commandTokens[0].equals("Refuel")){
                        car.refuel(Double.parseDouble(commandTokens[2]));
                    }
                    break;
                case "Truck":
                    if (commandTokens[0].equals("Drive")) {
                        System.out.println(truck.drive(Double.parseDouble(commandTokens[2])));
                    } else if (commandTokens[0].equals("Refuel")){
                        truck.refuel(Double.parseDouble(commandTokens[2]));
                    }
                    break;
                case "Bus":
                    if (commandTokens[0].equals("Drive")) {
                        System.out.println(bus.drive(Double.parseDouble(commandTokens[2])));
                    } else if (commandTokens[0].equals("DriveEmpty")) {
                        System.out.println(bus.driveEmpty(Double.parseDouble(commandTokens[2])));
                    } else if (commandTokens[0].equals("Refuel")){
                        bus.refuel(Double.parseDouble(commandTokens[2]));
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}