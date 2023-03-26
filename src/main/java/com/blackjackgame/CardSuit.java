package com.blackjackgame;

public enum CardSuit {

    S("S"),
    H("H"),
    C("C"),
    D("D");

    private final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public static String fromSymbol(String symbol) {
        for (CardSuit suit : values()) {
            if (suit.suit.equals(symbol)) {
                return suit.getSuit();
            }
        }
        return "";
    }

}
