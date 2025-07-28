package org.example;

public record Employe(String name, int idNum) {

     public Employe(String name, int idNum) {
        this.name = name.trim();
        this.idNum = idNum;
    }

}
