package org.example;

import java.util.Comparator;

public class TComp implements Comparator<String> {

    public int compare(String aStr, String bStr) {
        int i, j, k;
        i = aStr.lastIndexOf(" ");
        j = bStr.lastIndexOf(" ");
        k = aStr.substring(i).compareToIgnoreCase(bStr);
        if(k==0){
            return aStr.compareToIgnoreCase(bStr);
        }else {
            return k;
        }
    }
}
