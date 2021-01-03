package com.company;

public class PizzaOrder {
    private Pizza pizza1, pizza2, pizza3;
    private int numPizzas;

    public PizzaOrder()
    {
        numPizzas = 0;
        pizza1 = null;
        pizza2 = null;
        pizza3 = null;
    }

    public PizzaOrder(PizzaOrder order)
    {
        numPizzas = order.numPizzas;
        pizza1 = null;
        pizza2 = null;
        pizza3 = null;
        Pizza test = order.getPizza1();
        if (test != null)
        {
            pizza1 = new Pizza(test.getSize(), test.getNumCheeseToppings(), test.getNumHamToppings(), test.getNumPepperoniToppings());
        }
        test = order.getPizza2();
        if (test != null)
        {
            pizza2 = new Pizza(test.getSize(), test.getNumCheeseToppings(), test.getNumHamToppings(), test.getNumPepperoniToppings());
        }
        test = order.getPizza3();
        if (test != null)
        {
            pizza3 = new Pizza(test.getSize(), test.getNumCheeseToppings(), test.getNumHamToppings(), test.getNumPepperoniToppings());
        }
    }

    public void setNumPizzas(int num)
    {
        numPizzas = num;
    }

    public int getNumPizzas()
    {
        return numPizzas;
    }

    public void setPizza1(Pizza pizza)
    {
        pizza1 = pizza;
    }

    public void setPizza2(Pizza pizza)
    {
        pizza2 = pizza;
    }

    public void setPizza3(Pizza pizza)
    {
        pizza3 = pizza;
    }

    public Pizza getPizza1()
    {
        if (numPizzas > 0)
            return pizza1;
        else
            return null;
    }

    public Pizza getPizza2()
    {
        if (numPizzas > 1)
            return pizza2;
        else
            return null;
    }

    public Pizza getPizza3()
    {
        if (numPizzas > 2)
            return pizza3;
        else
            return null;
    }

    public double calcTotal()
    {
        double total = 0;
        if (numPizzas >= 1)
            total += pizza1.calcCost();
        if (numPizzas >= 2)
            total += pizza2.calcCost();
        if (numPizzas >= 3)
            total += pizza3.calcCost();
        return total;
    }
}

