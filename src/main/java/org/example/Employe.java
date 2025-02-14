package org.example;

public class Employe extends Person {
    String company;

    Employe(){
        super();
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void info(){
        System.out.println("Name: " + name + " Age: " + age +  " Company: " + company);
    }
}
