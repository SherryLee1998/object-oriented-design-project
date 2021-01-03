package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class NameMapQ3 {

    public static final int NUMBER = 1000;
    public void start(){
        HashMap<String , NameQ3> nameQ3HashMap = new HashMap<String, NameQ3>();
        ArrayList<NameQ3> common = new ArrayList<NameQ3>();
        LoadGFile( nameQ3HashMap,"girlnames.txt" );
        LoadBFile( nameQ3HashMap,common,"boynames.txt" );
        print( common );
    }

    private void LoadGFile(HashMap<String , NameQ3> names, String filename) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(filename));
            for (int a = 0; a < NUMBER; a++) {
                String line = inputStream.nextLine();
                int space = line.indexOf(" ", 0);
                String first = line.substring(0, space);
                String number = line.substring(space+1);
                first = first.toLowerCase();
                names.put(first,new NameQ3(first, Integer.parseInt( number ),0));
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
    private void LoadBFile(HashMap<String , NameQ3> nameQ3HashMap,ArrayList<NameQ3> common, String filename) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(filename));
            for (int a = 0; a < NUMBER; a++) {
                String line = inputStream.nextLine();
                int space = line.indexOf(" ", 0);
                String first = line.substring(0, space);
                String number = line.substring(space+1);
                first = first.toLowerCase();
                if(nameQ3HashMap.containsKey( first )){
                   NameQ3 commonName = nameQ3HashMap.get( first );
                   commonName.setBoyNames( Integer.parseInt( number ) );
                   common.add( commonName );
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
    private void print(ArrayList<NameQ3> common){
        System.out.println("Here are the common name: ");
        Iterator<NameQ3> scan = common.listIterator();

        while (scan.hasNext()){
            System.out.println(scan.next());
        }

        System.out.println("total number of common is : " + common.size());
    }

    public static void main(String[] args) {
        NameMapQ3 test = new NameMapQ3();
        test.start();
    }
}
