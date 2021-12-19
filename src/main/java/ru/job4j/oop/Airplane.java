package ru.job4j.oop;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет начинает взлетать");
    }

    @Override
    public void stop() {
        System.out.println("Самолет приземлился в аэропорту");
    }
}
