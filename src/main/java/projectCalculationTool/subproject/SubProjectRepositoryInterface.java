package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SubProjectRepositoryInterface {
  void create(Project project) throws SQLException;
  SubProject read(ResultSet resultSet) throws SQLException;
}
