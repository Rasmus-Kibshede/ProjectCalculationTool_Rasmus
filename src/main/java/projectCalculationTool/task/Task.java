package projectCalculationTool.task;

public class Task {
  private double timeHours;
  private String name;
  private int taskID;

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
}
