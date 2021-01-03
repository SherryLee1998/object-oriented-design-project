package com.company;

public class Action extends Movie {
    public Action(){
        super();
    }
    public Action(String rank,String id,String name){
        super(rank,id, name);
    }
    public Action(Action a){
        super(a);
    }

    @Override
    public String toString(){
        return "Rank: " + getRank() + "\nID: " + getId_number() + "\nTitle: " + getTitle() + "\nType: Action";
    }

    @Override
    public double calculateFees(int days){
        while(days<0){
            System.out.println("please enter a day again");
            days = keyboard.nextInt();
        }
        double fee = 0;
        fee = days * ACTION;
        return  fee;
    }

}
