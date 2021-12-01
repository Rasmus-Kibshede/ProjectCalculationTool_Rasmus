package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjectRepositoryInterface {

  void createProject(Project project) throws SQLException;

  ArrayList<Project> readProjects(Employee employee) throws SQLException;

  Project readProject(int projectID) throws SQLException;

  Project updateProject(Project project) throws SQLException;

  void deleteProject(int projectID) throws SQLException;
}
