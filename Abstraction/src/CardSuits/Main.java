package CardSuits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardSuits[] cards = CardSuits.values();
        scanner.nextLine();
        String result = "Card Suits:\n";
        for (CardSuits card : cards) {
            result += String.format("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name());
        }
        System.out.println(result);
    }
}
