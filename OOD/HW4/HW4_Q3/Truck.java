package com.company;

public class Truck extends Vehicle {
    private double load_tons;
    private double load_pounds;
    public Truck(){
        super();
        load_tons = 0;
        load_pounds = 0;
    }
    public Truck(String maker,int cylinders,Person owner,double tons,double pounds ){
        super(maker,cylinders,owner);
        this.load_tons = tons;
        this.load_pounds = pounds;
    }

    public Truck(Truck truck){
        super(truck);
        this.load_tons = truck.load_tons;
        this.load_pounds = truck.load_pounds;
    }

    public double getLoad_tons() {
        return load_tons;
    }
    public double getLoad_pounds(){
        return load_pounds;
    }
    public void setLoad_tons(double tons){
        this.load_tons = tons;
    }
    public void setLoad_pounds(double pounds){
        this.load_pounds = pounds;
    }
    public String toString(){
        return "the manufacturer is: " + getMaker()+"\n"+
                "the cylinders are: " + getCylinders() + "\n"+
                "the owner is: " + getName() + "\n"+
                "the load in tons is " + getLoad_tons() + "\n" +
                "the load in pounds is " + getLoad_pounds() + "\n";

    }
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        else if(getClass() != other.getClass()){
            return false;
        }
        else{
            Truck truck1 = (Truck) other;
            return (getMaker().equalsIgnoreCase(truck1.getMaker())
                    && getName().equalsIgnoreCase(truck1.getName())
                    && getCylinders()== truck1.getCylinders()
                    && getLoad_tons() == truck1.getLoad_tons() && getLoad_pounds()== truck1.getLoad_pounds());
        }
    }
}
