package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("---------after shuffling-----------");
        deck.Shuffle();
        deck.PrintCard();

        System.out.println("---------For remove and adding to head 1----------");
        Hand head1 = new Hand(5);
        for(int i =0 ; i < 5; i++){
            head1.addCard(deck.removes());
        }
        System.out.println("--------- head1:----------");
        head1.PrintCard();
        System.out.println("--------- deck:----------");
        deck.PrintCard();


        Hand head2 = new Hand(5);
        System.out.println("---------For remove and adding to head 2----------");
        for(int i =0 ; i < 5; i++){
            head2.addCard(deck.removes());
        }
        System.out.println("---------After removing: head2:----------");
        head2.PrintCard();
        System.out.println("---------After removing: deck:----------");
        deck.PrintCard();


        System.out.println("--------put back to deck-------------------------");
        System.out.println("--------After returning and sorting: deck ----------");
        for(int i =0 ; i < 5; i++){
            deck.addCard(head1.removes());
            deck.addCard(head2.removes());
        }
        deck.sort();
        deck.PrintCard();

        System.out.println("--------After returning: hand1---------");
        head1.PrintCard();
        System.out.println("--------After returning: hand2---------");
        head2.PrintCard();

    }
}
