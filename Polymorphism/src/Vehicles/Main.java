package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfoTokens = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInfoTokens[1]);
        double carConsumption = Double.parseDouble(carInfoTokens[2]);
        Car car = new Car(carFuelQuantity, carConsumption);

        String[] truckInfoTokens = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInfoTokens[1]);
        double truckConsumption = Double.parseDouble(truckInfoTokens[2]);
        Truck truck = new Truck(truckFuelQuantity, truckConsumption);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split(" ");
            if (commandTokens[0].equals("Drive")) {
                if (commandTokens[1].equals("Car")) {
                    System.out.println(car.drive(Double.parseDouble(commandTokens[2])));
                } else {
                    System.out.println(truck.drive(Double.parseDouble(commandTokens[2])));
                }
            } else {
                if (commandTokens[1].equals("Car")) {
                    car.refuel(Double.parseDouble(commandTokens[2]));
                } else {
                    truck.refuel(Double.parseDouble(commandTokens[2]));
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}