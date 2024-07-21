package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Runnable r = ()-> System.out.println("Hello World");
        BiFunction<Integer, Integer, Integer> biFunction = (a,b)->a+b;
        System.out.println(biFunction.apply(12,12));


        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
        int sumOfEven = numbers
                        .stream()
                        .filter( item -> item % 2 == 0)
                        .mapToInt(Integer::intValue)
                        .sum();
        System.out.println(sumOfEven);

        int summ = Stream.of(1,2,3,4,5,6,7)
                .filter(a -> a % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(summ);

        List<String> words = Arrays.asList("Akshay","Roshan","OM","SHANTI","SHIVBABA");

        List<Integer> wordSize = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(wordSize);


        List<Person> personList = Stream.of(new Person("Akshay",27),
                new Person("sarika",19),
                new Person("Vidya",18),
                new Person("Shraddha",30),
                new Person("Jayesh",32)).collect(Collectors.toList());

        Map<Boolean, List<Person>> partinedList = personList.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 25));
        List<Person> ageMoreThan25 = partinedList.get(true);
        List<Person> ageLessThan25 = partinedList.get(false);
        System.out.println(ageMoreThan25);
        System.out.println(ageLessThan25);


    }
}
