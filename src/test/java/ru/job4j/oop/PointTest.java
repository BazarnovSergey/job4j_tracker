package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when7To4And4To24Then20() {
        Point a = new Point(7, 4);
        Point b = new Point(4, 24);
        double expected = 20.22;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when5To9And1To12Then5() {
        Point a = new Point(5, 9);
        Point b = new Point(1, 12);
        double expected = 5;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when2To4To7And4To8to14Then8() {
        Point a = new Point(2, 4, 7);
        Point b = new Point(4, 8, 14);
        double expected = 8.31;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when3To6To13And5To15to23Then13() {
        Point a = new Point(3, 6, 13);
        Point b = new Point(5, 15, 23);
        double expected = 13.6;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
