package com.company;

public class Billing {
    private Patient patient1;
    private Doctor doctor1;
    private double amount;

    public Billing() {
        patient1 = new Patient();
        doctor1 = new Doctor();
        amount = 0;
    }
    public Billing(Patient patient1, Doctor doctor1,double amount){
        this.patient1 = patient1;
        this.doctor1 = doctor1;
        this.amount = amount;
    }
    public Billing(Billing other){
        patient1 = new Patient(other.patient1);
        doctor1 = new Doctor(other.doctor1);
        amount = other.amount;
    }

    public void setDoctor1(Doctor doctor1) {
        this.doctor1 = doctor1;
    }

    public void setPatient1(Patient patient1) {
        this.patient1 = patient1;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Doctor getDoctor1() {
        return doctor1;
    }
    public Patient getPatient1(){
        return patient1;
    }

    public double getAmount() {
        return amount;
    }
    public String toString( )
    {
        return ("Patient name: "+ getPatient1().getName() + "\n" +
                "Doctor's Name: "+ getDoctor1().getName() + "\n"+
                "total amount to be due: "+ getAmount());

    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Billing otherpatient = (Billing) otherObject;
            return ( patient1.equals(otherpatient.getPatient1()) && (doctor1.equals(otherpatient.getDoctor1())) && amount== otherpatient.getAmount());
        }
    }
}
