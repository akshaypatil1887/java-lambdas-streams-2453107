package com.java8.day1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Jay Ganesh");
        System.out.println("----------");

        List<Integer> integerList = IntStream.rangeClosed(1,20).boxed().collect(Collectors.toList());
        List<Integer> duplicateIntegerList = Arrays.asList(1,1,2,2,3,1,3,4,5,5,5,5,5,5,5);
        List<String> stringList = Arrays.asList("Akshay","Sopan","Ram","Patil");

        //1.Separate odd and even numbers in a list of integers
        //Given a list of integers, write a Java 8 program to separate the odd and even numbers into two separate lists.
        Map<Boolean,List<Integer>> partitionMap = integerList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        List<Integer> evenList = partitionMap.get(true);
        List<Integer> oddList = partitionMap.get(false);
        System.out.println("Even List ::"+evenList);
        System.out.println("Odd List ::"+oddList);

        //2.Remove duplicate elements from a list using Java 8 streams
        //Write a Java 8 program to remove duplicate elements from a list using the stream API and lambda expressions.
        List<Integer> removeDuplicateList = duplicateIntegerList.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(removeDuplicateList);

        //3.Find the frequency of each character in a string using Java 8 streams
        //Write a Java 8 program to find the frequency of each character in a given string using the stream API and collectors.
        String frequencyString = "akshay";
        Map<String, Long> frequencyStringResultMap = Arrays.stream(frequencyString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequencyStringResultMap);

        //4.Find the frequency of each element in an array or a list
        //Write a Java 8 program to find the frequency of each element in an array or a list using streams and collectors.
        Map<Integer, Long> integerFrequencyMap = duplicateIntegerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(integerFrequencyMap);
        Map<String, Long> stringFrequencyMap = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringFrequencyMap);

        //5.Sort a given list of decimals in reverse order
        //Write a Java 8 program to sort a given list of decimal numbers in reverse order.
        List<Integer> reverseList = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Reverse List::"+reverseList);

        //6.Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
        //Given a list of strings, write a Java 8 program to join the strings with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.
        String joiningList = stringList.stream().collect(Collectors.joining(",","[","]"));
        System.out.println("joiningList :: "+joiningList);

        //7.Print the numbers from a given list of integers that are multiples of 5
        //Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.
        List<Integer> multiplesOf5 = integerList.stream().filter( num -> num % 5 == 0).collect(Collectors.toList());
        System.out.println("Multiple of 5 are::"+multiplesOf5);

        //8.Find the maximum and minimum of a list of integers
        //Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.
        Optional<Integer> maxNumber = integerList.stream().max(Integer::compareTo);
        Optional<Integer> minNumber = integerList.stream().min(Integer::compareTo);
        System.out.println("max Number : "+maxNumber.get());
        System.out.println("Min Number : "+minNumber.get());

        IntSummaryStatistics intSummaryStatistics = integerList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(intSummaryStatistics);

        //9.Merge two unsorted arrays into a single sorted array using Java 8 streams
        //Write a Java 8 program to merge two unsorted arrays into a single sorted array using the stream API.
         int[] arr1 = {1,2,3,7,9};
         int[] arr2 = {4,1,2,8,5};
         int[] mergeArray = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().toArray();
         System.out.println("mergeArray::"+Arrays.toString(mergeArray));

         //10.Merge two unsorted arrays into a single sorted array without duplicates
        //Write a Java 8 program to merge two unsorted arrays into a single sorted array without duplicates.
        int[] withoutDuplicateMergeArray = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).sorted().distinct().toArray();
        System.out.println("withoutDuplicateMergeArray::"+Arrays.toString(withoutDuplicateMergeArray));

        //11.Get the three maximum and three minimum numbers from a given list of integers
        //Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.
        List<Integer> randomNumbers = Arrays.asList(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> max3NumbersList = randomNumbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println("Maximum 3 Numbers:"+max3NumbersList);
        List<Integer> min3NumbersList = randomNumbers.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("Minimum 3 Numbers:"+min3NumbersList);

        //12.Check if two strings are anagrams or not using Java 8 streams
        //Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.
        String one="Peek";
        String two="Keep";
        String join1 = Arrays.stream(one.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        String join2 = Arrays.stream(two.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        System.out.println("Anagram is::"+join1.equals(join2));

        char[] splitItOne = one.toLowerCase().toCharArray();
        char[] splitItTwo = two.toLowerCase().toCharArray();
        Arrays.sort(splitItOne);
        Arrays.sort(splitItTwo);
        if(Arrays.equals(splitItOne,splitItTwo)){
            System.out.println("Anagram is");
        }else{
            System.out.println("Not Anagram");
        }

        //13.Find the sum of all digits of a number in Java 8
        //Write a Java 8 program to find the sum of all digits of a given number.
         int number = 33456;
        int reduce = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(reduce);

        //14.Find the second largest number in an integer array
        //Write a Java 8 program to find the second largest number in an integer array.
        randomNumbers.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);
        Integer secondLargest = randomNumbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(Integer.MAX_VALUE);
        System.out.println(secondLargest);

        //15.Sort a list of strings according to the increasing order of their length
        //Write a Java 8 program to sort a given list of strings according to the increasing order of their length.
        stringList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()).forEach(System.out::println);

        //16.Find the sum and average of all elements in an integer array
        //Write a Java 8 program to find the sum and average of all elements in an integer array.
        int sumOfInteger = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of integer:"+sumOfInteger);
        OptionalDouble averageOnIntegr = integerList.stream().mapToInt(Integer::intValue).average();
        System.out.println("Average is::"+averageOnIntegr);
        IntSummaryStatistics statistics = integerList.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());

        //17.Find the common elements between two arrays
        //Write a Java 8 program to find the common elements between two arrays using streams.
        List<Integer> arrr1 = Arrays.asList(1,2,3,4,5);
        List<Integer> arrr2 = Arrays.asList(3,4,5,6,7);
        List<Integer> commonElements = arrr1.stream().filter(arrr2::contains).collect(Collectors.toList());
        System.out.println(commonElements);

        //18.Reverse each word of a string using Java 8 streams
        //Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions.
        String text = "om shanti shivbaba";
        String reverseText = Arrays.stream(text.split(" ")).map(str -> new StringBuffer(str).reverse()).collect(Collectors.joining(" "));
        System.out.println("Reverse Text is:"+reverseText);

        //19.Find the sum of the first 10 natural numbers
        //Write a Java 8 program to find the sum of the first 10 natural numbers using streams.
         int sum10NaturalNumber = IntStream.rangeClosed(1,10).sum();
        System.out.println(sum10NaturalNumber);

        //Reverse an integer array
        //Write a Java 8 program to reverse an integer array.
        int [] numberArray ={1,2,3,4,5,6,7,8,9,10};
        System.out.println(numberArray.length);
        System.out.println("original array" + Arrays.toString(numberArray));
        int[] reversedArray = IntStream.rangeClosed(1, numberArray.length)
                .map(numberr -> numberArray[numberArray.length - numberr])
                .toArray();
        System.out.println("reversedArray Array" + Arrays.toString(reversedArray));


        int [] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};

        Integer maxDuplicateValue = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Integer.MAX_VALUE);
        System.out.println(maxDuplicateValue);

        IntStream.iterate(0, n -> n+2).limit(10).forEach(System.out::println);


        Integer i = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Integer.MAX_VALUE);
        System.out.println(i);


        Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Integer.MAX_VALUE);


        String name="Akshay";
        String reverseString = IntStream.range(0,name.length())
                .mapToObj(ii -> name.charAt(name.length() - ii -1))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("reverse String is::"+reverseString);






















    }
}
