package com.example.ch4;

public class MethodArgs {
    public static void main(String[] args) {
        System.out.println(runTester(str -> str.length() > 5,"Vitthal"));
        System.out.println(runTester(str -> str.startsWith("S"),"Rukhmini"));
    }

    public static boolean runTester(Tester t, String str){
        return t.test(str);
    }
}
