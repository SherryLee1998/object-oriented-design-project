package com.company;

import java.util.Scanner;

public class Movie {
    public final static double MOVIE = 2;
    public final static double ACTION = 3;
    public final static double COMEDY = 2.5;
    public final static double DRAMA = 2;

    Scanner keyboard = new Scanner(System.in);
    private String rank;
    private String id_number;
    private String title;

    public  Movie(){
        rank = "No type yet";
        id_number = "A000";
        title = "No title yet";

    }

    public Movie(String rank,String id,String name){
        setRank(rank);
        setId_number(id);
        setTitle(name);
    }
    public Movie(Movie a){
        if(a == null){
            System.out.println("Error: null Sale object.");
            System.exit(0);
        }
        rank = a.rank;
        id_number = a.id_number;
        title = a.title;
    }
    public void setRank(String type) {
        if(type != null && type != "")
            this.rank = type;
        else{
            System.out.println("Error: improper type value.");
            System.exit(0);
        }
    }

    public void setId_number(String id_number) {
       if(id_number != null&& id_number != "")
        this.id_number = id_number;
       else{
           System.out.println("Error: improper ID value.");
           System.exit(0);
       }
    }

    public void setTitle(String title) {
        if(title != null && title != "")
            this.title = title;
        else{
            System.out.println("Error: improper title value.");
            System.exit(0);
        }
    }

    public String getRank(){
        return rank;
    }
    public String getTitle(){
        return title;
    }
    public String getId_number(){
        return id_number;
    }
    public String toString(){
        return "Rank: " + rank + "\nMovie ID: " + id_number + "\nTitle: " + title;
    }
    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
//        else if(getClass() != otherObject.getClass())
//            return false;
        else{
            Movie otherMovie = (Movie) otherObject;
            return (id_number.equals(otherMovie.id_number));
        }
    }

    public double calculateFees(int days){
        while(days<0){
            System.out.println("please enter a day again");
            days = keyboard.nextInt();
        }
        double fee = days * MOVIE;
        return fee;
    }


}
