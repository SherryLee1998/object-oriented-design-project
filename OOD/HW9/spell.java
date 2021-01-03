package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.util.HashSet;
import java.util.Scanner;

public class spell {
    public void start(){
        HashSet<String> spell = new HashSet<>();
        LoadWordFile( spell,"words.txt");
        CheckWord(spell,"spell.txt");
    }

    private void LoadWordFile(HashSet<String> spell, String filename){
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(filename));

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        }
        catch (IOError e){
            System.out.println("error in reading from file!");
            System.exit(0);
        }

        while (inputStream.hasNext()){
            String add1 = inputStream.next().toLowerCase();
            spell.add( add1 );
        }

        inputStream.close();
    }

    private void CheckWord(HashSet<String> spell, String filename ){
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(filename));

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        }
        catch (IOError e){
            System.out.println("error in reading from file!");
            System.exit(0);
        }

        System.out.println("The following words are misspelled: ");
        while (inputStream.hasNext()){
            String word = inputStream.next().toLowerCase();
            if(!spell.contains( word )){
                System.out.println(word);
            }
        }

        inputStream.close();
    }
    public static void main(String[] args) {
        spell test1 = new spell();
        test1.start();
    }

}
