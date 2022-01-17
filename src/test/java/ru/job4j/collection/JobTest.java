package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobTest {

    @Test
    public void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3),
                new Job("Algorithm development", 2)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Algorithm development", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("X task", 3)
        );
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3),
                new Job("Algorithm development", 2)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("X task", 3),
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Algorithm development", 2));
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3),
                new Job("Algorithm development", 2)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Algorithm development", 2),
                new Job("X task", 3));
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3),
                new Job("Algorithm development", 2)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("X task", 3),
                new Job("Algorithm development", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0));
        assertThat(jobs, is(expected));
    }

    @Test
    public void whenComparatorDescByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByPriorityAndAscByName() {
        Comparator<Job> cmpPriority = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriorityAndDescByName() {
        Comparator<Job> cmpPriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}