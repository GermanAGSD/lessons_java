package org.example;

public class Dog {
    private final double originWeight;
    private double weight;

    public Dog(double weight){
        this.weight = weight;
        this.originWeight = weight;
    }

    public void meow(){
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amout){
        weight = weight + amout;
    }

    public void drink(Double amount){
        weight = weight + amount;
    }

    public void pee(){
        weight = weight - 10;
        System.out.println("Clean it, man");
    }

    public double getWeight(){
        return weight;
    }
    
}
