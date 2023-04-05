package com.example.Assignment.ComparatorUtility;

import java.util.Comparator;

public class CapitalLetterComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = o1.compareToIgnoreCase(o2);
        if (result == 0) {
            boolean o1Capital = Character.isUpperCase(o1.charAt(0));
            boolean o2Capital = Character.isUpperCase((o2.charAt(0)));
            if (o1Capital == true && o2Capital == false) result = 1;
            if (o1Capital == false && o2Capital == true) result = -1;


        }
        return result;
    }
}
