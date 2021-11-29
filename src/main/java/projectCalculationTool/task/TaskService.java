package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

import java.sql.SQLException;

public class TaskService {
  private TaskRepositoryInterface taskRepositoryInterface;

  public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
    this.taskRepositoryInterface = taskRepositoryInterface;
  }

  public void createTask(String taskName, double taskTime, SubProject subProject) throws SQLException {
    Task task = new Task(taskTime, taskName);
    task.setSubProject(subProject);
    taskRepositoryInterface.create(task);
  }

  public Task readTask(int taskID) {
    return null;
  }
}
