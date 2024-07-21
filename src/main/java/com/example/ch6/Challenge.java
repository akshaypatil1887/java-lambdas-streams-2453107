package com.example.ch6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Challenge {
    public static void main(String[] args) {
        // create an empty optional of type String

        Optional<String> emptyOptional = Optional.empty();

        //create an optional containing an integer

        Optional<Integer> integerOptional = Optional.of(40);

        //get value out of empty optional and specify a default name

        emptyOptional.orElse("Default");

        Optional<Integer> integerList = Optional.of(31);
        integerList.filter(i -> i % 2 != 0).orElseThrow(() -> new RuntimeException());

        integerList.map(i -> i+1).get();

    }
}
