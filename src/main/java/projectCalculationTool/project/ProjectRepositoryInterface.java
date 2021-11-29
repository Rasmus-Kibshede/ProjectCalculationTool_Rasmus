package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

import java.util.ArrayList;

public interface ProjectRepositoryInterface {

  void create(Project project);

  ArrayList<Project> readProjects(Employee employee);
}
