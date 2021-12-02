package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;
import projectCalculationTool.util.exception.ProjectException;

public class TaskService {
  private TaskRepositoryInterface taskRepositoryInterface;

  public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
    this.taskRepositoryInterface = taskRepositoryInterface;
  }

  public void createTask(String taskName, double taskTime, SubProject subProject) throws ProjectException {
    Task task = new Task(taskTime, validateTaskName(taskName));
    subProject.addTask(task);
    taskRepositoryInterface.createTask(subProject);
  }

  public Task readTask(int taskID) {
    return null;
  }

  public Task updateTask(Task task){
    return null;
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

  // Valider at det eren gyldig double time

  //ER DET DEN RIGTIGE EXCEPTION??
  public double validateTaskTime(String taskTime) throws ProjectException {
    double taskTimeNew;

    if (taskTime != null && !taskTime.isEmpty()) {
      taskTimeNew = Double.parseDouble(taskTime);
      return taskTimeNew;
    } else {
      throw new ProjectException("Task time has to be a number.");
    }
  }
}