package org.example;
import java.security.SecureRandom;
import java.util.Base64;

public class User {

    private String name;
    private String surname;
    private String phoneNumber;
    private String password;
    User() {}

    public String checkNullOrEmpty(String value){
        if(value == null && value.isEmpty()){
            System.out.println("Value is Empty or Null");
            return null;
        }
        return value;
    }

    User(String name, String surname, String phoneNumber, String password ){
        this.name = upperTo(name);
        this.surname = upperTo(surname);
        this.phoneNumber = checkNumber(phoneNumber);
    }

    public String  upperTo(String name){
        checkNullOrEmpty(name);
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public String checkNumber(String phoneNumber){
        checkNullOrEmpty(phoneNumber);
        if(phoneNumber.length() < 6){
            System.out.println("Phone not valid < 6 symbol");
            return null;
        }
        return phoneNumber;
    }

    // Метод для генерации случайной соли
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 байт - стандартная длина соли
        random.nextBytes(salt);
        return salt;
    }


    public void showUser(){
        System.out.println("User name: " + this.name + " Surname: " + this.surname +
                " PhoneNumber: " + this.phoneNumber + " Password hash: " + password);
    }


    public static User objectUser(User usr){

        return usr;
    }


}

