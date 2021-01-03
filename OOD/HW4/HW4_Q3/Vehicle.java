package com.company;

public class Vehicle extends Person {
    private String maker;
    private int cylinders;
    public Vehicle(){
        super();
        maker = "TBD";
        cylinders = 0;
    }
    public Vehicle(String maker,int cylinders,Person owner){
        super(owner);
        this.maker = maker;
        this.cylinders = cylinders;
    }
    public Vehicle(Vehicle v){
        super();
        maker = v.maker;
        cylinders = v.cylinders;
    }
    public String getMaker(){
        return maker;
    }
    public int getCylinders(){
        return cylinders;
    }
    public void setMaker(String makerName){
        this.maker = makerName;
    }
    public void setCylinders(int cylinders){
        this.cylinders = cylinders;
    }
    public String toString(){
        return  "the manufacturer is: " + getMaker()+"\n"+
                "the cylinders are: " + getCylinders() + "\n"+
                "the owner is" + getName() + "\n";
    }
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        else if(getClass() != other.getClass()){
            return false;
        }
        else{
            Vehicle othervehicle =(Vehicle) other;
            return (this.getMaker().equalsIgnoreCase(othervehicle.getMaker())
                    && getMaker() == othervehicle.getMaker()
                    && getCylinders()== othervehicle.getCylinders());
        }
    }
}
