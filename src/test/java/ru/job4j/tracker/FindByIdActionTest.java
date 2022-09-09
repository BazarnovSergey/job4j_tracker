package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdActionTest {

    @Test
    public void whenFindByIdActionActionThenSuccess() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New Item");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln
                + tracker.findAll().get(0) + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenFindByIdActionThenFail() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New Item");
        Item item2 = new Item("New Item2");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item2.getName());

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln
                + "Заявка с введенным id: " + item2.getId() + " не найдена." + ln);
    }
}