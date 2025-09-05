package org.jsonfile.taskmanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    Scanner scan = new Scanner(System.in);

    private void addTask(Task task, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileWriter(filePath, true), task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTask(String filePath) {
        Task task = new Task();
        System.out.println("Enter the task description");
        task.setDescription(scan.nextLine());
        System.out.println("Enter the Due day date only");
        int day = scan.nextInt();
        System.out.println("Enter the Due month  only");
        int month = scan.nextInt();
        System.out.println("Enter the Due year only");
        int year = scan.nextInt();
        task.setDueDate(LocalDate.of(year, month, day));
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            File file = new File(filePath);
            FileReader reader = new FileReader(filePath);
            List<Task> tasks = new ArrayList<>();
            try {
                if (file.length() > 0)
                    tasks = mapper.readValue(file, new TypeReference<List<Task>>() {
                    });
                System.out.println("is exits");
                tasks.add(task);
            } catch (Exception e) {
                Task singleTask = mapper.readValue(reader, Task.class);
                tasks.add(singleTask);
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTask(String filePath) {
        System.out.println("Enter the task Id");
        int id = scan.nextInt();
        System.out.println("Enter the task description");
        String description = scan.next();
        System.out.println("Enter the Due date");
        String date = scan.next();
        boolean updated = false;
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayNode arr = (ArrayNode) mapper.readTree(file);
            for (JsonNode node : arr) {
                if (node.get("id").asInt() == id) {
                    ((ObjectNode) node).put("description", description);
                    ((ObjectNode) node).put("dueDate", date);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(file, arr);
                    return;
                }
            }
            System.err.println("It is not in json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void isCompleted(String filePath) {
        System.out.println("Enter task id ");
        int id = scan.nextInt();
        File file = new File(filePath);
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode arrayNode = (ArrayNode) mapper.readTree(file);
            for (JsonNode node : arrayNode) {
                if (node.get("id").asInt() == id) {
                    ((ObjectNode) node).put("completed", true);
                    mapper.writerWithDefaultPrettyPrinter().writeValue(file, arrayNode);
                    return;
                }
            }
            System.out.println("No such Task is available");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        System.out.println("Enter task id");
        int id = scan.nextInt();
        boolean deleted = false;
        try {
            ArrayNode arrayNode = (ArrayNode) mapper.readTree(file);
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode node = arrayNode.get(i);
                if (node.get("id").asInt() == id) {
                    arrayNode.remove(i);
                    deleted = true;
                }
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, arrayNode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
