package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    void whenFindByNameActionThenSuccess() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New Item");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln
                + tracker.findAll().get(0) + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(item.getName());
    }

    @Test
    void whenFindByNameActionThenFail() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New Item");
        Item item2 = new Item("New Item2");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item2.getName());

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln
                + "Заявки с именем: " + item2.getName() + " не найдены." + ln);
    }
}