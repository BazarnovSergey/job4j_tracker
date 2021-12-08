package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int n) {
        return n / x;
    }

    public int sumAllOperation(int w) {
        return sum(w) + multiply(w) + minus(w) + divide(w);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        System.out.println(sum(6));
        System.out.println(calculator.multiply(8));
        System.out.println(minus(16));
        System.out.println(calculator.divide(20));
        System.out.println(calculator.sumAllOperation(10));
    }
}
