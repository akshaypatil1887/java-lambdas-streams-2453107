package com.example.test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class ChangingDatesAndTimes {
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.now();


        LocalDateTime ldt2 = ldt1.plusMinutes(3);
        System.out.println(ldt2);

        LocalDateTime ldt2a = ldt1.plus(Period.ofWeeks(1));
        System.out.println(ldt2a);

        LocalDateTime ldt2b = ldt1.minus(Duration.ofHours(12));
        System.out.println(ldt2b);

        LocalDateTime ldt3 = ldt1.withMonth(9);
        System.out.println(ldt3);

    }
}
