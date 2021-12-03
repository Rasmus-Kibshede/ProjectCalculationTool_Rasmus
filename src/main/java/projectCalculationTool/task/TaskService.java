package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

import java.sql.SQLException;

public class TaskService {
  private TaskRepositoryInterface taskRepositoryInterface;

  public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
    this.taskRepositoryInterface = taskRepositoryInterface;
  }

  public void createTask(String taskName, String taskTime, int subProjectID, SubProject subProject) throws SQLException, ProjectException {
    //skal ikke laves new
    subProject = new SubProject();
    subProject.setSubProjectID(subProjectID);

    Task task = new Task(validateTaskTime(taskTime), validateTaskName(taskName));
    subProject.addTask(task);
    taskRepositoryInterface.createTask(subProject);
  }

  public Task readTask(int taskID) {
    return null;
  }

  public Task updateTask(String taskTime, String taskName) throws ProjectException{
    Task task = new Task(validateTaskTime(taskTime), validateTaskName(taskName));
    return task;
  }

  public void deleteTask(int task){}

  //ER DET DEN RIGTIGE EXCEPTION??
  public String validateTaskName(String taskName)throws ProjectException{
    if (taskName != null && !taskName.isEmpty() && taskName.length() <= 45) {
      return taskName;
    } else {
      throw new ProjectException("Task name can't be null or longer then 45 characters.");
    }
  }

  //ER DET DEN RIGTIGE EXCEPTION??
  public double validateTaskTime(String taskTime) throws ProjectException{
    double taskTimeNew;

    if (taskTime != null && !taskTime.isEmpty()) {
      taskTimeNew = Double.parseDouble(taskTime);
      return taskTimeNew;
    } else {
      throw new ProjectException("Task time has to be a number."); //Tager ikke højde for komma/punktum
    }
  }
}
