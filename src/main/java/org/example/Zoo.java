package org.example;

public class Zoo {
    Object[] objects;

    public Zoo(){
        objects = new Object[3];
        objects[0] = new Dog();
        objects[1] = new Cat();
        objects[2] = new Reptilie();
    }

    public void print(){
        for (Object a : objects){
            System.out.println(a);
        }
    }

    public void sound(){
        for (Object a : objects){
            if(a instanceof Soundable){
                ((Soundable)a).sound();
            }
        }
    }
}
