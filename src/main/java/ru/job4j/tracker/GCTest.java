package ru.job4j.tracker;

import java.util.List;

public class GCTest {

    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new ShowAllItemsAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output),
                new CreateManyAction((output)),
                new DeleteManyAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}