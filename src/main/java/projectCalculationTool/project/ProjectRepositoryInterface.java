package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public interface ProjectRepositoryInterface {

  void createProject(Project project) throws MissingFormatArgumentException, SQLException;

  ArrayList<Project> readProjects(Employee employee);

  Project readProject(int projectID) throws SQLException;

  Project updateProject(Project project);

  void deleteProject(int projectID);
}
