package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle[] vehicles = {train, bus, airplane};
        for (Vehicle a : vehicles) {
            a.move();
            a.stop();
        }
    }
}
