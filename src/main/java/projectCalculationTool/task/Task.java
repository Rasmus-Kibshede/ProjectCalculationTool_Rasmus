package projectCalculationTool.task;

public class Task {
  private double time;
  private String name;
  private int taskID;

  public double getTime() {
    return time;
  }

  public void setTime(double time) {
    this.time = time;
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

  public Task(double time, String name, int taskID) {
    this.time = time;
    this.name = name;
    this.taskID = taskID;
  }

}
