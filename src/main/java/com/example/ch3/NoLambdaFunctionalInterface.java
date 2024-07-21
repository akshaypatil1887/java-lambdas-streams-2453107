package com.example.ch3;

import java.util.function.Predicate;

public class NoLambdaFunctionalInterface {
    public static void main(String[] args) {
        Predicate<String> predicate = (s)-> s.startsWith("S");
        System.out.println(predicate.test("Akshay"));
        System.out.println(predicate.test("Sopan"));
        System.out.println(predicate.test("Patil"));

    }
}
