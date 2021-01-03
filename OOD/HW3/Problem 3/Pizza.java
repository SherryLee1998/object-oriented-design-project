package com.company;
public class Pizza
{
    private String size;
    private int numCheeseToppings;
    private int numHamToppings;
    private int numPepperoniToppings;

    public Pizza()
    {
        size = "Large";
        numCheeseToppings = 1;
        numHamToppings = 0;
        numPepperoniToppings = 0;
    }

    public Pizza(String pizzaSize, int cheese,
                 int ham, int pepperoni)
    {
        size = pizzaSize;
        numCheeseToppings = cheese;
        numHamToppings = ham;
        numPepperoniToppings = pepperoni;
    }

    public void setPizzaInfo(String newSize, int cheese, int ham, int pepperoni)
    {
        size = newSize;
        numCheeseToppings = cheese;
        numHamToppings = ham;
        numPepperoniToppings = pepperoni;
    }

    public String getSize()
    {
        return size;
    }

    public int getNumCheeseToppings()
    {
        return numCheeseToppings;
    }

    public int getNumHamToppings()
    {
        return numHamToppings;
    }

    public int getNumPepperoniToppings()
    {
        return numPepperoniToppings;
    }

    public double calcCost()
    {
        double baseCost = 10;
        if (size.equals("Small"))
        {
            baseCost = 10;
        }
        else if (size.equals("Medium"))
        {
            baseCost = 12;
        }
        else if (size.equals("Large"))
        {
            baseCost = 14;
        }
        else
        {
            System.out.println("Error, unknown size.");
            return 0;
        }
        return baseCost +
                (numHamToppings + numCheeseToppings +
                        numPepperoniToppings)*2;
    }

    public String getDescription()
    {
        return "Size: " + size + ", Cheese Toppings: " + numCheeseToppings + " Pepperoni Toppings: " + numPepperoniToppings + " Ham Toppings: " + numHamToppings + ". Cost: " + calcCost();
    }


    public void setNumCheeseToppings(int numCheeseToppings) {
        this.numCheeseToppings = numCheeseToppings;
    }
    public void setNumPepperoniToppings(int numPepperoniToppings) {
        this.numPepperoniToppings = numPepperoniToppings;
    }
    public void setNumHamToppings(int numHamToppings) {
        this.numHamToppings = numHamToppings;
    }
} // Question 11
