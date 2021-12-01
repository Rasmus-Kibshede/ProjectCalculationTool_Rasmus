package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskRepositoryInterface {
  void createTask(SubProject subProject) throws SQLException;
  ArrayList<Task> readTask(ResultSet resultSet, int subProjectID) throws SQLException;
  Task updateTask(Task task);
  void deleteTask(int taskID);
}
