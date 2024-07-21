package com.example.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        String[] names = {"Akshay","Sopan","Patil","Ram","Krishna","Hari"};
        List<String> namesList = new ArrayList<>(Arrays.asList(names));

        //Create Stream based on array
        Arrays.stream(names).forEach(name-> System.out.println(name));

        Optional<String> resultMin=Arrays.stream(names).min((a, b) -> a.compareTo(b));
        System.out.println(resultMin);

        long count = namesList.stream().count();
        System.out.println(count);

        //Create Stream based on list
        Stream<String> listStream  = namesList.stream();
        boolean resultListStream = namesList.stream().allMatch(name -> !name.isEmpty());
        System.out.println("All starts with A-->"+resultListStream);

        boolean noneMatch = namesList.stream().noneMatch(name -> name.startsWith("a"));
        System.out.println(noneMatch);

        boolean anyMatch = namesList.stream().anyMatch(name -> name.startsWith("A"));
        System.out.println(anyMatch);


        List<String> listNamesLongThan5 = namesList.stream().filter(name -> name.length() > 5).collect(Collectors.toList());
        System.out.println(listNamesLongThan5);

        //Create Stream using generate method
        Stream<Integer> generateStream = Stream.generate(()-> 5);
//        Optional<Integer> minGanerate = Stream.generate(()-> 5).min((a,b) -> a.compareTo(b));
//        System.out.println(minGanerate);

        //Create Stream using iterate method
        Stream<Integer> iterateStream = Stream.iterate(1, x -> x+2);


        int [] ints = {1,2,3,4,5};
        int total = Arrays.stream(ints).reduce(0,(x,y) -> x + y);
        System.out.println(total);

    }
}
