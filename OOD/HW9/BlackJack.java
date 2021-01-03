package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private Hand player;
    private Hand computer;
    private Deck deck;

    public BlackJack(){
        player = new Hand();
        computer = new Hand();
        deck = new Deck();
        deck.shuffleCards();
    }

    private int getPossiblePoint(Hand hand, boolean firstAceAsEleven) {
        int total = 0;
        int countAce = 0;

        for (int i = 0; i < hand.size(); i++) {
            int cardValue = hand.getCard(i).getNameNumber();
            total += getPoint(cardValue);
            if (cardValue == 1) {
                countAce++;
            }
        }
        if (countAce > 0 && firstAceAsEleven) {
            total += 10;
        }
        return total;
    }

    private boolean isSoft17(Hand hand) {
        return getPossiblePoint(hand, true) == 17;
    }

    private int getMaxPossiblePointsWithoutBusting(Hand hand) {
        int point = getPossiblePoint(hand, true);
        if (point <= 21) {
            return point;
        }
        return getPossiblePoint(hand, false);
    }

    private void printGameResult(String result) {
        System.out.printf("\n**************************************\n%s\n**************************************\n", result);
    }

    private boolean checkWinOrBust(Hand hand, String playerName){
        int point = getMaxPossiblePointsWithoutBusting(hand);
        if (point == 21) {
            printGameResult(String.format("BlackJack! %s win!", playerName));
            return true;
        } else if (point > 21) {
            printGameResult(String.format("Bust (%d points)! %s lose!", point, playerName));
            return true;
        }
        return false;
    }

    private int getPoint(int cardName){
        if (cardName >= 10) {
            return 10;
        }
        return cardName;
    }

    private boolean hit(Scanner keyboard){
        while(true){
            try{
                System.out.println("Do you want to hit? Enter y to hit, n to hold");
                String s = keyboard.next();
                if (s.equalsIgnoreCase("y")){
                    return true;
                }else if(s.equalsIgnoreCase("n")){
                    return false;
                }else{
                    throw new IllegalArgumentException("Invalid Input. Enter again:");
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void start(){
        Scanner keyboard = new Scanner(System.in);
        boolean hit = true;
        //first step - computer draw two cards
        computer.addCard(deck.removeFirstCard());
        System.out.print("House got two Cards. The first one is:  ");
        computer.printCards();
        computer.addCard(deck.removeFirstCard());

        //User draw two cards
        player.addCard(deck.removeFirstCard());
        player.addCard(deck.removeFirstCard());
        System.out.print("You got two cards:  ");
        player.printCards();

        while (true) {
            if (checkWinOrBust(player, "You")) {
                return;
            }
            if (!hit(keyboard)) {
                break;
            }
            Card newCard = deck.removeFirstCard();
            System.out.println("The card you got is: " + newCard.toString());
            player.addCard(newCard);
            System.out.print("Now your hand is: ");
            player.printCards();
        }


        System.out.println("\n======================================");
        // reveal the second card of house
        System.out.print("The house hand is: ");
        computer.printCards();
        // A,5,10
        while (!isSoft17(computer) && getMaxPossiblePointsWithoutBusting(computer) < 17) {
            Card newCard = deck.removeFirstCard();
            System.out.println("House draws one card: " + newCard.toString());
            computer.addCard(newCard);
            System.out.print("Now house hand is: ");
            computer.printCards();
        }
        if (checkWinOrBust(computer, "Computer")) {
            return;
        }

        // compare points
        int playerPoint = getMaxPossiblePointsWithoutBusting(player);
        int computerPoint = getMaxPossiblePointsWithoutBusting(computer);
        if (playerPoint == computerPoint) {
            printGameResult(String.format("House(%d) vs Player(%d), it's a tie!", computerPoint, playerPoint));
        } else {
            printGameResult(String.format("House(%d) vs Player(%d), %s win!", computerPoint, playerPoint, playerPoint > computerPoint ? "You" : "Computer"));
        }
    }

    public static void main(String[] args){
        BlackJack game = new BlackJack();
        game.start();
    }


}
