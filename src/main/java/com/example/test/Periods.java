package com.example.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Periods {
    public static void main(String[] args) {
        Period p1 = Period.of(1,1,1);
        System.out.println(p1);

        Period p2 = Period.ofDays(100);
        System.out.println(p2);


        LocalDate ldt1 = LocalDate.of(2024,1,1);
        LocalDate ldt2 = LocalDate.now();
        Period p3 = Period.between(ldt1,ldt2);
        System.out.println(p3);

        System.out.println(p3.getDays());

        long nrOfDaysBetweenDates = ChronoUnit.DAYS.between(ldt1,ldt2);
        System.out.println(nrOfDaysBetweenDates);
    }
}
