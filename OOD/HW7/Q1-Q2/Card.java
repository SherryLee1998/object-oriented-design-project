package com.company;
import java.util.Objects;

public class Card {
    private String suit;
    private int name;

    Card(){
        suit = "TBD";
        name = 0;
    }

    Card(String suit1 , int name1){
        suit = suit1;
        name = name1;
    }
    Card(Card c){
        suit = c.suit;
        name = c.name;
    }

    public String getSuit(){
        return suit;
    }
    public String getName(){
       if(name== 1)return "Ace";
       else if(name == 2) return "2";
       else if(name == 3) return "3";
       else if(name == 4) return "4";
       else if(name == 5) return "5";
       else if(name == 6) return "6";
       else if(name == 7) return "7";
       else if(name == 8) return "8";
       else if(name == 9) return "9";
       else if(name == 10) return "10";
       else if(name == 11) return "Jack";
       else if(name == 12 ) return "Queen";
       else if(name == 13 ) return "King";
       else return "error";
    }
    public int getNameForSum(){
        if(name== 1)return 1;
        else if(name == 2) return 2;
        else if(name == 3) return 3;
        else if(name == 4) return 4;
        else if(name == 5) return 5;
        else if(name == 6) return 6;
        else if(name == 7) return 7;
        else if(name == 8) return 8;
        else if(name == 9) return 9;
        else if(name == 10) return 10;
        else if(name == 11) return 10;
        else if(name == 12 ) return 10;
        else if(name == 13 ) return 10;
        else return 0;
    }


    public void setName(int name) {
        if(name < 0|| name > 13){
            System.out.println("error: name should be from 1 to 13");
        }
        else {
            this.name = name;
        }
    }


    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card: " + getSuit() + " " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals( suit, card.suit ) &&
                Objects.equals( name, card.name );
    }

    public int compareTo(Object min) {
        if(min == null){
            System.out.println("error");
            System.exit( 0 );
        }
        if(this.getClass() != min.getClass()){
            System.out.println("error");
            System.exit( 0 );
        }
        Card other = (Card) min;
        return (this.name - other.name);

    }
}
