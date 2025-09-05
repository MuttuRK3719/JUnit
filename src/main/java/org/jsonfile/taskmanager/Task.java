package org.jsonfile.taskmanager;

import java.time.LocalDate;

public class Task {
    private static int count;
    private int id;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String description, LocalDate dueDate, boolean completed) {
        this.id = ++count;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public Task() {
        this.id = ++count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
