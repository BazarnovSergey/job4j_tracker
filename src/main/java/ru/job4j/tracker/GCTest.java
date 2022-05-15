package ru.job4j.tracker;

public class GCTest {

    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        for (int i = 0; i < 100_000; i++) {
            memTracker.add(new Item("item " + i));
        }
    }
}
