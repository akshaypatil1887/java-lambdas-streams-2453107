package com.example.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Stream.of(new Employee(1,"Akshay",350000),
                                                new Employee(2,"Roshan",250000),
                                                new Employee(3,"Sarika",150000)).collect(Collectors.toList());

        double averageSalary = employeeList.stream().mapToDouble(Employee :: getSalary).average().orElse(0.0);
        System.out.println(averageSalary);


        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        Map<Boolean, List<Integer>> partionedNumbers = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        List<Integer> evenNumber = partionedNumbers.get(true);
        List<Integer> oddNumber = partionedNumbers.get(false);

        System.out.println(evenNumber);
        System.out.println(oddNumber);


        List<Transaction> transactionList = Arrays.asList(new Transaction(220,"INR")
                                                        , new Transaction(123,"USD")
                                                        ,new Transaction(111,"INR")
                                                        , new Transaction(10,"CAD"));

        Map<String, Double> curecnyfilter= transactionList.stream().collect(Collectors.groupingBy(Transaction::getCurrency, Collectors.summingDouble(Transaction::getAmount)));
        System.out.println(curecnyfilter);



    }
}
