package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SubProjectRepositoryInterface {
  void createSubProject(Project project) throws SQLException;
  ArrayList<SubProject> readSubProject(ResultSet resultSet) throws SQLException;
  SubProject updateSubProject(SubProject subProject);
  void deleteSubProject(int subProjectID);
}
