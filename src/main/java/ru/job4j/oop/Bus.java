package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус начинает движение по дороге");
    }

    @Override
    public void stop() {
        System.out.println("Автобус остановился на автовокзале");
    }
}
