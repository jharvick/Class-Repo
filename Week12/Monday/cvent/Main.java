package com.cvent;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle(); // Shuffle the deck before dealing

        Hand hand1 = new Hand();

        // Deal 5 cards
        for (int i = 0; i < 5; i++) {
            // Get a card from the deck
            Card card = deck.deal();

            // Check if there are cards left to deal
            if (card != null) {
                // Deal that card to the hand
                hand1.deal(card);
            } else {
                System.out.println("No more cards to deal.");
                break; // Exit the loop if the deck is empty
            }
        }

        // Get the value of the hand
        int handValue = hand1.getValue();

        // Print the value of the hand
        System.out.println("This hand is worth " + handValue);
    }
}
