package com.company;
package improved;
import javax.print.Doc;

public class Doctor extends SalariedEmployee {
        private String specialty;
        private double fee;

        public Doctor(String sherry, Date date1, String pediatrician, int i){
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
        return (getName( ) + " " + getHireDate( ).toString( )
                + "\n$" + getSalary() + " per year\n" + getspecialty()+ "speciality\n"+ getfee() + "office visit fee.\n");
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
            return (super.equals(otherDoctor)
                    && (getSalary() == otherDoctor.getSalary())&& (getspecialty() == otherDoctor.getspecialty()) && getfee() == otherDoctor.getfee());
        }
    }


}
