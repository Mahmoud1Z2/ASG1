package com.example.myapplication;

public class Task {
    private String task;
    private String Discreption;

    private String date;

    public Task(String task, String discreption,String date) {
        this.task = task;
        Discreption = discreption;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDiscreption() {
        return Discreption;
    }

    public void setDiscreption(String discreption) {

        Discreption = discreption;
    }

    @Override
    public String toString() {
        return  task;

    }
}
