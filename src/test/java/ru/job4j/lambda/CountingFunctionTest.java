package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountingFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        CountingFunction function = new CountingFunction();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        CountingFunction function = new CountingFunction();
        List<Double> result = function.diapason(2, 5, x -> x * x - x - 1);
        List<Double> expected = Arrays.asList(1D, 5D, 11D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        CountingFunction function = new CountingFunction();
        List<Double> result = function.diapason(9, 12, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(512D, 1024D, 2048D);
        assertThat(result, is(expected));
    }
}