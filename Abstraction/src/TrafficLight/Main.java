package TrafficLight;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] colors = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < colors.length; j++) {
                colors[j] = String.valueOf(TrafficLight.valueOf(colors[j]).next());
            }
            System.out.println(Arrays.toString(colors).replaceAll("\\[|]|,|", ""));
        }
    }
}
