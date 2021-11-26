package projectCalculationTool.task;

public interface TaskRepositoryInterface {
  Task create(Task task);
  Task read(int taskID);
}
