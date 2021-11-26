package projectCalculationTool.task;

public class TaskService {
  private TaskRepositoryInterface taskRepositoryInterface;

  public TaskService(TaskRepositoryInterface taskRepositoryInterface) {
    this.taskRepositoryInterface = taskRepositoryInterface;
  }

  public Task createTask(Task task) {
    return null;
  }

  public Task readTask(int taskID) {
    return null;
  }
}
