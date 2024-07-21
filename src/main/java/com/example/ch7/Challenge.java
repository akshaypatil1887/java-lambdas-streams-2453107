package com.example.ch7;

import java.util.Arrays;

public class Challenge {
    public static void main(String[] args) {
        String number = "two";
        int nr = 0;

        switch (number){
            case "one":
                nr = 1;
                break;
            case "two":
                nr = 2;
                break;
            default:
                System.out.println("Wrong Number");
                break;
        }

        String [] fruits = {"lemon","grapefruit","lime","orange"};
        Arrays.parallelSort(fruits);
        System.out.println(fruits[0]);

        int result = Integer.remainderUnsigned(-9, 2);
        System.out.println(result);
    }
}
