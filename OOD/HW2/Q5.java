package com.company;

public class Pizza {
    private String size;
    private int chase;
    private int pepperoni;
    private int ham;

    public Pizza(){
        this.size = "";
        this.chase = 0;
        this.pepperoni = 0;
        this.ham =0;
    }
    
    public Pizza(String size, int chase, int pepperoni, int ham){
        this.size = size;
        this.chase = chase;
        this.pepperoni = pepperoni;
        this.ham = ham;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }
    public int getChase(){
        return chase;
    }
    public void setChase(){
        this.chase = chase;
    }
    public int getPepperoni(){
        return pepperoni;
    }
    public void setPepperoni(){
        this.pepperoni = pepperoni;
    }
    public int getHam(){
        return ham;
    }
    public void setHam(){
        this.ham = ham;
    }
    public double cost(){
        if(size.equalsIgnoreCase("small")){
            return 10 +(chase + pepperoni + ham)*2;
        }
        if(size.equalsIgnoreCase("medium")){
            return 12 +(chase + pepperoni + ham)*2;
        }
        if(size.equalsIgnoreCase("large")){
            return 14 +(chase + pepperoni + ham)*2;
        }
        else
            return 0;
    }
    public String getOutput(){
        return "\n Size: " + size + "\n chase: " + chase + "\n pepperoni: "+ pepperoni + "\n ham: " + ham + "\n total cost: "+ cost() + "\n";
    }

    public static void main(String[] args) {
        
        Pizza pizza_1 = new Pizza("large", 5,1,2);
        Pizza pizza_2 = new Pizza("small", 3, 2, 2);
        Pizza pizza_3 = new Pizza("medium", 1, 1, 2);

        System.out.println(pizza_1.getOutput());
        System.out.println(pizza_2.getOutput());
        System.out.println(pizza_3.getOutput());
    }
}
