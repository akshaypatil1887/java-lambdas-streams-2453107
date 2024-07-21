package com.example.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingClass {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Akshay","Roshan","om","shanti","shiv","baba","jay","Shri","ram");

        List<String> filterString = words.stream()
                .filter(item -> item.length() >= 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(filterString);


        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> squareNumbers = numbers.stream().map(num -> num * num).collect(Collectors.toList());
        System.out.println(squareNumbers);

        int maxNum = numbers.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException:: new);
        System.out.println(maxNum);

        String commas = words.stream().collect(Collectors.joining(","));
        System.out.println(commas);

        String startsWithA = words.stream().filter(item -> item.toLowerCase().startsWith("a")).findFirst().orElse("Not Found");
        System.out.println(startsWithA);

        List<Person> personList = Stream.of(new Person("Akshay",27),
            new Person("Roshan",27),
                new Person("Sarika",20),
                new Person("Yogesh",29),
                new Person("Chetan",31),
                new Person("Vidya",20)
        ).collect(Collectors.toList());

        List<String> filteredPersonList = personList.stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(filteredPersonList);


        List<Employee> employeeList = Stream.of(new Employee(1,"Akshay",10),
                                                new Employee(2,"Roshan",11),
                                                new Employee(3,"Sarika",12)
                                                ).collect(Collectors.toList());
         int average = (int) employeeList.stream().mapToInt(Employee::getSalary).average().orElse(0);
        System.out.println(average);

        Map<Integer, List<Person>> groupByAgeList= personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupByAgeList);


        Map<Boolean, List<Integer>> partioned = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenList = partioned.get(true);
        List<Integer> oddList = partioned.get(false);
        System.out.println(evenList);
        System.out.println(oddList);


        List<List<Integer>> integerList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,7),
                Arrays.asList(6,8,9)
        );

        List<Integer> flattenedList = integerList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flattenedList);


        List<Transaction> transactions = Arrays.asList(new Transaction(100,"USD"),
                new Transaction(200,"EUR"),
                new Transaction(250,"CAD"),
                new Transaction(350,"USD"),
                new Transaction(350,"CAD")
                );

        Map<String,Double> currencySum = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency,Collectors.summingDouble(Transaction::getAmount)));
        System.out.println(currencySum);


        int sumEvenNumber = numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sumEvenNumber);

        double averageSalary = employeeList.stream().map(Employee::getSalary).collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(averageSalary);

        SumCalculation sumCalculation = (a, b) -> a+b;
        System.out.println(sumCalculation.sum(23,23));

    }
}
