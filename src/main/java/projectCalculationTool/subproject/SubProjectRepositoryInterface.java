package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;

import java.sql.SQLException;

public interface SubProjectRepositoryInterface {
  void create(Project project) throws SQLException;
  SubProject read(int subProjectID) throws SQLException;
}
