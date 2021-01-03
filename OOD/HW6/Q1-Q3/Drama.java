package com.company;

public class Drama extends Movie{
    public Drama(){
        super();
    }
    public Drama(String rank,String id,String name){
        super(rank,id, name);
    }
    public Drama(Drama a){
        super(a);
    }

    @Override
    public String toString(){
        return "Rank: " + getRank() + "\nID: " + getId_number() + "\nTitle: " + getTitle() + "\nType: Drama";
    }

    @Override
    public double calculateFees(int days){
        while(days<0){
            System.out.println("please enter a day again");
            days = keyboard.nextInt();
        }
        double fee = 0;
        fee = days * DRAMA;
        return  fee;
    }
}
