package com.blackjackgame;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {


    public static void main(String[] args) throws IOException {

        List<String> actionsList = new ArrayList<>();

        List<String> readLinesFromFile = new ArrayList<>();

        List<Game> results = new ArrayList<>();

        ClassLoader classLoader = Blackjack.class.getClassLoader();
        File file = new File(classLoader.getResource("game_data.txt").getFile());
        Scanner sc = new Scanner(new FileReader(file));


        while (sc.hasNextLine()) {
            readLinesFromFile.add(sc.nextLine());

        }

        for (int i = 0; i < readLinesFromFile.size(); i++) {
            String[] fields = readLinesFromFile.get(i).split(",");
            String timestamp = fields[0];
            String sessionId = fields[1];
            String playerId = fields[2];

            String gameAction = fields[3].replace(" ", "_").toUpperCase();
            actionsList.add(gameAction);
            ActionType action = ActionType.valueOf(gameAction);

            Hand dealerHand = new Hand();
            String[] dealerCards = fields[4].split("-");
            for (String a : dealerCards) {
                if (a.equals("?")) continue;
                dealerHand.addCard(new Card(a));

            }

            Hand playerHand = new Hand();
            String[] playerCards = fields[5].split("-");
            for (String a : playerCards) {
                playerHand.addCard(new Card(a));

            }

            if (action == ActionType.P_JOINED) {
               // JOptionPane.showMessageDialog(null,"Welcome to play BlackJack!","",JOptionPane.PLAIN_MESSAGE);
                System.out.println("Welcome to play BlackJack player: " + playerId);
            } else if (action == ActionType.P_HIT) {
                gameResultByHandValue(dealerHand.getValue(), playerHand.getValue());
            } else if (action == ActionType.P_STAND) {
                gameResultByHandValue(dealerHand.getValue(), playerHand.getValue());
            } else if (action == ActionType.D_SHOW) {
                gameResultByHandValue(dealerHand.getValue(), playerHand.getValue());
            } else if (action == ActionType.D_HIT) {
                gameResultByHandValue(dealerHand.getValue(), playerHand.getValue());
            } else if (action == ActionType.P_WIN) {
                gameResultByHandValue(dealerHand.getValue(), playerHand.getValue());
            } else if (action == ActionType.P_LEFT) {
                // JOptionPane.showMessageDialog(null,"Player left table!","",JOptionPane.PLAIN_MESSAGE);
                System.out.println("Player " + playerId + " left table!");
            }

            results.add(new Game(sessionId, playerId, actionsList, dealerHand, playerHand));
        }




        FileWriter writer = new FileWriter("analyzer_results.txt");
        for (Game result : results) {
            writer.write(result.toString());
            writer.write("\n");

        }
    }

    private static void gameResultByHandValue(int dealer, int player) {

        boolean gameEnd = false;

        if (player > 21) {
          //  JOptionPane.showMessageDialog(null,"Player BUST!   DEALER WIN!","",JOptionPane.PLAIN_MESSAGE);
            System.out.println("Player BUST!   DEALER WIN!!!");
            gameEnd = true;
        }

        if ((dealer > 21) && gameEnd == false) {
          //  JOptionPane.showMessageDialog(null,"DEALER BUST!   PLAYER WIN!!!","",JOptionPane.PLAIN_MESSAGE);
            System.out.println("DEALER BUST!   PLAYER WIN!!!");
            gameEnd = true;
        }


        while ((dealer >= 17) && gameEnd == false) {

            if ((dealer > player) && gameEnd == false) {
             //   JOptionPane.showMessageDialog(null,"DEALER WIN!!!","",JOptionPane.PLAIN_MESSAGE);
                System.out.println("DEALER WIN!!!");
                gameEnd = true;
            }


            if ((dealer == player) && gameEnd == false) {
              //  JOptionPane.showMessageDialog(null,"TIE!","",JOptionPane.PLAIN_MESSAGE);
                System.out.println("TIE!");
                gameEnd = true;
            }

            if ((dealer < player) && gameEnd == false) {
             //   JOptionPane.showMessageDialog(null,"PLAYER WIN!!!","",JOptionPane.PLAIN_MESSAGE);
                System.out.println("PLAYER WIN!!!");
            } else {
              //  JOptionPane.showMessageDialog(null,"DEALER WIN!!!","",JOptionPane.PLAIN_MESSAGE);
                System.out.println("DEALER WIN!!!");
            }
            gameEnd = true;
        }

    }
}


