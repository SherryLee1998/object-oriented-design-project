package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
	// patient
        Date date1 = new Date(1,21,1998);
        Doctor doctor1 = new Doctor("Sherry",date1,1000,"pediatric",10);
        Patient patient1 = new Patient("Tom",doctor1);
        System.out.println("Patient 1 information:-------------");
        System.out.print(patient1.toString());
        System.out.println();
        System.out.println("Doctor 1 information:-------------");
        System.out.print(doctor1.toString());
        System.out.println();
     // patient 1 billing
        Billing billing1 = new Billing(patient1,doctor1,555);
        System.out.println("Billing 1 information:-------------");
        System.out.println(billing1.toString());
        System.out.println();

    // set for patient 2

        Date date2 = new Date();
        System.out.println("Doctor(2)'s hire day? year/ month/ day");
        date2.setYear(keyboard.nextInt());
        date2.setMonth(keyboard.nextInt());
        date2.setDay(keyboard.nextInt());

        Doctor doctor2 = new Doctor();
        doctor2.setHireDate(date2);

        System.out.println("Doctor(2)'s name?");
        doctor2.setName(keyboard.next());


        System.out.println("Doctor(2)'s speciality");
        doctor2.setSpecialty(keyboard.next());

        System.out.println("Doctor(2)'s salary");
        doctor2.setSalary(keyboard.nextInt());

        System.out.println("Doctor(2)'s visit fee");
        doctor2.setFee(keyboard.nextInt());

        System.out.println("Doctor 2 information:-------------");
        System.out.println(doctor2.toString());

        Patient patient2= new Patient();
        patient2.setDoctor1(doctor2);
        System.out.println("Patient(2)'s name?");
        patient2.setName(keyboard.next());
        System.out.println("Patient 2 information:-------------");
        System.out.println(patient2.toString());

        Billing billing2 = new Billing();
        billing2.setPatient1(patient2);
        billing2.setDoctor1(doctor2);
        System.out.println("the total due amount?for patient 2 ");
        billing2.setAmount(keyboard.nextInt());

        System.out.println("Billing 2 information:-------------");
        System.out.println(billing2.toString());

        System.out.println("Compare patent 1 and patent 2-------------");
        boolean output = billing1.equals(billing2);
        if(output){
            System.out.println("they are same");
        }
        else{
            System.out.println("they are not same");
        }
    }
}
