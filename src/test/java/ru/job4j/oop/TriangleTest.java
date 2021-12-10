package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void area() {
        int expected = 8;
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void NotTriangle() {
        int expected = -1;
        Point a = new Point(0, 0);
        Point b = new Point(7, 5);
        Point c = new Point(0, 0);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(rsl, expected, 0.01);
    }
}
