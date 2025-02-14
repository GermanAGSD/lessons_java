package org.example;

public class Person {
    String name;
    int age;

    Person(){}
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void info(){
        System.out.println("Name: " + name + " Age: " + age);
    }
}
