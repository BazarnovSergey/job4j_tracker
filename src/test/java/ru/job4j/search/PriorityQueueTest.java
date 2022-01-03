package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenPriorityEqual() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("one", 1));
        queue.put(new Task("two", 1));
        queue.put(new Task("three", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("three"));
    }

    @Test
    public void whenNotElement() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        Task result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }
}