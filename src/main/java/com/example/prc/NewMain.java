package com.example.prc;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewMain {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(10,23,32,45,56,65,76,89,98,102,113,98,113,112);
        List<String> stringList = Arrays.asList("Jay","Ganesh","Shri","Ram","Om","Shanti","Shivbaba");

        //Given a list of integers, skip the first 5 elements and limit the result to the next 5 elements.
        List<Integer> skipLimitList = integerList.stream().skip(5).limit(5).collect(Collectors.toList());
        System.out.println(skipLimitList);

        //Given a list of strings, use peek to log each string before converting it to uppercase and collecting the results into a list.
        List<String> upperCaseList = stringList.stream().peek(System.out ::println).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseList);

        //Given a list of integers, find any even number.
        Optional<Integer> evenNumOptional = integerList.stream().filter(num -> num % 2 == 0).findAny();
        System.out.println(evenNumOptional.orElse(0));

        //Given a list of strings, create a map where the key is the string and the value is the length of the string.
        Map<String,Integer> stringLengthMap = stringList.stream().collect(Collectors.toMap(s->s,String::length));
        System.out.println(stringLengthMap);

        //Given a list of integers, collect them into a set to remove duplicates.
        Set<Integer> removeDuplicateList = integerList.stream().collect(Collectors.toSet());
        System.out.println(removeDuplicateList);

        //Given a list of strings, use a custom predicate to filter out strings that start with a specific letter.
        Predicate<String> predicate = s -> s.startsWith("J");
        List<String> startsWithString = stringList.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(startsWithString);

        //Given a list of strings, filter out strings that contain the letter 'a' and convert the remaining strings to uppercase.
        List<String> filterList = stringList.stream().filter(str -> !str.contains("a")).peek(str-> System.out.println(str)).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(filterList);

        //Create an infinite stream of random numbers and collect the first 10 numbers into a list.
        List<Double> randomList = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        System.out.println(randomList);

        //Create an IntStream from 1 to 100, filter out even numbers, and collect the remaining numbers into a list.
       List<Integer> oddNumbers =  IntStream.rangeClosed(1,100).filter(num -> num % 2 != 0).boxed().collect(Collectors.toList());
        System.out.println(oddNumbers);

        //Given a list of integers, compare the performance of a sequential stream versus a parallel stream when summing the numbers.

        long startTimeSeq = System.currentTimeMillis();
        int seqSum =  integerList.stream().reduce(0,Integer::sum);
        long endTimeSeq = System.currentTimeMillis();

        long startTimeParallel = System.currentTimeMillis();
        int parallelSum = integerList.parallelStream().reduce(0,Integer::sum);
        long endParallelSum = System.currentTimeMillis();

        System.out.println("Sequential ::"+seqSum+" :: "+(endTimeSeq - startTimeSeq));
        System.out.println("Parallel ::"+parallelSum+" :: "+(endParallelSum - startTimeParallel));

    }
}


// Accumulate names into a List List<String> list = people. stream()   .map(Person::getName)   .collect(Collectors. toList());
// Accumulate names into a TreeSet Set<String> set = people. stream()   .map(Person::getName)   .collect(Collectors. toCollection(TreeSet::new));
// Convert elements to strings and concatenate them, separated by commas String joined = things. stream()   .map(Object::toString)   .collect(Collectors. joining(", "));
// Compute sum of salaries of employee int total = employees. stream()   .collect(Collectors. summingInt(Employee::getSalary));
// Group employees by department Map<Department, List<Employee>> byDept = employees. stream()   .collect(Collectors. groupingBy(Employee::getDepartment));
// Compute sum of salaries by department Map<Department, Integer> totalByDept = employees. stream()   .collect(Collectors. groupingBy(Employee::getDepartment,Collectors. summingInt(Employee::getSalary)));
// Partition students into passing and failing Map<Boolean, List<Student>> passingFailing = students. stream()   .collect(Collectors. partitioningBy(s -> s. getGrade() >= PASS_THRESHOLD));