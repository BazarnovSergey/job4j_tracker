package ru.job4j.pojo;

import java.util.Objects;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 356);
        Book goreOtUma = new Book("Gore Ot Uma", 98);
        Book voinaImir = new Book("Voina i Mir", 1274);
        Book headFirstJava = new Book("Head First Java", 722);
        Book[] books = {cleanCode, goreOtUma, voinaImir, headFirstJava};
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        books[0] = headFirstJava;
        books[3] = cleanCode;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (Book bk : books) {
            if (Objects.equals(bk.getName(), "Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}