package org.example;

import java.util.Comparator;

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        return bStr.compareTo(aStr); // Обратная сортировка
    }
}

