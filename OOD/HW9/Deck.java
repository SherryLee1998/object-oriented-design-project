package com.company;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    protected ArrayList<Card> cards;

    // A special constructor different from the default constructor, which is only used to create an empty list of cards.
    protected Deck(int doNotMatter) {
        cards = new ArrayList<>();
    }

    public Deck() {
        cards = new ArrayList<>(52);
        for (int suit = Card.SUIT_MIN; suit <= Card.SUIT_MAX; suit++) {
            for (int name = 1; name < 14; name++) {
                cards.add(new Card(suit, name));
            }
        }
    }

    // print all the cards with five cards in a line
    public void printCards(){
        for(int i = 0; i < cards.size(); i++){
            System.out.print(cards.get(i) + " ");
            if((i+1) % 5 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public void shuffleCards(){
        for(int i = 0 ; i < 1000; i++){
            int x = (int)(Math.random()* cards.size()) ;
            int y = (int)(Math.random()* cards.size()) ;
            Card temp = cards.get(x);
            cards.set(x, cards.get(y));
            cards.set(y, temp);
        }
    }

    public void addCard(Card newCard){
        if(newCard == null){
            System.out.println("Card object cannot be null");
            System.exit(0);
        }
        cards.add(newCard);
    }

    public Card removeFirstCard(){
        if(cards.size() == 0){
            System.out.println("Empty deck");
            System.exit(0);
        }
        return cards.remove(0);
    }


    public void sortCard(){
        Collections.sort(cards);
    }

    public int size(){
        return cards.size();
    }

    public Card getCard(int i) {
        if(i < 0 || i >= cards.size()){
            System.out.println("getCard index out of range");
            System.exit(0);
        }
        return cards.get(i);
    }

    public static void main(String[] args){
        Deck cardList = new Deck();
        System.out.println("-----------Before shuffles----------");
        System.out.printf("Size of deck is %d\n", cardList.size());
        cardList.printCards();
        cardList.shuffleCards();
        System.out.println("-----------After shuffles----------");
        cardList.printCards();

        System.out.println("-----------Two cards have been removed----------");
        Card card1 = cardList.removeFirstCard();
        Card card2 = cardList.removeFirstCard();
        System.out.println(card1);
        System.out.println(card2);

        System.out.println("-----------Sorted remaining cards----------");
        System.out.printf("Size of deck is %d\n", cardList.size());
        cardList.sortCard();
        cardList.printCards();

        cardList.addCard(card1);
        cardList.addCard(card2);
        cardList.printCards();
        System.out.println("-----------Add two removed card back to the deck----------");
        System.out.printf("Size of deck is %d\n", cardList.size());
        cardList.printCards();


    }


}
