package com.example.ch4;

public class LambdaExpression {
    public static void main(String[] args) {
        Calculator calculator = (a,b) -> a + b;
        Calculator calculator1 = (double a, double b) -> {return  a + b; };
        System.out.println(calculator.calc(2,4));
        System.out.println(calculator1.calc(2,4));

        Creator theCreator = () -> "Om Shanti Shanti, Ram Krushna Hari";
        System.out.println(theCreator.create());

        Tester theTester = s -> s.length() > 5;

        Tester theTester2 = str -> {
            String s = str.substring(0,str.length()-2);
            if(s.length() == str.length()){
                return true;
            }else{
                return false;
            }
        };

        System.out.println(theTester.test("fjskds"));

    }
}
