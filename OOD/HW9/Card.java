package com.company;

public class Card implements Comparable{
    private int suit;
    private int name;
    public static final int DIAMOND = 1;
    public static final int CLUB = 2;
    public static final int HEART = 3;
    public static final int SPADE = 4;
    public static final int SUIT_MIN = DIAMOND;
    public static final int SUIT_MAX = SPADE;

    private static final String[] SUIT_NAMES = {
            "",
            "DIAMOND",
            "CLUB",
            "HEART",
            "SPADE",
    };

    private static final String[] SUIT_SYMBOLS = {
            "",
            "♦",
            "♣",
            "♥",
            "♠",
    };

    public Card(String suit, String name){
        setSuit(suit);
        setName(name);
    }

    public Card(int suit, int name){
        setSuit(suit);
        setName(name);
    }

    //mutators
    public void setSuit(String suit){
        if(suit == null || suit.isEmpty()){
            System.out.println("Suit cannot be null or empty");
            System.exit(0);
        }

        switch(suit.toUpperCase()){
            case "DIAMOND":
                setSuit(DIAMOND);
                break;
            case "CLUB":
                setSuit(CLUB);
                break;
            case "HEART":
                setSuit(HEART);
                break;
            case "SPADE":
                setSuit(SPADE);
                break;
            default:
                System.out.println("Invalid suit");
                System.exit(0);
        }
    }

    public void setSuit(int suit) {
        if (suit < SUIT_MIN || suit > SUIT_MAX) {
            System.out.println("Suit number is out of range");
            System.exit(0);
        }
        this.suit = suit;
    }

    public void setName(String name){
        if(name == null || name.isEmpty()){
            System.out.println("Name cannot be null or empty");
            System.exit(0);
        }
        switch(name.toUpperCase()){
            case "ACE":
                this.name = 1;
                break;
            case "10":
                this.name = 10;
                break;
            case "JACK":
                this.name = 11;
                break;
            case "QUEEN":
                this.name = 12;
                break;
            case "KING":
                this.name = 13;
                break;
            default: {
                int ascii = (int) name.charAt(0);
                if (name.length() != 1 || ascii < '1' || ascii > '9') {
                    System.out.println("Invalid name.");
                    System.exit(0);
                }
                setName(ascii - '0');
                break;
            }
        }
    }

    public void setName(int name) {
        if (name < 1 || name > 13) {
            System.out.println("Name is out of range");
            System.exit(0);
        }
        this.name = name;
    }


    //accessor
    //get suit name
    public String getSuit(){
        return SUIT_NAMES[suit];
    }

    public String getName() {
        switch (name) {
            case 1:
                return "ACE";
            case 11:
                return "JACK";
            case 12:
                return "QUEEN";
            case 13:
                return "KING";
            default:
                return String.valueOf(name);
        }
    }

    public int getSuitNumber(){
        return suit;
    }

    public int getNameNumber(){
        return name;
    }

    private String getNameSymbol() {
        switch (name) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(name);
        }
    }

    public String toString(){
        return SUIT_SYMBOLS[suit] + getNameSymbol();
    }

    @Override
    public int compareTo(Object otherObject){
        if (otherObject == null || otherObject.getClass() != getClass()){
            System.out.println("Invalid Input");
            System.exit(0);
        }
        Card otherCard = (Card)otherObject;
        return name - otherCard.getNameNumber();
    }

    public static void main(String[] args){
        Card card1 = new Card("DIAMOND", "10");
        Card card2 = new Card(2,13);
        System.out.println(card1);
        System.out.println(card2.getSuit() + " " + card2.getName());

        Card card3 = new Card("Spade", "KING");
        System.out.println(card3);

        card3.setSuit("Heart");
        card3.setName(1);
        System.out.println(card3);


    }
}
