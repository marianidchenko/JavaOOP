package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        int totalPower = RankPowers.valueOf(rank).getValue() + SuitPowers.valueOf(suit).getValue();
        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, totalPower);
    }
}
