package com.java8.day3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestingClass {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(0,10).boxed().collect(Collectors.toList());
        List<Integer> duplicateIntegerList = Arrays.asList(1,1,2,3,4,4,4,4,5,66,6,6,6,6,6,6,6);
        List<String> duplcateStringList = Arrays.asList("Akshay","Sopan","om","SBI","Patil","Patil","Roshan","Akshay");


        Map<Boolean, List<Integer>> collect = integerList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        List<Integer> evenList = collect.get(true);
        List<Integer> oddList = collect.get(false);
        System.out.println(evenList);
        System.out.println(oddList);


        List<Integer> collect1 = duplicateIntegerList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

        String name = "I am Akshay Akshay Developer";
        Map<String, Long> collect2 = Arrays.stream(name.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);

        Map<String, Long> collect3 = duplcateStringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect3);

        String string = "akshay";
        Map<String, Long> collect4 = Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect4);

        Map<Integer, Long> integerLongMap = duplicateIntegerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(integerLongMap);

        int[] arr = {1,1,1,2,2,3,3,4};
        Map<Integer, Long> integerLongMap1 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(integerLongMap1);

        List<Integer> collect5 = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect5);

        String collect6 = Arrays.stream(name.split(" ")).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(collect6);

        List<Integer> collect7 = integerList.stream().filter(num -> num % 5 == 0).collect(Collectors.toList());
        System.out.println(collect7);

        IntSummaryStatistics statistics = integerList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());

        int[] arr1 = {4,1,2,3,4,4,56};
        int[] arr2 = {8,8,7,2,1,3};
        int[] array = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2)).sorted().toArray();
        System.out.println(Arrays.toString(array));


        int[] array1 = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2)).distinct().sorted().toArray();
        System.out.println(Arrays.toString(array1));

        List<Integer> collect8 = integerList.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        List<Integer> collect9 = integerList.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList());
        System.out.println(collect8);
        System.out.println(collect9);

        String string1 = "listen";
        String string2 = "silent";

        char[] charArray = string1.toCharArray();
        char[] charArray1 = string2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray);

        if(Arrays.equals(charArray,charArray1)){
            System.out.println("Is Anagram");
        }else{
            System.out.println("No Anagram");
        }

        int number = 123;
        int sum = Arrays.stream(String.valueOf(number).split("")).map(str -> Integer.valueOf(str)).mapToInt(Integer::intValue).sum();
        System.out.println(sum);


        String namee="Akshay";
        String collect10 = IntStream.range(0, namee.length())
                .mapToObj(k -> namee.charAt(namee.length() - k - 1))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(collect10);



    }
}
