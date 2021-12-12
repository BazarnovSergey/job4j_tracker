package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 356);
        Book goreOtUma = new Book("Gore Ot Uma", 98);
        Book voinaImir = new Book("Voina i Mir", 1274);
        Book headFirstJava = new Book("Head First Java", 722);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = goreOtUma;
        books[2] = voinaImir;
        books[3] = headFirstJava;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        books[0] = headFirstJava;
        books[3] = cleanCode;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (Book bk : books) {
            if (bk.getName() == "Clean code") {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}