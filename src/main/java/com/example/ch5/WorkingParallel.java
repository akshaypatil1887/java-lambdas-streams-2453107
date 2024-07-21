package com.example.ch5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WorkingParallel {
    public static void main(String[] args) {
        int total = Stream.of(1,2,3,4,5,6,7,8,9,10)
                    .parallel()
                    .reduce(1,(x,y) -> x+y);
        System.out.println(total);


        String[] names = {"Akshay","Sopan","Patil","Ram","Krishna","Hari"};
        List<String> namesList = new ArrayList<>(Arrays.asList(names));

        long startPar = System.currentTimeMillis();
        namesList.parallelStream().filter(name -> name.startsWith("A")).forEach(s -> System.out.println(s));
        long endPar = System.currentTimeMillis();
        System.out.println("Parallel Took ::" + (endPar - startPar));


        long startSeq = System.currentTimeMillis();
        namesList.stream().filter(name -> name.startsWith("A")).forEach(s -> System.out.println(s));
        long endSeq = System.currentTimeMillis();
        System.out.println("Sequence Took ::" + (endSeq - startSeq));
    }
}
