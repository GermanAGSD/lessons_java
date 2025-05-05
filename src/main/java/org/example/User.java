package org.example;
import com.google.gson.Gson;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.UUID;

public class User extends UserKeys {
    private HashMap<String, User> storage;
    public String id;
    public String name;
    public String surname;
    public String phoneNumber;
    public String password;

    User() {}

    public String getPassword() {
        return password;
    }

    private static String checkNullOrEmpty(String value){
        if(value == null && value.isEmpty()){
//            logger.error("Value is Empty or Null");
            return null;
        }
        return value;
    }

    public User(String name, String surname, String phoneNumber, String password ){

        this.id = UUID.randomUUID().toString();
        this.name = upperTo(name);
        this.surname = upperTo(surname);
        this.phoneNumber = checkNumber(phoneNumber);
        this.password = generateSHA256Hash(password);
        passTOFile(generateSHA256Hash(password));
        storage = new HashMap<>();
    }

    public User(String name, String password ){
        this.id = UUID.randomUUID().toString();
        this.name = upperTo(name);
        this.password = generateSHA256Hash(password);
    }

    public void addUser(User usr){
        storage.put(this.name, usr);
        System.out.println("User Added " + storage);
    }

    public String upperTo(String name){

        if(checkNullOrEmpty(name) != null){
            return name.substring(0,1).toUpperCase() + name.substring(1);
        }
        return null;
    }

    public String checkNumber(String phoneNumber){
        checkNullOrEmpty(phoneNumber);
        if(phoneNumber.length() < 6){
//            logger.error("Phone not valid < 6 symbol");
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


    public String toString(){
        System.out.println("User name: " + this.name + " Surname: " + this.surname +
                " PhoneNumber: " + this.phoneNumber + " Password hash: " + password);
        return null;
    }

    public void toJson(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
    }

    // Новый метод — печать всех пользователей через Gson
    public void printStorage() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(storage));
    }

    public String getName() {
        return name;
    }
}

