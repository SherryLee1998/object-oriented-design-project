package com.company;

import java.util.Scanner;

public class Circle implements Shape{
    private double radius;
    Scanner keyboard = new Scanner( System.in );

    Circle(){
        radius = 0;
    }
    Circle(Circle a){
        setRadius( a.radius );
    }
    Circle(double r){
        setRadius( r );
    }

    public void setRadius(double radius) {
        while (true) {
            if(radius > 0){
                this.radius = radius;
                break;
            }
            else {
                System.out.println("the radius should be positive.please enter again");
                radius = keyboard.nextDouble();
            }
        }
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        double area;
        area = radius * radius * Math.PI;
        return area;
    }
}
