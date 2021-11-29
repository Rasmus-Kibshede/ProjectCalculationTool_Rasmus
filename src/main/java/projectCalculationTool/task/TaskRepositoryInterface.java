package projectCalculationTool.task;

import java.sql.SQLException;

public interface TaskRepositoryInterface {
  void create(Task task) throws SQLException;
  Task read(int taskID);
}
