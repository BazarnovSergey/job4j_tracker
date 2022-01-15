package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {

    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "Sergey Petrov"),
                new Item(1, "Arseniy Bivshev"),
                new Item(3, "Vitaliy Kuznetsov"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Arseniy Bivshev"),
                new Item(2, "Sergey Petrov"),
                new Item(3, "Vitaliy Kuznetsov"));
        assertThat(items, is(expected));
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "Sergey Petrov"),
                new Item(1, "Arseniy Bivshev"),
                new Item(3, "Vitaliy Kuznetsov"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "Vitaliy Kuznetsov"),
                new Item(2, "Sergey Petrov"),
                new Item(1, "Arseniy Bivshev"));
        assertThat(items, is(expected));
    }

}