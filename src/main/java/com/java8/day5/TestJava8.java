package com.java8.day5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJava8 {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(0,20).boxed().collect(Collectors.toList());
        List<Integer> duplicateIntegerList = Arrays.asList(0,0,1,2,3,1,2,3,4);

        Map<Boolean,List<Integer>> booleanListMap = integerList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        List<Integer> evenList = booleanListMap.get(true);
        List<Integer> oddList = booleanListMap.get(false);

        System.out.println(evenList);
        System.out.println(oddList);

        List<Integer> uniaueList = duplicateIntegerList.stream().distinct().collect(Collectors.toList());
        System.out.println(uniaueList);

        String name= "akshay";
        Map<String, Long> stringLongMap = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringLongMap);

        String sentence = "I am Pure Soul I am Devin Soul";
        Map<String, Long> stringLongMap1 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringLongMap1);

        Map<Integer, Long> integerLongMap = duplicateIntegerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(integerLongMap);

        List<Integer> reverseList = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseList);

        List<String> stringList = Arrays.asList("Akshay","God","Is","With","You");
        String prefixSentence = stringList.stream().collect(Collectors.joining(", ","[","]"));
        System.out.println(prefixSentence);

        List<Integer> multipleOf5List = integerList.stream().filter(i -> i % 5 == 0).collect(Collectors.toList());
        System.out.println(multipleOf5List);

        IntSummaryStatistics intSummaryStatistics  = integerList.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());

        int[] arr1 = {1,0,1,2,3,0,1};
        int[] arr2 = {5,1,4,5,7,3,9};

        List<Integer> mergeArrays = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).boxed().sorted().collect(Collectors.toList());
        System.out.println(mergeArrays);

        List<Integer> mergeDistinctArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).boxed().sorted().distinct().collect(Collectors.toList());
        System.out.println(mergeDistinctArray);

        List<Integer> max3Elements = integerList.stream().sorted(Comparator.reverseOrder()).limit(3).sorted().collect(Collectors.toList());
        System.out.println(max3Elements);

        List<Integer> min3Elements = integerList.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println(min3Elements);

        String stringOne = "madam";
        String stringTwo = "madam";

        char[] chars1 = stringOne.toCharArray();
        char[] chars2 = stringTwo.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if(Arrays.equals(chars1,chars2)){
            System.out.println("Two Words Are Anagram");
        }else{
            System.out.println("Words are not Anagram");
        }

        int number = 123;
        int sum = Arrays.stream(String.valueOf(number).split("")).map(Integer::parseInt).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<Integer> secondMaxNumber = integerList.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(secondMaxNumber);

        List<Integer> secondMaxNumberArray = Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(secondMaxNumberArray);

        List<String> collect = stringList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println(collect);

        IntSummaryStatistics statistics = Arrays.stream(arr2).summaryStatistics();
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());

        List<Integer> collect1 = Arrays.stream(arr1).boxed().distinct().filter(num -> Arrays.stream(arr2).boxed().distinct().anyMatch(num::equals)).collect(Collectors.toList());
        System.out.println(collect1);

        String reverseString = IntStream.range(0,name.length()).mapToObj(i -> name.charAt(name.length() - i -1)).map(String::valueOf).collect(Collectors.joining());
        System.out.println(reverseString);

        String collect2 = Arrays.stream(sentence.split(" ")).map(word -> IntStream.range(0, word.length()).mapToObj(i -> word.charAt(word.length() - i - 1)).map(String::valueOf).collect(Collectors.joining())).collect(Collectors.joining(" "));
        System.out.println(collect2);

        int sum1 = IntStream.rangeClosed(0, 10).boxed().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

//        Arrays.stream(arr1).boxed().mapToInt(Integer::intValue).sorted(Comparator.comparingInt())
         int[] reverseArray =  IntStream.rangeClosed(1,arr1.length)
                   .map(i -> arr1[arr1.length - i])
                   .toArray();
        System.out.println(Arrays.toString(reverseArray));

        int[] evenFirst10 = IntStream.iterate(0, i -> i + 2).limit(10).toArray();
        System.out.println(Arrays.toString(evenFirst10));

        //22


        //

        boolean palindrome = IntStream.range(0, stringTwo.length())
                .mapToObj(i -> stringTwo.charAt(stringTwo.length() - i - 1))
                .map(String::valueOf)
                .collect(Collectors.joining()).equals(stringTwo);
        System.out.println(palindrome);

        List<String> numberStringList = Arrays.asList("1Akshay","2Roshan","mayuresh","sarika","3Patil");
        List<String> collect3 = numberStringList.stream().filter(s -> Character.isDigit(s.charAt(0))).collect(Collectors.toList());
        System.out.println(collect3);


    }
}
