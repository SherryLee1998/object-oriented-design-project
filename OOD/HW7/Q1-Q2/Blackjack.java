package com.company;

import java.util.Base64;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Blackjack {
    Deck deckB;
    Hand dealer;
    Hand user;
    Scanner keyboard = new Scanner( System.in );

    Blackjack() {
        deckB = new Deck();
        deckB.Shuffle();
        dealer = new Hand();
        user = new Hand();
    }

    public void reset() {
        dealer.reset();
        user.reset();
        deckB.reset();
    }

    // deal out two card to both player for starting
    public void deal() {
        reset();
        user.addCard( deckB.removes() );
        dealer.addCard( deckB.removes() );
        user.addCard( deckB.removes() );
        dealer.addCard( deckB.removes() );
        System.out.println( "************   BlackJack beginning  *********** " );
        System.out.println( "------------   User(first two card) -----------" );
        user.PrintCard();
        System.out.println( "------------   Dealer(first card)   ------------" );
        // because the rule,only show one card at the first time.
        System.out.println( dealer.get() );
    }

    public boolean playTurn() {
        boolean output = true;
        while (true){
            System.out.println( "you want to hit or stand" );
            String choose;
            choose = keyboard.next();

            if (choose.equalsIgnoreCase( "hit" )) {
                user.addCard( deckB.removes() );
                System.out.println( "user:" );
                user.PrintCard();
                if(!gameEnd()) { // if user is already buster by adding, then break and player is lose
                    output = false;
                    break;
                }
            }

            else if (choose.equalsIgnoreCase( "stand" )) {
                System.out.println("----dealer turn----");
                output = true;
                break;
            }
        }
        return output;
    }

    public void dealerTurn() {
        while (true){
            if (dealer.getTotal() >= 17) {
                System.out.println( "dealer is more than 17 , then will not add card anymore " );
                break;
            }
            if (dealer.getTotal() <= 16) {
                System.out.println( "dealer is less than 17 , then will add card " );
                dealer.addCard( deckB.removes() );
                System.out.println( "current house:" );
                dealer.PrintCard();
            }
        }
    }

    public boolean gameEnd() {
        boolean output = true;
        if (dealer.getTotal() > 21) {
            System.out.println( "Dealer's cards is larger than 21. busting! User win!\nsummery:\n" );
            PrintCurrentCard();
            output = false;
        }
        else if (user.getTotal() > 21) {
            System.out.println( "User's cards is larger than 21.busting! Dealer win!\nSummery:\n" );
            PrintCurrentCard();
            output = false;
        }
        else if (user.getTotal() == 21){
            System.out.println("User is Blackjack! user win! ");
            PrintCurrentCard();
            output = false;
        }
        else if (dealer.getTotal() == 21){
            System.out.println("Dealer is Blackjack, dealer win!");
            PrintCurrentCard();
            output = false;
        }

        return output;
    }

    // when user is stand, then compare dealer's total and user's total. larger is winner.
    public void compare(){
        if (dealer.getTotal() == 21){
            System.out.println("----Dealer is Blackjack, dealer win!-----\nSummary:");
            PrintCurrentCard();
        }
        else if(dealer.getTotal() > 21){
            System.out.println("----Dealer is bust! User win!-----\nSummary: \n");
            PrintCurrentCard();
        }
        else if(user.getTotal() > dealer.getTotal() && dealer.getTotal() < 21 && dealer.getTotal() < 21 ){
            System.out.println("Both user and dealer are less than 21, then compare which one is larger.");
            PrintCurrentCard();
            System.out.println("----User win!----");
        }
        else if(user.getTotal() < dealer.getTotal() && dealer.getTotal() < 21 && dealer.getTotal() < 21 ){
            System.out.println("Both user and dealer are less than 21, then compare which one is larger.");
            PrintCurrentCard();
            System.out.println("----Dealer win!----");
        }
        else if(user.getTotal() == dealer.getTotal() && dealer.getTotal() < 21 && dealer.getTotal() < 21 ){
            System.out.println("Both user and dealer are less than 21, then compare which one is larger.");
            PrintCurrentCard();
            System.out.println("------Tie-----");
        }
    }
    public void PrintCurrentCard(){
        System.out.println( "---------------Dealer's cards is:-----------------" );
        dealer.PrintCard();
        System.out.println( "----------------User's cards is:-----------------" );
        user.PrintCard();
        System.out.println("\nuser has " + user.getTotal() + " || dealer has "+ dealer.getTotal());
    }

    public void start() {
        boolean player = true;
        if(playTurn()){ // play stand, then deal start to add card. if player already bust,then dealer win automatically without adding card
            dealerTurn();
            compare();
        }
        // user decide to stand. then only dealer to add card until it is larger than 21 or it is more than 17
        // if dealer is more than 17,then they compare.
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner( System.in );
        Blackjack test = new Blackjack();

        while (true) {
            test.deal();
            test.start();
            System.out.println( "\nif you want to play again" );
            if (!keyboard.next().equalsIgnoreCase( "yes" )) {
                System.out.println( "************   BlackJack Ending  *********** " );
                break;
            }

        }
    }
}


