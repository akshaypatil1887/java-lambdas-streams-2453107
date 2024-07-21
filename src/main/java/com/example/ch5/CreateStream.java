package com.example.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        String[] names = {"Akshay","Sopan","Patil","Ram","Krishna","Hari"};
        List<String> namesList = new ArrayList<>();

        //Create Stream based on array
        Stream<String> arraysStream = Arrays.stream(names);

        //Create Stream based on list
        Stream<String> listStream  = namesList.stream();

        //Create Stream using generate method
        Stream<Integer> generateStream = Stream.generate(()-> 5);

        //Create Stream using iterate method
        Stream<Integer> iterateStream = Stream.iterate(1, x -> x+2);

    }
}
