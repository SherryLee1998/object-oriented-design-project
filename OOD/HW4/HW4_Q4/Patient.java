package com.company;

import java.util.Objects;

public class Patient extends Person {
    private Doctor doctor1;
    Patient(){
        super();
        doctor1 = new Doctor();
    }
    Patient(String name, Doctor doctor2){
        super(name);
        this.doctor1 = doctor2;
    }
    Patient(String name, String Doctor_Name, String specialty1, double fee1){
        super(name);
        doctor1.setName(Doctor_Name);
        doctor1.setSpecialty(specialty1);
        doctor1.setFee(fee1);

    }

    Patient(Patient object){
        super(object);
        this.doctor1 = new Doctor(object.doctor1);
    }

    public void setDoctor1(Doctor doctor1) {
        this.doctor1 = doctor1;
    }
    public Doctor getDoctor1(){
        return  doctor1;
    }

    public String toString() {
        return "Patient: " + super.getName() +"\n" +
                "doctor name: " + doctor1.getName() + "\n"+
                "doctor specialize: " + doctor1.getspecialty() + "\n" +
                "doctor hire day: " + doctor1.getHireDate().toString() +"\n"+
                "doctor's visit fee: " + doctor1.getfee()+ "\n";
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        Patient patient = (Patient) other;
        return (this.getName().equals(patient.getName())
        && this.getDoctor1().equals(patient.getDoctor1()));
    }

}
