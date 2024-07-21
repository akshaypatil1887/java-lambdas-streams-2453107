package com.example.ch7;

public class UnsignedIntegerArithmetic {
    public static void main(String[] args) {
        int a =5;
        int b =6;
        int c =-4;

        int resultDivide = Integer.divideUnsigned(a,b);
        int compareUnsigned = Integer.compareUnsigned(c,a);
        int resultRemainder = Integer.remainderUnsigned(b,a);

        System.out.println("Divide : "+resultDivide);
        System.out.println("Compare : "+compareUnsigned);
        System.out.println("resultRemainer : "+resultRemainder);

    }
}
