package ru.job4j.tracker;

public class DeleteManyAction implements UserAction {

    private final Output out;

    public DeleteManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete All Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete All items ===");
        int count = input.askInt("How much Items delete: ");
        for (int i = 1; i <= count; i++) {
            if (tracker.delete(i)) {
                out.println("Заявка далена успешно");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}
