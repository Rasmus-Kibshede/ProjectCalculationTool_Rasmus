package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

import java.sql.SQLException;

public interface TaskRepositoryInterface {
  void create(SubProject subProject) throws SQLException;
  Task read(int taskID);
}
