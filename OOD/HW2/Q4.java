import java.util.Scanner;
package com.company;

public class Date
{
        private int month;
        private int day;
        private int year;

        public Date()
        {
                month = 1;
                day = 1;
                year = 1000;
        }

        public Date(int monthInt, int day, int year)
        {
                setDate(monthInt, day, year);
        }

        public Date(String mmString, int day, int year)
        {
                setDate(mmString, day, year);
        }

        public Date(int year)
        {
                setDate(1, 1, year);
        }

        public Date(Date aDate)
        {
                if (aDate == null)
                {
                        System.out.println("found Error.");
                        System.exit(0);
                }

                month = aDate.month;
                day = aDate.day;
                year = aDate.year;
        }

        public void setDate(int monthInt, int day, int year)
        {

                if (dateConform(monthInt, day, year))
                {
                        this.month = monthInt;
                        this.day = day;
                        this.year = year;
                } else {
                        System.out.println("Fatal Error");
                        System.exit(0);
                }
        }

        public void setDate(String monthString, int day, int year)
        {

                if (dateConform(monthString, day, year))
                {
                        this.month = mmInteger(monthString);
                        this.day = day;
                        this.year = year;
                } else {
                        System.out.println("Fatal Error");
                        System.exit(0);
                }
        }

        public void setDate(int year)
        {
                setDate(1, 1, year);
        }

        public void setYear(int year)
        {

                if (year < 1000 || year > 9999) {
                        System.out.println("Fatal Error");
                        System.exit(0);
                } else
                        this.year = year;
        }

        public void setMonth(int monthNum)
        {

                if (monthNum <= 0 || monthNum > 12)
                {
                        System.out.println("Fatal Error");
                        System.exit(0);
                } else
                        month = monthNum;
        }

        public void setDay(int day)
        {

                if (day <= 0 || day > 31)
                {
                        System.out.println("Fatal Error");
                        System.exit(0);
                } else
                        this.day = day;
        }

        public int getMonth()
        {
                return month;
        }

        public int getDay()
        {
                return day;
        }

        public int getYear()
        {
                return year;
        }

        public String toString()
        {
                return mmString(month) + " " + day + ", " + year;
        }

        public boolean equals(Date otherDate)
        {
                return (month == otherDate.month) && (day == otherDate.day) && (year == otherDate.year);
        }

        public boolean precedes(Date otherDate)
        {
                return (year < otherDate.year) || (year == otherDate.year && month < otherDate.month)
                        || (year == otherDate.year && month == otherDate.month && day < otherDate.day);
        }

        public void readInput()
        {
                boolean tryAgain = true;
                Scanner keyboard = new Scanner(System.in);
                while (tryAgain) {
                        System.out.println("Enter a month number, day, and year.");
                        System.out.println("Separate each by space.");
                        int monthInput = keyboard.nextInt();
                        int dayInput = keyboard.nextInt();
                        int yearInput = keyboard.nextInt();
                        if (dateConform(monthInput, dayInput, yearInput))
                        {
                                setDate(monthInput, dayInput, yearInput);
                                tryAgain = false;
                        } else
                                System.out.println("Illegal date. Reenter input.");
                }
        }

        private boolean dateConform(int mmInteger, int dayInt, int yearInt)
        {
                return mmInteger >= 1 && mmInteger <= 12 && dayInt >= 1 && dayInt <= 31 && yearInt >= 1000 && yearInt <= 9999;
        }

        private boolean dateConform(String mmString, int dayInt, int yearInt)
        {
                return monthOK(mmString) && dayInt >= 1 && dayInt <= 31 && yearInt >= 1000 && yearInt <= 9999;
        }

        private boolean monthOK(String mmString)
        {

                return mmString.equals("January") || mmString.equals("February") || mmString.equals("March")
                        || mmString.equals("April") || mmString.equals("May") || mmString.equals("June")
                        || mmString.equals("July") || mmString.equals("August") || mmString.equals("September")
                        || mmString.equals("October") || mmString.equals("November") || mmString.equals("December");
        }

        private String mmString(int monthNum)
        {
                switch (monthNum)
                {
                        case 1:
                                return "January";
                        case 2:
                                return "February";
                        case 3:
                                return "March";
                        case 4:
                                return "April";
                        case 5:
                                return "May";
                        case 6:
                                return "June";
                        case 7:
                                return "July";
                        case 8:
                                return "August";
                        case 9:
                                return "September";
                        case 10:
                                return "October";
                        case 11:
                                return "November";
                        case 12:
                                return "December";
                        default:
                                System.out.println("Fatal Error");
                                System.exit(0);
                                return "Error";
                }
        }

        private int mmInteger(String mmString)
        {
                if (mmString.equals("January"))
                        return 1;
                else if (mmString.equals("February"))
                        return 2;
                else if (mmString.equals("March"))
                        return 3;
                else if (mmString.equals("April"))
                        return 4;
                else if (mmString.equals("May"))
                        return 5;
                else if (mmString.equals("June"))
                        return 6;
                else if (mmString.equals("July"))
                        return 7;
                else if (mmString.equals("August"))
                        return 8;
                else if (mmString.equals("September"))
                        return 9;
                else if (mmString.equals("October"))
                        return 10;
                else if (mmString.equals("November"))
                        return 11;
                else if (mmString.equals("December"))
                        return 12;
                else
                        return -1;
        }

        public static void main(String[] args)
        {


                Date d1 = new Date("June", 20, 1998);
                Date d2 = new Date();// initial set with 1/1/1000
                Date d3 = new Date(2016);
                Date d4 = new Date(1, 21, 1998);
                System.out.println(d1.toString());
                System.out.println(d2.toString());
                System.out.println(d3.toString());
                System.out.println(d4.toString());
                System.out.println();

                System.out.println("Date1 month: " + d1.getMonth());
                System.out.println("Date1  day: " + d1.getDay());
                System.out.println("Date1 year " + d1.getYear());
                System.out.println();

                d1.setDate(10, 17, 2016);
                System.out.println("After setting new date:");
                System.out.println("Date1 month: " + d1.getMonth());
                System.out.println("Date1 day: " + d1.getDay());
                System.out.println("Date1 year: " + d1.getYear());
                System.out.println();

                System.out.println("Date 2("+ d2.toString() +") is precedes than date 1("+ d1.toString()+ ") ? "+d2.precedes(d1));
                System.out.println("Both dates are equal? "+d1.equals(d3));

        }

}
