package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд начинает движение по рельсам");
    }

    @Override
    public void stop() {
        System.out.println("Поезд остановился на железнодорожной станции");
    }
}
