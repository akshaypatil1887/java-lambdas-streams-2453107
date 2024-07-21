package com.example.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermidiateOperations {
    public static void main(String[] args) {
        String[] names = {"Akshay","Sopan","Patil","Ram","Krishna","Hari"};
        List<String> namesList = new ArrayList<>(Arrays.asList(names));

        //filter
        namesList.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));


        //map
        namesList.stream().map( s -> s + " student").forEach(s -> System.out.println(s));

        //flatmap
        String[][] names2d = {names, names};
        String[] names1d = Stream.of(names2d)
                .flatMap(arr -> Stream.of(arr))
                .peek(s -> System.out.println("peek : "+s))
                .toArray(size -> new String[size]);


        Arrays.stream(names1d).skip(1).forEach(s -> System.out.println("skip :"+s));
        Arrays.stream(names1d).limit(2).forEach( s -> System.out.println("limit :"+s));
        Arrays.stream(names1d).skip(3).limit(5).forEach( s -> System.out.println("skip & limit :"+s));


        //distinct
        long count  = Arrays.stream(names1d).distinct().count();
        System.out.println(count);

        //sorted

        Arrays.asList(names1d).stream().sorted().forEach(s -> System.out.println("Sorted ->"+s));


    }
}
