package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskRepositoryInterface {
  void create(SubProject subProject) throws SQLException;
  ArrayList<Task> read(ResultSet resultSet, int subProjectID) throws SQLException;
}
