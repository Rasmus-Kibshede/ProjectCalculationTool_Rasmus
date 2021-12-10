package projectCalculationTool.subproject;

import projectCalculationTool.task.Task;

import java.util.ArrayList;

public class SubProject {

  private int subProjectID;
  private String name;
  private int workdays;
  private ArrayList<Task> tasks = new ArrayList<>();

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

  public int getWorkdays() {
    return workdays;
  }

  public ArrayList<Task> getTasks() {
    return tasks;
  }

  public void setTasks(ArrayList<Task> tasks) {
    this.tasks = tasks;
  }

  public void addTask(Task task) {
    this.tasks.add(task);
  }

  public void calculateDaysTotal() {
    int daySubTotal = 0;

    for (int i = 0; i < this.tasks.size(); i++) {
      daySubTotal += this.tasks.get(i).getTimeHours();
    }
    calculateWorkdays(daySubTotal);
  }

  // Kilde: https://www.baeldung.com/java-round-up-nearest-hundred
  public void calculateWorkdays(int time) {
    double calcWorkdays = (double)time/8;
    int workdays = (int) Math.ceil(calcWorkdays);
    this.workdays = workdays;
  }
}