package com.example.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormattingDates {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        String formattedDate = DateTimeFormatter.ISO_DATE.format(ldt);

        System.out.println(formattedDate);

        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println(dft.format(ldt));

        String formatStyleDate = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(ldt);
        System.out.println(formatStyleDate);
    }
}
