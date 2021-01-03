package com.company;
import javax.print.Doc;

public class Doctor extends SalariedEmployee {
    private String specialty;
    private double fee;

    public Doctor(String name, Date date1, String pediatrician, int i){
        super();
        specialty = "TBD";
        fee = 0;
    }
    public Doctor(){
        super();
        specialty = "TBD";
        fee = 0;
    }
    public Doctor(String theName, Date theDate, double theSalary, String specialty1, double fee1)
    {
        super(theName, theDate,theSalary);
        this. specialty =specialty1;
        this.fee = fee1;
    }

    public Doctor(Doctor doctor){
        super(doctor);
        this.specialty = doctor.specialty;
        this.fee = doctor.fee;
    }

    public String getspecialty(){
        return specialty;
    }
    public double getfee(){
        return fee;
    }
    public void setSpecialty(String specialty1){
        if(specialty1.equalsIgnoreCase(" ")){
            System.out.println("Fatal Error: Negative salary.");
            System.exit(0);
        }

        else{
            specialty = specialty1;
        }
    }
    public void setFee(double fee1){
        if ( fee1 >= 0)
            fee = fee1;
        else
        {
            System.out.println("Fatal Error: Negative salary.");
            System.exit(0);
        }
    }
    public String toString( )
    {
        return ("Doctor: " + getName( ) + "\n" +
                "Hire day: "+ getHireDate( ).toString() + "\n"+
                "Salary: $" + getSalary() + "\n" +
                "speciality: " +getspecialty()+ "\n"+
                "office visit fee: " + getfee() + "\n");
    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            Doctor otherDoctor = (Doctor) otherObject;
            return (getName().equals(otherDoctor.getName())
                    && getHireDate().equals(getHireDate())
                    && (getSalary() == otherDoctor.getSalary())
                    && getspecialty().equals(otherDoctor.getspecialty())
                    && getfee() == otherDoctor.getfee());
        }
    }


}
