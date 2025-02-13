package org.example;

public class Animal {

    int age;
    String name;
    String color;


    Animal() {}
    Animal(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }
    Animal(Animal a) {
        this.age = a.age;
        this.name = a.name;
        this.color = a.color;
    }

    public void toStr() {
        System.out.println("Animal age: " + age + " name: " + name + " color: " + color);
    }
}
