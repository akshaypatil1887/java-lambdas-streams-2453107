package com.example.prc;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {

        //Given a list of integers, filter out all the even numbers and collect the remaining numbers into a list.

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> oddNumbers = integerList.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);

        //Given a list of strings, convert each string to uppercase and collect the results into a list.

        List<String> stringList = Arrays.asList("jay","shri","ram","Akshay","eknath","yogesh","");
        List<String> upperCaseStringList = stringList.stream().map(String :: toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseStringList);

        //Given a list of integers, find the sum of all the integers using the reduce method.
//        OptionalInt sumOfIntegers = integerList.stream().mapToInt(Integer ::intValue).reduce(Integer::sum);
//        System.out.println(sumOfIntegers.orElse(0));
        int sum = integerList.stream().reduce(0,Integer ::sum);
        System.out.println(sum);

        //Given a list of strings, find the first string that starts with the letter "A".
        String startsWithA = stringList.stream().filter(str -> str.startsWith("A")).findFirst().orElse("Not Found!!");
        System.out.println(startsWithA);

        //Given a list of strings, group the strings by their length.
        Map<Integer,List<String>> groupList = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupList);

        //Given a list of strings, join them into a single string with commas separating each element.
        String joingString = stringList.stream().collect(Collectors.joining(","));
        System.out.println(joingString);

        //Given a list of integers, remove the duplicate numbers and collect the remaining numbers into a list.
        List<Integer> duplicateIntegerList = Arrays.asList(1,1,2,3,4,2,2,4,6,7,8,8,8);
        List<Integer> distinctIntegerList = duplicateIntegerList.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(distinctIntegerList);

        //Given a list of strings, count the number of strings that contain the letter "e".
        long eStringCount = stringList.stream().filter(str -> str.contains("e")).count();
        System.out.println(eStringCount);

        //Given a list of people (with name and age fields), sort the list by age in descending order.
        List<People> peopleList = Arrays.asList(new People("Akshay",27), new People("Roshan",25),new People("Sarika",18),new People("Yogesh",30));
        List<People> sortedPeopleList = peopleList.stream().sorted(((o1, o2) -> o2.getAge() - o1.getAge())).collect(Collectors.toList());;
        System.out.println(sortedPeopleList);
        List<People> sortedList = peopleList.stream().sorted(Comparator.comparingInt(People::getAge).reversed()).collect(Collectors.toList());
        System.out.println(sortedList);


        //Given a list of lists of integers, flatten the lists into a single list.
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2,3,4,5),Arrays.asList(2,3,4,5));
        System.out.println(lists);
        List<Integer> intList = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(intList);
        List<Integer> flattenedList = lists.stream().flatMap(List :: stream).collect(Collectors.toList());
        System.out.println(flattenedList);


        //Given a list of integers, partition the list into two lists: one with even numbers and one with odd numbers.
        Map<Boolean, List<Integer>> partionByList= integerList.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        List<Integer> evenList = partionByList.get(true);
        List<Integer> oddList = partionByList.get(false);
        System.out.println(evenList);
        System.out.println(oddList);

        //Given a list of integers, find the maximum and minimum values.
        OptionalInt max = integerList.stream().mapToInt(Integer::intValue).max();
        OptionalInt min = intList.stream().mapToInt(Integer::intValue).min();
        System.out.println(max.orElse(0));
        System.out.println(min.orElse(0));

        Optional<Integer> maxNum = integerList.stream().max(Integer ::compareTo);
        Optional<Integer> minNum = integerList.stream().min(Integer :: compareTo);
        System.out.println(maxNum);
        System.out.println(minNum);

        //Given a list of strings, find the length of each string and collect the lengths into a list of integers.
        List<Integer> stringLength = stringList.stream().map(String::length).collect(Collectors.toList());
        System.out.println(stringLength);


        //Given a list of strings, collect them into a list and convert the list to an unmodifiable list.
        List<String> unmodifiableList = stringList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
        System.out.println(unmodifiableList);

       List<String> ll = Collections.unmodifiableList(stringList);
        System.out.println(ll);

        //Given a list of strings, check if all strings are non-empty.
        boolean allStringNonEmpty =  stringList.stream().allMatch(str -> !str.isEmpty());
        System.out.println(allStringNonEmpty);

        //Given a list of strings, check if any string is empty.
        boolean anyMatchEmpty = stringList.stream().anyMatch(String :: isEmpty);
        System.out.println(anyMatchEmpty);

        //Given a list of strings, check if no string is empty.
        boolean noEmptyString = stringList.stream().noneMatch(String :: isEmpty);
        System.out.println(noEmptyString);

        //Given a list of integers, use a parallel stream to find the sum of all integers.
        int parallelSum = integerList.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(parallelSum);
        int parrlSum = integerList.parallelStream().reduce(0,Integer::sum);
        System.out.println(parrlSum);

        //Create a custom collector that collects strings into a single concatenated string with a specified delimiter.
        String concatString =  stringList.stream().collect(Collectors.joining(","));
        System.out.println(concatString);

        String customJoining = stringList.stream().collect(new StringJoinCollector(","));
        System.out.println(customJoining);

        String customJoin = stringList.stream().collect(new CustomStringJoiner(", "));
        System.out.println(customJoin);

        //Given a list of integers, get summary statistics (count, sum, min, average, and max).
        long count = integerList.stream().mapToInt(Integer::intValue).count();
        System.out.println(count);
        int sumResult = integerList.stream().reduce(0,Integer::sum);
        System.out.println(sumResult);
        int minResult = integerList.stream().reduce(0,Integer::min);
        System.out.println(minResult);
        int maxResult = integerList.stream().reduce(0,Integer::max);
        System.out.println(maxResult);
        OptionalDouble average = integerList.stream().mapToInt(Integer::intValue).average();
        System.out.println(average);
        IntSummaryStatistics statistics = integerList.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(statistics);

    }
}
