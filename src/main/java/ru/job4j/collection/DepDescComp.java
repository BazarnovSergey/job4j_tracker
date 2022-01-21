package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] dep1 = o1.split("/");
        String[] dep2 = o2.split("/");
        return dep2[0].compareTo(dep1[0]) != 0
                ? dep2[0].compareTo(dep1[0]) : o1.compareTo(o2);
    }
}
