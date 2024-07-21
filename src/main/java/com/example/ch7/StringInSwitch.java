package com.example.ch7;

public class StringInSwitch {
    public static void main(String[] args) {
        String language = "java";

        switch (language.toLowerCase()){
            case "java":
                System.out.println("I love java");
                break;
            case "python":
                System.out.println("I love python");
                break;
            default:
                System.out.println("can you teach me that");
                break;
        }
    }
}
