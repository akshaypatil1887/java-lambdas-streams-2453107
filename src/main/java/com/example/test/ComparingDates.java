package com.example.test;

import java.time.LocalDateTime;

public class ComparingDates {

    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2022,2,1,2,3);

        System.out.println(ldt1);
        System.out.println(ldt2);

        System.out.println(ldt1.compareTo(ldt2));
        System.out.println(ldt2.compareTo(ldt1));

        System.out.println("id After::"+ldt1.isAfter(ldt2));
        System.out.println("id Before::"+ldt1.isBefore(ldt2));
        System.out.println("id Equal::"+ldt1.isEqual(ldt2));
    }
}
