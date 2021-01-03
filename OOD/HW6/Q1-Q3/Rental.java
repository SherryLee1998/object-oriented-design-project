package com.company;

import java.util.Scanner;

public class Rental {
    private Movie movie;
    private int customerID = 000;
    private int late_day = 0;

    public Rental(){
        movie = null;
        customerID = 000;
        late_day = 0;
    }

    public Rental(Movie a,int customer_id, int day){
        movie = a;
        this.customerID = customer_id;
        this.late_day = day;

    }

    public Rental(Rental a){
        a.movie = movie;
       a.customerID = customerID;
       a.late_day = late_day;

    }

    public void setCustomerID(int customerID) {
        if(customerID > 0)
            this.customerID = customerID;
        else{
            System.out.println("Error: improper id value.");
            System.exit(0);
        }
    }

    public void setLate_day(int late_day) {
        if(late_day > 0)
            this.late_day = late_day;
        else{
            System.out.println("Error: improper day value.should be larger than 0");
            System.exit(0);
        }
    }

    public int getCustomerID() {
        return customerID;
    }
    public int getLate_day(){
        return late_day;
    }

    public double calculateFees(){
        double fee;
        fee = movie.calculateFees(getLate_day());
        return fee;
    }

    public static double lateFeesOwed(Rental[] rentals1, int size){
        double sum = 0;
        if(size<0){
            System.out.println("invalid size");
            return 0;
        }
        for(int i =0 ;i < size ;i++){
            sum += rentals1[i].calculateFees();
        }
        return sum;
    }

    public String toString() {
        return  movie.toString() +
                "\ncustomer ID: " + customerID +
                "\nlate_day: " + late_day +
                "\nlate fee: " + calculateFees()+"\n";
    }

    public static void main(String[] args) {
        System.out.println("——————————————test for rental ————————————————");

        int size = 3;
        Rental[] rentals1 = new Rental[size];
        Action action1 = new Action("R","C001","action movie 1");
        Comedy comedy1 = new Comedy("R","M0331","comedy movie 1");
        Drama drama1 = new Drama("GP7","E001","drama movie 1");

        rentals1[0] = new Rental(action1,9987,10);
        rentals1[1] = new Rental(comedy1,102394,1);
        rentals1[2] = new Rental(drama1,19234,2);

        for(int i = 0 ;i < size ; i++){
            System.out.println(rentals1[i]);
        }

        double fee = Rental.lateFeesOwed(rentals1,size);
        System.out.println("Total fees that are outstanding: " + fee);

        System.out.println("——————————————test for rental  ————————————————");
        rentals1[0].setCustomerID(10011);
        rentals1[1].setLate_day(200);

        for(int i = 0 ;i < size ; i++){
            System.out.println(rentals1[i]);
        }

        fee = Rental.lateFeesOwed(rentals1,size);
        System.out.println("Total fees that are outstanding: " + fee);

    }

}


