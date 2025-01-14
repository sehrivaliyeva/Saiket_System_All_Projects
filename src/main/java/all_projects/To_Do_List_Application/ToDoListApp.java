package all_projects.To_Do_List_Application;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    static class Task {
        private String title;
        private boolean isCompleted;

        public Task(String title) {
            this.title = title;
            this.isCompleted = false;
        }

        public String getTitle() {
            return title;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void markAsComplete() {
            this.isCompleted = true;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[✔]" : "[ ]") + " " + title;
        }
    }

    private static final ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new task");
            System.out.println("2. Mark a task as complete");
            System.out.println("3. Display all tasks");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    markTaskAsComplete(scanner);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.println("Goodbye! Thank you for using the To-Do List Application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the title of the task: ");
        String title = scanner.nextLine();
        Task newTask = new Task(title);
        taskList.add(newTask);
        System.out.println("Task added successfully!");
    }


    private static void markTaskAsComplete(Scanner scanner) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available to mark as complete.");
            return;
        }
        displayTasks();
        System.out.print("Enter the number of the task to mark as complete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= taskList.size()) {
            Task task = taskList.get(taskNumber - 1);
            task.markAsComplete();
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, taskList.get(i));
        }
    }
}
