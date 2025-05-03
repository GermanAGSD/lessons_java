package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserKeys {
    // Метод для хэширования пароля с использованием SHA-256
    public static String generateSHA256Hash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
    /*
            Метод для валидации пароля
     */
    public static boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        String hashedEnteredPassword = generateSHA256Hash(enteredPassword);
        return hashedEnteredPassword.equals(storedHashedPassword);
    }

    public static void passTOFile(String HashPassword){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("password.txt"))){
            writer.write(HashPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String outFile(){
        String fileName = "password.txt"; // Имя файла с паролем
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String password = reader.readLine().trim(); // Читаем первую строку (предполагаем, что это пароль)
//            System.out.println("Пароль из файла: " + password); // Выводим пароль
            return password;
        } catch (IOException e) {
            throw new RuntimeException("no file or no password found", e);
        }
    }


}
