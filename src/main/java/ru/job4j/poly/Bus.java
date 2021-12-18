package ru.job4j.poly;

public class Bus implements Transport {

    private double price = 51.60;

    @Override
    public void drive() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("Число пассажиров в автобусе: " + numberOfPassengers);
    }

    @Override
    public double refuel(double liters) {
        return liters * price;
    }
}
