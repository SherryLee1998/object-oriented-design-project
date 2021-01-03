package com.company;
import java.io.*;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameQ2 {
    public static final int NUMBER = 1000;
    public int count = 0;
    public void start(){
        HashSet<String> name = new HashSet<String>();
        ArrayList<String> common = new ArrayList<String>();
        LoadGFile( name,"girlnames.txt");
        LoadBFile( name,common, "boynames.txt");
        print( common );
        System.out.println( "total number of common names is : " + count);
    }

    private void LoadGFile(HashSet<String> names, String filename) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(filename));
            for (int a = 0; a < NUMBER; a++) {
                String line = inputStream.nextLine();
                int space = line.indexOf(" ", 0);
                String first = line.substring(0, space);
                String number = line.substring(space+1);
                first = first.toLowerCase();
                names.add(first);
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        }
        catch (IOError e){
            System.out.println("error in reading from file!");
            System.exit(0);
        }
    }
    private void LoadBFile(HashSet<String> names,ArrayList<String> common, String filename) {
        boolean add = true;
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new FileInputStream(filename));
            for (int a = 0; a < NUMBER; a++) {
                String line = inputStream.nextLine();
                int space = line.indexOf(" ", 0);
                String first = line.substring(0, space);
                String number = line.substring(space+1);
                first = first.toLowerCase();
                add = names.add(first);
                if(!add){
                    common.add(first);
                    count++;
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        }
        catch (IOError e){
            System.out.println("error in reading from file!");
            System.exit(0);
        }
    }
    private void print(ArrayList<String> common){
        System.out.println("Here are the common name: ");
        for(int i =0; i < common.size(); i++){
           System.out.println(common.get(i));
        }
    }

    public static void main(String[] args) {
       NameQ2 test1 = new NameQ2();
       test1.start();
    }
}
