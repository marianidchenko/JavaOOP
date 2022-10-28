package solid;
import solid.products.Product;

import java.util.List;

public class Printer {
    private static final String SUM_FORMAT = "Sum: %f";
    private static final String AVERAGE_FORMAT = "Average: %f";

    public static void printSum(List<Product> products) {
        System.out.printf((SUM_FORMAT) + "%n", CalorieCalculator.sum(products));
    }

    public static void printAverage(List<Product> products) {
        System.out.printf((AVERAGE_FORMAT) + "%n", CalorieCalculator.average(products));
    }
}
