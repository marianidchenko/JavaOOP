package ShoppingSpree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] peopleTokens = scanner.nextLine().split(";");
        String[] productsTokens = scanner.nextLine().split(";");
        List<Person> people = new ArrayList<Person>();
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < peopleTokens.length; i++) {
            String[] personTokens= peopleTokens[i].split("=");
            try {
                Person person = new Person(personTokens[0], Double.parseDouble(personTokens[1]));
                people.add(person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < productsTokens.length; i++) {
            String[] productTokens= productsTokens[i].split("=");
            try {
                Product product = new Product(productTokens[0], Double.parseDouble(productTokens[1]));
                products.add(product);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            List<String> commandTokens = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            String productName = commandTokens.remove(commandTokens.size() - 1);
            String personName = commandTokens.stream().collect(Collectors.joining(" "));
            Person person = people.stream().filter(p -> p.getName().equals(personName)).findFirst().orElse(null);
            Product product = products.stream().filter(p -> p.getName().equals(productName)).findFirst().orElse(null);
            try {
                if (person != null && product != null) {
                    person.buyProduct(product);
                    System.out.printf("%s bought %s\n", person.getName(), product.getName());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
            command = scanner.nextLine();
        }
        for (Person person : people) {
            person.printPurchases();
        }
    }
}
