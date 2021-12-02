package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SubProjectRepositoryInterface {
  void createSubProject(Project project) throws SQLException;
  Project readSubProject(Project project) throws SQLException;
  SubProject updateSubProject(SubProject subProject);
  void deleteSubProject(int subProjectID);
}
