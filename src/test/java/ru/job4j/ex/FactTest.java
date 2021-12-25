package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThan0() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

    @Test
    public void when5That120() {
        Fact fact = new Fact();
        int rsl = fact.calc(5);
        int expected = 120;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void when3That6() {
        Fact fact = new Fact();
        int rsl = fact.calc(3);
        int expected = 6;
        Assert.assertEquals(expected, rsl);
    }

    @Test
    public void when0That1() {
        Fact fact = new Fact();
        int rsl = fact.calc(0);
        int expected = 1;
        Assert.assertEquals(expected, rsl);
    }
}