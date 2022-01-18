package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String arrLeft = left.split("\\.")[0];
        String arrRight = right.split("\\.")[0];
        int intLeft = Integer.parseInt(arrLeft);
        int intRight = Integer.parseInt(arrRight);
        return Integer.compare(intLeft, intRight);
    }
}
