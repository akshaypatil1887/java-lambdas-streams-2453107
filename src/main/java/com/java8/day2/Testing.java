package com.java8.day2;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Testing {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(0,10).boxed().collect(Collectors.toList());
        List<Integer> duplicateIntegerList = Arrays.asList(1,1,1,2,3,2,3,4);
        List<String> duplcateStringList = Arrays.asList("Akshay","Sopan","om","SBI","Patil","Patil","Roshan","Akshay");

        //1.
       Map<Boolean,List<Integer>> partition = integerList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
       List<Integer> evenList = partition.get(true);
       List<Integer> oddList = partition.get(false);
       System.out.println("Even List is:::"+evenList);
       System.out.println("Odd List is:::"+oddList);

       //2.
        List<Integer> distinctElementList = duplicateIntegerList.stream().distinct().collect(Collectors.toList());
        System.out.println("List After removal of duplicate Elements is::"+distinctElementList);

        //3.
        Map<String, Long> stringLongMap = duplcateStringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of Each Element in List is::"+stringLongMap);

        String name="Akshay";
        Map<String, Long> collected = Arrays.stream(name.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of each Character is::"+collected);

        //4.
        Map<Integer, Long> integerLongMap = duplicateIntegerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequency of each element in list:::"+integerLongMap);

        int[] arr = {1,1,2,3,2,3,4};
        Map<Integer, Long> integerLongMap1 = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("frequency of each element in Array:::"+integerLongMap1);

        //5.
        List<Integer> reverseList = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Reverse List is::: "+reverseList);

        //6.
        String joinedWithPrefix = duplcateStringList.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("List as joined with delimeter prefix and suffix is::"+joinedWithPrefix);

        //7.
        List<Integer> multiplesOf5List = integerList.stream().filter(num -> num % 5 == 0).collect(Collectors.toList());
        System.out.println("Multiples of 5 List is::"+multiplesOf5List);

        //8.
        int max = integerList.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE);
        int min = integerList.stream().mapToInt(Integer::intValue).min().orElse(Integer.MIN_VALUE);
        System.out.println("Max is::"+max);
        System.out.println("Min is::"+min);

        //9.
        int[] arr1 = {2,1,3,2,4};
        int[] arr2 = {5,8,1,3,6};
        int[] mergeSortedArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
        System.out.println("Merged Sorted Array is::"+Arrays.toString(mergeSortedArray));

        //10
        int[] mergeSortedDistinctArray = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).distinct().sorted().toArray();
        System.out.println("Merged Sorted Array without Duplicate is::"+Arrays.toString(mergeSortedDistinctArray));

        //11.
        List<Integer> max3List = integerList.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        List<Integer> min3List = integerList.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList());
        System.out.println("Max 3 from List is::"+max3List);
        System.out.println("Min 3 from List is::"+min3List);

        //12.
        String stringOne = "keep";
        String stringTwo = "peeking";

        char[] char1 = stringOne.toCharArray();
        char[] char2 = stringTwo.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        if(Arrays.equals(char1,char2)){
            System.out.println("Two Strings are Anagram::");
        }else{
            System.out.println("Two Strings are Not Anagram::");
        }

        String collect = Arrays.stream(stringOne.split("")).sorted().collect(Collectors.joining());
        String collect2 = Arrays.stream(stringTwo.split("")).sorted().collect(Collectors.joining());
        if(collect.equals(collect2)){
            System.out.println("Two Strings are Anagram::");
        }else{
            System.out.println("Two Strings are Not Anagram::");
        }

        //13.
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Elements in List is::"+sum);

        int num = 123;
        int sum1 = Arrays.stream(String.valueOf(num).split("")).map(str -> Integer.valueOf(str)).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of number is::"+sum1);

        //14.
        int[] intArray = {0,1,2,3,4,5,6,7,8,9,9,1,1,3,3,3,3,3};
        Arrays.stream(intArray).boxed().collect(Collectors.toList()).stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);

        //15.
        List<String> collect1 = duplcateStringList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("Sorted List According to length is::"+collect1);

        //16.
        IntSummaryStatistics statistics = Arrays.stream(intArray).summaryStatistics();
        System.out.println("Sum of Elements in Array is::"+statistics.getSum());
        System.out.println("Average of Elements in Array is::"+statistics.getAverage());

        //17.
        List<Integer> oneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> twoToTen = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect5 = oneToTen.stream().filter(twoToTen::contains).collect(Collectors.toList());
        System.out.println(collect5);

       Integer[] array1 = {1, 2, 3, 4, 5, 6};
       Integer[] array2 = {4, 5, 6, 7, 8, 9};
       Set<Integer> integerSet = new HashSet<>(Arrays.asList(array1));
        List<Integer> commonList1 = Arrays.stream(array2).filter(integerSet::contains).collect(Collectors.toList());
        System.out.println("<<<>>>>"+commonList1);
        
        List<Integer> commonList = Arrays.stream(array2).filter(Arrays.asList(array1)::contains).collect(Collectors.toList());
        System.out.println("=====>>>>"+commonList);

     //18.
        String words = "my name is Akshay";
        String collect3 = Arrays.stream(words.split(" ")).map(str -> new StringBuffer(str).reverse()).collect(Collectors.joining(" "));
        System.out.println("String with reverse Words is: ---->>>>>"+collect3);

        //19.
        int sum2 = IntStream.rangeClosed(0, 10).boxed().mapToInt(Integer::intValue).sum();
        System.out.println("10 Natural Number sum is::"+sum2);

        //20.
        Object[] array = Arrays.stream(arr1).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).toArray();
        System.out.println(Arrays.toString(array));

        //21.
        IntStream.rangeClosed(0,20).filter(nu -> nu % 2 == 0).limit(10).forEach(System.out::println);

        //22.
     Integer i = Arrays.stream(intArray)
             .boxed()
             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
             .entrySet()
             .stream()
             .max(Map.Entry.comparingByValue())
             .map(Map.Entry::getKey)
             .orElse(Integer.MAX_VALUE);
     System.out.println("Repeated Element is::"+i);

     //23.
     String palindrome = "Akshay";
     String collect4 = IntStream.range(0, palindrome.length())
             .mapToObj(io -> palindrome.charAt(palindrome.length() - 1 - io))
             .map(String::valueOf).collect(Collectors.joining());
     System.out.println(collect4);

     oneToTen.stream().filter(twoToTen::contains).collect(Collectors.toList());


    }
}
