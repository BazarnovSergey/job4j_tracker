package ru.job4j.tracker;

public class CreateManyAction implements UserAction {
    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many new Item ===");
        String name = input.askStr("Enter name: ");
        int count = input.askInt("How much Items create: ");
        for (int i = 0; i < count; i++) {
            Item item = new Item(name);
            tracker.add(item);
        }
        out.println("Добавленная заявка: " + count);
        return true;
    }
}
