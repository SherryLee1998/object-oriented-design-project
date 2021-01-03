package com.company;

public class Main {

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Large",1,1,0);
        Pizza pizza2 = new Pizza("Medium",2,0,2);
        PizzaOrder order1 = new PizzaOrder();
        order1.setNumPizzas(2);
        order1.setPizza1(pizza1);
        order1.setPizza2(pizza2);
        double total = order1.calcTotal();
        System.out.println("Total of original order: " + total);

        PizzaOrder order2 = new PizzaOrder(order1);
        order2.getPizza1().setNumCheeseToppings(3);
        total = order2.calcTotal();
        double origTotal = order1.calcTotal();

        System.out.println("Total of copied and " + "modified order: " + total);
        System.out.println("Original total unchanged at: " + origTotal);
    }
}
