package com.example.ch2;

import java.util.Base64;

public class EncodingAndDecoding {
    public static void main(String[] args) {
        String encoded = Base64.getEncoder().encodeToString("Bye".getBytes());
        System.out.println(encoded);

        String encodedHiThere = "SGkgVGhlcmU=";
        String decodedValue = new String(Base64.getDecoder().decode(encodedHiThere));
        System.out.println(decodedValue);

    }
}
