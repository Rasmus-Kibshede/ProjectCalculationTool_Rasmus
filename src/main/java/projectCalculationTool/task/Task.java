package projectCalculationTool.task;

public class Task {
  private int timeHours;
  private String name;
  private int taskID;

  public Task(int time, String name) {
    this.timeHours = time;
    this.name = name;
  }

  public double getTimeHours() {
    return timeHours;
  }

  public void setTimeHours(int timeHours) {
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
}
