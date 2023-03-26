package com.blackjackgame;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hand {
    private List<Card> cards;
    private int value;

    public Hand() {
        this.cards = new ArrayList<>();
        this.value = 0;
    }

    public void addCard(Card card) {
        this.cards.add(card);
        if (card.getValue() == CardValue.ACE) {
            // If the card is an Ace, then adds 11 to the value if it won't go over 21, otherwise add 1
            if (this.value + 11 <= 21) {
                this.value += 11;
            } else {
                this.value += 1;
            }
        } else this.value += getCardValue(card);
    }

    private int getCardValue(Card card) {
        switch (card.getValue()) {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            case ACE:
                return 1;
            default:
                throw new IllegalArgumentException("Invalid card value");
        }
    }

}


