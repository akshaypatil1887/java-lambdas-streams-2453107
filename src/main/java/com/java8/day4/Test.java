package com.java8.day4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        String name = "Roshan";

        String reverseString = IntStream.range(0,name.length())
                .mapToObj(i -> name.charAt(name.length() - i -1))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Reverse String is ::"+reverseString);

        //Find strings in a list that start with a number
        List<String> stringList = Arrays.asList("Akshay","1Roshan","2Sopan");
        List<String> collect = stringList.stream().filter(str -> Character.isDigit(str.charAt(0))).collect(Collectors.toList());
        System.out.println(collect);


        String string = "Ganesh";
        String revesee = IntStream.range(0,string.length())
                .mapToObj(i -> string.charAt(string.length() - i - 1))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(revesee);


        String str1 = "silent";
        String str2 = "listun";

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        if(Arrays.equals(char1,char2)){
            System.out.println("Is Anagram");
        }else{
            System.out.println("Not Anagram");
        }

        String pall1 = "racecar";
        Boolean reversePall1 = IntStream.range(0,pall1.length())
                .mapToObj(i -> pall1.charAt(pall1.length() -i -1))
                .map(String::valueOf)
                .collect(Collectors.joining()).equals(pall1);
        System.out.println(reversePall1);
        if(reversePall1){
            System.out.println("is Pallindrome");
        }else{
            System.out.println("Not Pallindrome");
        }

        //Write a Java 8 program to get the last element of an array.
        int[] arr = {1,2,3,44,312123,4,325};
        Arrays.stream(arr).boxed().skip(arr.length -1 ).limit(1).forEach(System.out::println);

        Integer lastElementInTheArray = Arrays.stream(arr).boxed().reduce((a,b) -> b).orElse(-1);
        System.out.println(lastElementInTheArray);


        //Write a Java 8 program to print the first 10 odd numbers.
        IntStream.range(0,20).boxed().filter(num -> num % 2 != 0).limit(10).collect(Collectors.toList()).forEach(System.out::println);

        Stream.iterate(1, i -> i +2).limit(10).forEach(System.out::println);

        Stream.iterate(new int[]{0,1} , t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);


        LocalDate birthDate = LocalDate.of(1997,4,23);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate,currentDate);
        System.out.println(period.getYears());


        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .collect(Collectors.toList());
        System.out.println(fibonacci);

        Arrays.stream(arr).boxed().reduce((a,b)->b).orElse(-1);



        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(12)
                .map(t -> t[0])
                .forEach(System.out::println);


        int ored = Arrays.stream(arr).reduce((a, b) -> b).orElse(-1);
        System.out.println(ored);

        LocalDate bday = LocalDate.of(1999,8,27);
        LocalDate curdt = LocalDate.now();
        Period period1 = Period.between(bday,curdt);
        System.out.println(period1.getYears());

        List<String> stringList1 = Arrays.asList("AKshay","1Akshay","2Sarika","2Roshan");
        stringList1.stream().filter(str -> Character.isDigit(str.charAt(0))).collect(Collectors.toList()).forEach(System.out::println);


        List<Integer> integerList = Arrays.asList(1,1,2,3,4,4,1,2);
        List<Integer> extractDuplicateElements = integerList.stream().filter(element -> integerList.indexOf(element) != integerList.lastIndexOf(element)).sorted().distinct().collect(Collectors.toList());
        System.out.println(extractDuplicateElements);

        String namee="akshay";
        IntStream.range(0,namee.length())
                .mapToObj(i -> namee.charAt(namee.length() -i -1))
                .map(String::valueOf)
                .collect(Collectors.joining());

        Arrays.stream(namee.split("")).filter(el -> namee.indexOf(el) != namee.lastIndexOf(el)).map(str -> str.charAt(0)).collect(Collectors.toList()).forEach(System.out::println);

        
        
        List<Integer> fibnasiList = Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0] + t[1]})
                .map(t -> t[0])
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("fibnasiList::"+fibnasiList);
        
        
        String akshay = "Hanuman";
        String reveseHanu = IntStream.range(0,akshay.length())
                .mapToObj(i -> akshay.charAt(akshay.length() - i - 1))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(reveseHanu);

        int ored1 = Arrays.stream(arr).reduce((a, b) -> b).orElse(-2);
        System.out.println(ored1);


        LocalDate bithd = LocalDate.of(1997,04,23);
        LocalDate localDate = LocalDate.now();
        Period period2 = Period.between(bithd,localDate);
        System.out.println(period2.getYears());

        List<String> collect1 = stringList1.stream().filter(s -> Character.isDigit(s.charAt(0))).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> collect2 = integerList.stream().filter(i -> integerList.indexOf(i) != integerList.lastIndexOf(i)).distinct().collect(Collectors.toList());
        System.out.println(collect2);

        List<Character> collect3 = Arrays.stream(namee.split("")).filter(str -> namee.indexOf(str) != namee.lastIndexOf(str)).map(str -> str.charAt(0)).collect(Collectors.toList());
        System.out.println(collect3);

        //non repeated chars
        Optional<String> first = Arrays.stream(namee.split("")).filter(str -> namee.indexOf(str) == namee.lastIndexOf(str)).findFirst();
        System.out.println(first);

    }
}
