package projectCalculationTool.task;

import projectCalculationTool.util.DBManager;

import java.sql.Connection;

public class TaskRepository implements TaskRepositoryInterface {
  private static Connection connection = DBManager.getConnection();

  @Override
  public Task create(Task task) {
    return null;
  }

  @Override
  public Task read(int taskID) {
    return null;
  }
}
