package projectCalculationTool.task;

import projectCalculationTool.subproject.SubProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TaskRepositoryInterface {
  void create(SubProject subProject) throws SQLException;
  Task read(ResultSet resultSet) throws SQLException;
}
