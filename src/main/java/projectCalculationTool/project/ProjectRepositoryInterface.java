package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProjectRepositoryInterface {

  void create(Project project) throws SQLException;

  ArrayList<Project> readProjects(Employee employee);

  Project readProject(int projectID) throws SQLException;
}
