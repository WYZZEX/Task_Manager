package TaskManager;

import java.time.LocalDate;
public record Task(String title, String description, LocalDate dueDate, int priority) {
}
