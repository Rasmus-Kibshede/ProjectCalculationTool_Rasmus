package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

import java.sql.SQLException;

public class TaskService {
  private TaskRepositoryInterface taskRepositoryInterface;

  public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
    this.taskRepositoryInterface = taskRepositoryInterface;
  }

  public void createTask(String taskName, double taskTime, int subProjectID, SubProject subProject) throws SQLException, ProjectException {
    //skal ikke laves new
    subProject = new SubProject();
    subProject.setSubProjectID(subProjectID);

    Task task = new Task(taskTime, validateTaskName(taskName));
    subProject.addTask(task);
    taskRepositoryInterface.createTask(subProject);
  }

  public Task readTask(int taskID) {
    return null;
  }

  public Task updateTask(double taskTime, String taskName){
    Task task = new Task(taskTime, taskName);
    return task;
  }

  public void deleteTask(int task){}

  //ER DET DEN RIGTIGE EXCEPTION??
  public String validateTaskName(String taskName)throws SQLException{
    if (taskName != null && !taskName.isEmpty() && taskName.length() <= 45) {
      return taskName;
    } else {
      throw new SQLException("Task name can't be null or longer then 45 characters.");
    }
  }

  //ER DET DEN RIGTIGE EXCEPTION??
  public double validateTaskTime(String taskTime) throws SQLException{
    double taskTimeNew;

    if (taskTime != null && !taskTime.isEmpty()) {
      taskTimeNew = Double.parseDouble(taskTime);
      return taskTimeNew;
    } else {
      throw new SQLException("Task time has to be a number.");
    }
  }
}
