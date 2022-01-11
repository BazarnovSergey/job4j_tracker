package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("Lobov@mail.ru", "Lobov Mihail Ivanovich");
        mail.put("Ponomarev@mail.ru", "Ponomarev Victor Vladimirovich");
        mail.put("Maksimov@mail.ru", "Maksimov Oleg Pavlovich");
        for (String key : mail.keySet()) {
            System.out.println(mail.get(key));
        }
    }
}
