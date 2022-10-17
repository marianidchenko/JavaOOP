package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardRanks[] cards = CardRanks.values();
        scanner.nextLine();
        String result = "Card Ranks:\n";
        for (CardRanks card : cards) {
            result += String.format("Ordinal value: %d; Name value: %s\n", card.ordinal(), card.name());
        }
        System.out.println(result);
    }
}
