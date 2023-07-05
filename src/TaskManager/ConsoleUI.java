package TaskManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Создать задачу");
            System.out.println("2 - Просмотреть все задачи");
            System.out.println("3 - Сортировать задачи по дате выполнения");
            System.out.println("4 - Сортировать задачи по приоритету");
            System.out.println("0 - Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки после ввода числа

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    taskManager.viewAllTasks();
                    break;
                case 3:
                    taskManager.sortTasksByDate();
                    System.out.println("Задачи отсортированы по дате выполнения.");
                    break;
                case 4:
                    taskManager.sortTasksByPriority();
                    System.out.println("Задачи отсортированы по приоритету.");
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите действие из списка.");
                    break;
            }
        }
    }

    public static void createTask() {
        try {
            System.out.println("Создание новой задачи");
            System.out.print("Введите название задачи: ");
            String title = scanner.nextLine();

            System.out.print("Введите описание задачи: ");
            String description = scanner.nextLine();

            System.out.print("Введите дату выполнения задачи (в формате ДД.ММ.ГГГГ): ");
            String dateString = scanner.nextLine();
            LocalDate dueDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            System.out.print("Введите приоритет задачи (1 - низкий, 2 - средний, 3 - высокий): ");
            int priority = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки после ввода числа

            Task task = new Task(title, description, dueDate, priority);
            taskManager.addTask(task);

            System.out.println("Задача успешно создана!");
        } catch (Exception e) {
            System.out.println("Ошибка при создании задачи. Проверьте правильность введенных данных.");
        }
    }
}
