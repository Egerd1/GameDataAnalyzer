package com.blackjackgame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Card {

    private CardValue value;
    private CardSuit suit;

    public Card(String s) {

        String value = s.substring(0, s.length() - 1).toUpperCase();
        String suit = s.substring(s.length() - 1).toUpperCase();
        this.suit = CardSuit.valueOf(CardSuit.fromSymbol(suit));
        this.value = CardValue.valueOf(match(CardValue.fromSymbol(value)));

    }
    public String match(String val){
        switch (val) {
            case "2":
                return "TWO";
            case "3":
                return "THREE";
            case "4":
                return "FOUR";
            case "5":
                return "FIVE";
            case "6":
                return "SIX";
            case "7":
                return "SEVEN";
            case "8":
                return "EIGHT";
            case "9":
                return "NINE";
            case "10":
                return "TEN";
            case "J":
                return "JACK";
            case "Q":
                return "QUEEN";
            case "K":
                return "KING";
            case "A":
                return "ACE";
            default:
                throw new IllegalArgumentException("Invalid card value");
        }
    }

}

