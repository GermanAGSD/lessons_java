package org.example;

public class Payer {
    String surname;
    String name;
    String address;
    String cardNumber;

    Payer(String surname, String name, String address, String cardNumber) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.cardNumber = cardNumber;
    }

    public String getSurname() {
        System.out.println("Payer: surname: " + surname + " name: " + name + " address: " + address + " card: " + cardNumber);
        String str = "Payer: surname: " + surname + " name: " + name + " address: " + address + " card: " + cardNumber;
        return str;
    }
}
