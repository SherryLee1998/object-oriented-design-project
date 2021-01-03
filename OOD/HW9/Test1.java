package com.company;

public class Test1 {
    public static void testMethod1(){
        try{
            testMethod2();
        }
        catch (ArithmeticException ae){
            System.out.println("Dock");
        }
    }
    public static void testMethod2() throws ArithmeticException{
        try{
            testMethod3();
        }
        catch (ArithmeticException ae){
            System.out.println("Dickory");
        }
    }
    public static void testMethod3() throws ArithmeticException{
        throw new ArithmeticException();
        //System.out.println("Hickory");
    }
   public static void main(String[] args){
        Test1 test  = new Test1();
        testMethod1();
        String t = " asfsdf";
        t = null;
        System.out.println(t.length);
   }
}
