package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.util.exception.ProjectException;

import java.util.ArrayList;

public interface ProjectRepositoryInterface {

  void createProject(Project project) throws ProjectException;

  ArrayList<Project> readProjects(Employee employee) throws ProjectException;

  Project readProject(int projectID) throws ProjectException;

  Project updateProject(Project project) throws ProjectException;

  void deleteProject(int projectID) throws ProjectException;
}
