package com.example.prc;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {
//        Given a list of integers, skip the first 5 elements and limit the result to the next 5 elements.
//        Given a list of strings, use peek to log each string before converting it to uppercase and collecting the results into a list.
//        Given a list of integers, find any even number.
//        Given a list of strings, create a map where the key is the string and the value is the length of the string.
//        Given a list of integers, collect them into a set to remove duplicates.
//        Given a list of strings, use a custom predicate to filter out strings that start with a specific letter.
//        Given a list of strings, filter out strings that contain the letter 'a' and convert the remaining strings to uppercase.
//        Create an infinite stream of random numbers and collect the first 10 numbers into a list.
//        Create an IntStream from 1 to 100, filter out even numbers, and collect the remaining numbers into a list.
//        Given a list of integers, compare the performance of a sequential stream versus a parallel stream when summing the numbers.


        List<Integer> integerList = IntStream.rangeClosed(1,99).boxed().collect(Collectors.toList());
        List<String> stringList = Arrays.asList("Jay","Ganesh","Jai","Shri","Ram","Swami","Samarth");

        //1
        List<Integer> skipLimit = integerList.stream().skip(5).limit(5).collect(Collectors.toList());
        System.out.println(skipLimit);

        //2
        List<String> peekUppercaseString= stringList.stream().peek(System.out::println).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(peekUppercaseString);

        //3
        Optional<Integer> evenNum = integerList.stream().filter(num -> num % 2 == 0).findAny();
        System.out.println(evenNum);

        //4
        Map<String,Integer> stringIntegerMap = stringList.stream().collect(Collectors.toMap(s->s,String::length));
        System.out.println(stringIntegerMap);

        //5
        Set<Integer> integerSet =integerList.stream().collect(Collectors.toSet());
        System.out.println(integerSet);

        //6
        Predicate<String> predicate = s -> s.startsWith("J");
        List<String> listStartsWithJ = stringList.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(listStartsWithJ);

        //7
        List<String> filteredList = stringList.stream().filter(s -> !s.contains("a")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(filteredList);

        //8
        List<Double> randomNumberList = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        System.out.println(randomNumberList);

        //9
        List<Integer> oddNumbers = IntStream.rangeClosed(1,100).boxed().filter(num -> num % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);

        //10
        long startTimeSeq = System.currentTimeMillis();
        int seqSum = integerList.stream().reduce(0,Integer::sum);
        long endTimeSeq = System.currentTimeMillis();

        long startTimePar = System.currentTimeMillis();
        int parSum = integerList.parallelStream().reduce(0,Integer::sum);
        long endTimePar = System.currentTimeMillis();

        System.out.println("Sequential ::: "+seqSum +" :: "+(endTimeSeq - startTimeSeq));
        System.out.println("Parallel ::: "+parSum +" :: "+(endTimePar - startTimePar));
    }
}
