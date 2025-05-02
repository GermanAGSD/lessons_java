package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Keys {
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
    // Метод для проверки введённого пароля с хэшированным паролем
    public static boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        String hashedEnteredPassword = generateSHA256Hash(enteredPassword);
        return hashedEnteredPassword.equals(storedHashedPassword);
    }
}
