package com.originalstocksllc.himanshuraj.todo.model;

public class ToDo {

    private Integer id;
    private String task;
    private boolean done;

    public ToDo(Integer id, String task, boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public ToDo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }
}
