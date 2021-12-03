package projectCalculationTool.task;

public class Task {
  private double timeHours;
  private String name;
  private int taskID;

  public Task(double time, String name) {
    this.timeHours = time;
    this.name = name;
  }

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

  public int calculateTimeInDays(){
    int time = (int) Math.ceil(timeHours);
    int workDay = time /8;
    return workDay;
  }
}
