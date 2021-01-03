package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    private ArrayList<Card> deck;

    Deck(){
        deck = new ArrayList<Card> ();
        build();
    }

    public void PrintCard(){
        for(Card entry: deck){
            System.out.println(entry);
        }
    }

    public void Shuffle()
    {
        Collections.shuffle(deck);
    }

    public void addCard(Card a){
        deck.add( a );
    }

    public Card removes(){
        if(!deck.isEmpty()){
           return deck.remove( 0 );

        }
        return null;
    }

    public void sort(){
        StringSelectionSort.sort(deck);
    }
    public int size(){
        return deck.size();
    }

    private void build(){
        String[] suitName = {"Clubs", "Diamonds","Hearts","Spades"};
        for(int i = 0; i < 4; i ++){
            for(int a = 1; a <= 13; a++){
                Card card = new Card(suitName[i],a);
                deck.add( card );
            }
        }
    }

    public void reset(){
        deck.clear();
        build();
        Shuffle();
    }


}
