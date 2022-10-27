package solid;

import solid.products.Chocolate;
import solid.products.Lemonade;
import solid.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Chocolate c = new Chocolate(100);
        System.out.println(c.getCalories());
        Lemonade l = new Lemonade(100);
        System.out.println(l.getCalories());
        List<Product> products = new ArrayList<Product>(){{
            add(c);
            add(l);
        }};
        System.out.println(CalorieCalculator.sum(products));
    }
}
