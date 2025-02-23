package org.example;

import java.util.Arrays;

public class StorageSklad {
    private static final int STORAGE_SIZE = 12;
    private static String[] storageList = new String[STORAGE_SIZE];
    private static int freePlaces;

    public static int getFreePlaces() {
        checkFreePlaces();
        return freePlaces;
    }

    public static void addObject(String object) {
        // Сортируем перед поиском
        Arrays.sort(storageList, (a, b) -> {
            if (a == null) return 1; // Null-элементы в конец
            if (b == null) return -1;
            return a.compareTo(b);
        });

        // Проверяем, есть ли объект в массиве
        int index = Arrays.binarySearch(storageList, object);
        if (index >= 0) {
            System.out.println("Object already exists");
            return;
        }

        // Ищем свободное место (null или пустая строка)
        for (int i = 0; i < storageList.length; i++) {
            if (storageList[i] == null || storageList[i].isEmpty()) {
                storageList[i] = object.toLowerCase();
                Arrays.sort(storageList); // Пересортируем после добавления
                System.out.println("Object added: " + object);
                return;
            }
        }

        System.out.println("Object not added, storage full");
    }

    public static void checkFreePlaces() {
        freePlaces = STORAGE_SIZE - Arrays.binarySearch(storageList, " ") - 1;
    }
}
