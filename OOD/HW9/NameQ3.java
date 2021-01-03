package com.company;
import java.util.Objects;


public class NameQ3 {
    private String name;
    private int boyNames;
    private int girlNames;

   NameQ3(){
       this.name = "";
       this.boyNames = 0;
       this.girlNames = 0;
   }
   NameQ3(String name, int girls, int boys){
       this.name = name;
       this.girlNames = girls;
       this.boyNames = boys;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoyNames(int boyNames) {
        this.boyNames = boyNames;
    }

    public void setGirlNames(int girlNames) {
        this.girlNames = girlNames;
    }

    public String getName() {
        return name;
    }

    public int getBoyNames() {
        return boyNames;
    }

    public int getGirlNames() {
        return girlNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameQ3 nameMap = (NameQ3) o;
        return boyNames == nameMap.boyNames &&
                girlNames == nameMap.girlNames &&
                Objects.equals( name, nameMap.name );
    }

    @Override
    public String toString() {
        return "name = " + name  + "  " + "boyNames: " + boyNames + "  girlNames: " + girlNames;
    }

}

