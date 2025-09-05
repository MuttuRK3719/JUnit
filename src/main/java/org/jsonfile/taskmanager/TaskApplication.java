package org.jsonfile.taskmanager;

import java.util.Scanner;

public class TaskApplication {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/jsonfile/taskmanager/TaskJson.json";
        choices(filePath);
    }

    static void choices(String filePath) {
        TaskManager manager = new TaskManager();
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter 1 for add task");
            System.out.println("Enter 2 for update task");
            System.out.println("Enter 3 for mark as completed the task");
            System.out.println("Enter 4 for delete task");

            switch (scan.nextInt()) {
                case 1 -> manager.addTask(filePath);
                case 2 -> manager.updateTask(filePath);
                case 3 -> manager.isCompleted(filePath);
                case 4 -> manager.deleteTask(filePath);
                default -> System.out.println("Enter correct choice ");
            }
        } while (true);
    }
}
