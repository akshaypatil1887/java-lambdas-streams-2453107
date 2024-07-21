package com.example.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonStreamExample {
    public static void main(String[] args) {

        String[] names = {"Akshay","Sopan","Patil","Ram","Krishna","Hari"};
        List<String> namesList = new ArrayList<>();

        for(String name:names){
            if(name.startsWith("A") || name.startsWith("a")){
                namesList.add(name);
            }
        }
        System.out.println(namesList);


        for(int i=0;i< names.length;i++){
            if(!names[i].equals("Akshay")){
                names[i] += " -> Student";
            }
            System.out.println(names[i]);
        }

        List<String> newNamesList = new ArrayList<>(Arrays.asList(names));
        for(String name: newNamesList){
            if(name.equals("Akshay")){
                newNamesList.remove(name);
            }
        }

    }
}
