package com.company;

public class Comedy extends Movie {
    public Comedy(){
        super();
    }
    public Comedy(String rank,String id,String name){
        super(rank,id, name);
    }
    public Comedy(Comedy a){
        super(a);
    }

    @Override
    public String toString(){
        return "Rank: " + getRank() + "\nID: " + getId_number() + "\nTitle: " + getTitle() + "\nType: Comedy";
    }

    @Override
    public double calculateFees(int days){
        while(days<0){
            System.out.println("please enter a day again");
            days = keyboard.nextInt();
        }
        double fee = 0;
        fee = days * COMEDY;
        return  fee;
    }
}
