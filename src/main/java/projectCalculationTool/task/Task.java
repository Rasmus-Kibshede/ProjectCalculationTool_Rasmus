package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

public class Task {
  private double timeHours;
  private String name;
  private int taskID;
  private SubProject subProject;

  public double getTimeHours() {
    return timeHours;
  }

  public void setTimeHours(double timeHours) {
    this.timeHours = timeHours;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTaskID() {
    return taskID;
  }

  public void setTaskID(int taskID) {
    this.taskID = taskID;
  }

  public Task(double time, String name) {
    this.timeHours = time;
    this.name = name;
  }

  public SubProject getSubProject() {
    return subProject;
  }

  public void setSubProject(SubProject subProject) {
    this.subProject = subProject;
  }

}
