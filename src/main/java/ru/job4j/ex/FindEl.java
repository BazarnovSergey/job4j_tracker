package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key)
            throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(key, value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Item not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = new String[10];
        try {
            indexOf(value, "Item");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
