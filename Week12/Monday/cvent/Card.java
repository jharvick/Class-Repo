package com.cvent;

public class Card {
    private CardSuit cardSuit;
    private String value;
    private boolean isFaceUp;

    public Card(CardSuit suit, String value) {
        this.cardSuit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public CardSuit getSuit() {
        // only return the suit if the card is face up
        return isFaceUp ? cardSuit : null;
    }

    public String getValue() {
        // only return the value if the card is face up
        return isFaceUp ? value : "#";
    }

    public int getPointValue() {
        // only return the value if the card is face up
        if (isFaceUp) {
            switch (value) {
                case "A":
                    return 11;
                case "K":
                case "Q":
                case "J":
                    return 10;
                default:
                    try {
                        return Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        // if value is not a number, return 0
                        return 0;
                    }
            }
        }
        return 0;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}
