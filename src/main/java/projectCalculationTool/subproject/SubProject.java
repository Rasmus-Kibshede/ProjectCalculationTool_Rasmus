package projectCalculationTool.subproject;

import projectCalculationTool.task.Task;

import java.util.ArrayList;

public class SubProject {

    private int subProjectID;
    private String name;
    private double timeSubTotal;
    private ArrayList<Task> tasks;

    public SubProject(String subProjectName) {
        this.name = subProjectName;
    }

    public int getSubProjectID() {
        return subProjectID;
    }

    public void setSubProjectID(int subProjectID) {
        this.subProjectID = subProjectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTimeSubTotal() {
        return timeSubTotal;
    }

    public void setTimeSubTotal(double timeSubTotal) {
        this.timeSubTotal = timeSubTotal;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
