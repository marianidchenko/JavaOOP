package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<Product>();
    }

    private void setName(String name) {
        if (name.length() == 0 || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money - product.getCost() >= 0) {
            this.money -= product.getCost();
            this.products.add(product);
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s", name, product.getName()));
        }
    }

    public String getName() {
        return name;
    }

    public void printPurchases() {
        if (products.size() > 0) {
            System.out.printf("%s - %s\n",
                    this.getName(),
                    this.products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        } else {
            System.out.printf("%s - Nothing bought", this.getName());
        }
    }
}
