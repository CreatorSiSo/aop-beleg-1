import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class Poker {
    public static void main(String[] args) {
        System.out.println("Amount of players [2, 10]:");
        int amountPlayers = getIntFromUser(2, 10);
        Card[][] players = new Card[amountPlayers][2];
        ArrayList<Card> deck = Card.generateDeck();

        System.out.println("\nRound 1:");
        System.out.println("Dealing cards");
        for (Card[] player : players) {
            player[0] = deck.removeLast();
            player[1] = deck.removeLast();
        }

        System.out.println("\nRound 2 (Flop):");
        for (int i = 0; i < 3; i += 1) {
            System.out.println(deck.removeLast());
        }

        System.out.println("\nRound 3 (Turn):");
        System.out.println(deck.removeLast());

        System.out.println("\nRound 4 (River):");
        System.out.println(deck.removeLast());

        System.out.println("\nRound 5:");
        for (int i = 0; i < players.length; i += 1) {
            System.out.println("Player " + (i + 1) + ":");
            for (Card card : players[i]) {
                System.out.println("  " + card);
            }
        }
    }

    private static int getIntFromUser(int from, int to) {
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
        in.close();
        return result;
    }
}

class Card {
    private Color color;
    private String kind;

    static ArrayList<Card> generateDeck() {
        String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "König", "Ass" };
        ArrayList<Card> deck = new ArrayList<>(Stream.of(Color.values())
                .flatMap(color -> Stream.of(cards).map(i -> new Card(color, i)))
                .toList());
        Collections.shuffle(deck);
        return deck;
    }

    Card(Color color, String kind) {
        this.color = color;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return switch (color) {
            case Kreuz -> "Kreuz";
            case Pik -> "Pik";
            case Herz -> "Herz";
            case Karo -> "Karo";
        } + ", " + kind;
    }
}

enum Color {
    Kreuz,
    Pik,
    Herz,
    Karo,
}
