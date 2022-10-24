package needForSpeed;
//created by J.M.

public class Main {

    public static void main(String[] args) {
        FamilyCar car = new FamilyCar(10.0, 200);
        System.out.println(car.getFuel());
        car.drive(1);
        System.out.println(car.getFuel());
    }
}
