package com.company;
import java.util.ArrayList;

public class Hand extends Deck {

    public Hand(){
        super(0);
    }

    public void returnHand(Deck deck){
        while(size() > 0){
            deck.addCard(removeFirstCard());
        }
    }

    public static void main(String[] args){
        Deck deck = new Deck();
        deck.shuffleCards();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        for(int i = 0; i < 5; i++){
            hand1.addCard(deck.removeFirstCard());
        }

        for(int i = 0; i < 5; i++){
            hand2.addCard(deck.removeFirstCard());
        }

        System.out.printf("Size of hand1 is %d\n", hand1.size());
        hand1.printCards();
        System.out.println("----Sorted hand1----");
        hand1.sortCard();
        hand1.printCards();

        System.out.printf("Size of hand2 is %d\n", hand2.size());
        hand2.printCards();
        System.out.println("----Sorted hand2----");
        hand2.sortCard();
        hand2.printCards();

        System.out.println("-----------------------");
        System.out.printf("Size of deck is %d\n", deck.size());
        deck.printCards();

        System.out.println("---After return-------");
        hand1.returnHand(deck);
        hand2.returnHand(deck);
        System.out.printf("Size of deck is %d\n", deck.size());
        deck.printCards();
        System.out.println("----Sorted deck-------");
        deck.sortCard();
        deck.printCards();


    }
}
