package com.blackjackgame;

import lombok.Getter;

@Getter
public enum CardValue {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String cardValue;

    CardValue(String cardValue) {
        this.cardValue = cardValue;

    }

    public static String fromSymbol(String symbol) {
        for (CardValue value : values()) {
            if (value.cardValue.equals(symbol)) {
                return value.cardValue;
            }
        }
        return null;
    }

}
