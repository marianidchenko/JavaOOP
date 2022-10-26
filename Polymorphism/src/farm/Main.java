package farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        boolean oddInput = true;
        List<Animal> animals = new ArrayList<>();
        while (!command.equals("End")) {
            String[] tokens = command.split(" ");
            if (oddInput) {
                switch(tokens[0]) {
                    case "Cat":
                        animals.add(new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3], tokens[4]));
                        break;
                    case "Tiger":
                        animals.add(new Tiger(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]));
                        break;
                    case "Zebra":
                        animals.add(new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]));
                        break;
                    case "Mouse":
                        animals.add(new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]));
                        break;
                }
            } else {
                Food food = null;
                if (tokens[0].equals("Vegetable")) {
                    food = new Vegetable(Integer.parseInt(tokens[1]));
                } else {
                    food = new Meat(Integer.parseInt(tokens[1]));
                }
                Animal currentAnimal = animals.get(animals.size() - 1);
                currentAnimal.makeSound();
                currentAnimal.eatFood(food);
            }
            command = scanner.nextLine();
            oddInput = !oddInput;
        }
        for (Animal animal: animals) {
            System.out.println(animal);
        }
    }
}
