package com.java8.day5;

import java.io.*;

public class SerializationMainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Akshay");

        FileOutputStream outputStream = new FileOutputStream("/Volumes/DATA/Java/test.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(employee);
        outputStream.close();
        objectOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream("/Volumes/DATA/Java/test.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Employee employee1 = (Employee) objectInputStream.readObject();
        System.out.println(employee1.getName());


    }
}
