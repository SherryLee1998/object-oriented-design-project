package com.company;

import java.util.Random;
import java.util.Scanner;

public class Rectangle implements Shape {
    private double height;
    private double width;
    Scanner keyboard = new Scanner( System.in );

    Rectangle(){
        height = 0;
        width = 0;
    }
    Rectangle(double h,double w){
        setHeight( h );
        setWidth( w );
    }
    Rectangle(Rectangle r){
        setHeight( r.height );
        setWidth( r.width );
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        while (true){
            if( height > 0 ){
                this.height= height;
                break;
            }
            else {
                System.out.println("the height should be positive.please enter again");
                height = keyboard.nextDouble();
            }
        }
    }

    public void setWidth(double width) {
        while (true){
            if(width > 0) {
                this.width = width;
                break;
            }
            else{
                System.out.println("the width should be positive,please enter again");
                width = keyboard.nextDouble();
            }
        }
    }

    @Override
    public double area() {
        double area;
        area = height * width ;
        return area;
    }
}
