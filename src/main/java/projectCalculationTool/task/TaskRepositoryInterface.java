package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskRepositoryInterface {
  SubProject createTask(SubProject subProject) throws SQLException;

  SubProject readTask(SubProject subProject) throws SQLException;

  Task updateTask(Task task);

  void deleteTask(int taskID);
}
