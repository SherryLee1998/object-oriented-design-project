package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.JarEntry;

public class Hand extends Deck {
    private ArrayList<Card> hand;
    Hand(){
        super();
        hand = new ArrayList<Card>(0);
    }
    Hand(int a){
        hand = new ArrayList<Card>(a);
    }

    public void PrintCard(){
        for(Card entry: hand){
            System.out.println(entry);
        }
    }

    public void Shuffle()
    {
        Collections.shuffle(hand);
    }

    public void addCard(Card a){
        hand.add( a );
    }

    public Card removes(){
        if(!hand.isEmpty()){
            return hand.remove( 0 );

        }
        return null;
    }

    public void sort(){
        StringSelectionSort.sort(hand);
    }

    public int getTotal(){
        int sum = 0;
        for(Card a: hand){
            sum += a.getNameForSum();
        }

        if(hand.contains(new Card("Clubs",1)) ||hand.contains( new Card("Diamonds",1))
                || hand.contains( new Card("Hearts",1))
                ||hand.contains( new Card("Spades",1)))
        {
            sum = sum + 10;
            if (sum == 21) return sum;
            else return sum - 10;
        }
        return sum;
    }

    public void reset(){
        hand.clear();
    }

    public int size(){
        return hand.size();
    }
    public Card get(){
        return hand.get( 0 );
    }
    public String toString(){
        String output = null;
        for(int i =0; i < size();i++){
            output = output + "card is: " + hand.get( i );
        }
        return output;
    }
}
