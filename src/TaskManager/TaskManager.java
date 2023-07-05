package TaskManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void viewAllTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Задача " + (i + 1));
            System.out.println("Название: " + tasks.get(i).title());
            System.out.println("Описание: " + tasks.get(i).description());
            System.out.println("Дата выполнения: " + tasks.get(i).dueDate());
            System.out.println("Приоритет: " + tasks.get(i).priority());
            System.out.println();
        }
    }

    public void sortTasksByDate() {
        tasks.sort(Comparator.comparing(Task::dueDate));
    }

    public void sortTasksByPriority() {
        tasks.sort(Comparator.comparingInt(Task::priority));
    }
}
