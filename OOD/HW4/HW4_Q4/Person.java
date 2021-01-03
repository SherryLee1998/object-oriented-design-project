package com.company;

public class Person {
    private String name;
    public Person(){
        name = "TBD";
    }
    public Person(String theName){
        this.name = theName;
    }
    public Person(Person theObject){
        this.name = theObject.name;
    }
    public String getName(){
        return name;
    }
    public void setName(String theName){
        this.name = theName;
    }
    public String toString(){
        return "the name is" + name;
    }
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        else if(getClass() != other.getClass()){
            return false;
        }
        else{
            Person otherperson =(Person) other;
            return (name.equalsIgnoreCase(((Person) other).name));
        }
    }

}
