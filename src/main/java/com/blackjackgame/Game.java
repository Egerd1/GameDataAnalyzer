package com.blackjackgame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Game {

    private String sessionId;
    private String playerId;
    private List<String> actions;
    private Hand dealerHand;
    private Hand playerHand;

}
