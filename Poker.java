import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        System.out.println("Amount of players [2, 10]:");
        Card[][] players = new Card[getInt(2, 10)][2];
        ArrayList<Card> deck = Card.generateDeck();

        System.out.println("\nRound 1:");
        for (Card[] player : players) {
            player[0] = deck.removeLast();
            player[1] = deck.removeLast();
        }

        System.out.println("\nRound 2 (Flop):");
        for (int i = 0; i < 3; i += 1) {
            System.out.println(deck.removeLast().toString());
        }

        System.out.println("\nRound 3 (Turn):");
        System.out.println(deck.removeLast().toString());

        System.out.println("\nRound 4 (River):");
        System.out.println(deck.removeLast().toString());

        System.out.println("\nRound 5:");
        for (int i = 0; i < players.length; i += 1) {
            System.out.println("Player " + (i + 1) + ":");
            for (Card card : players[i]) {
                System.out.println("  " + card.toString());
            }
        }
    }

    private static int getInt(int from, int to) {
        Scanner in = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                result = Integer.parseInt(in.nextLine().strip());
                if (result >= from && result <= to) {
                    break;
                }
            } catch (Exception e) {
            }
            System.out.println("Invalid input, try again:");
        }
        return result;
    }
}

class Card {
    Color color;
    int kind;

    static ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList<>(52);
        for (Color color : Color.values()) {
            for (int i = 2; i <= 14; i += 1) {
                deck.add(new Card(color, i));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public String toString() {
        return switch (color) {
            case Kreuz -> "Kreuz";
            case Pik -> "Pik";
            case Herz -> "Herz";
            case Karo -> "Karo";
        } + ", " + switch (kind) {
            case 14 -> "Ass";
            case 13 -> "König";
            case 12 -> "Dame";
            case 11 -> "Bube";
            default -> kind;
        };
    }

    // kind in range 2..14 inclusive
    Card(Color color, int kind) {
        this.color = color;
        this.kind = kind;
    }
}

enum Color {
    Kreuz,
    Pik,
    Herz,
    Karo,
}
