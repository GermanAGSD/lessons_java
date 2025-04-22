package org.example;

public class Dog {
    private String name;
    private int age;

    Dog(){
        System.out.println("Dog Constructor");
    }

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String woof(){
        System.out.println("woof");
        return "Woof";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
