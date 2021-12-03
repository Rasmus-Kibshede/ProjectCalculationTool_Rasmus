package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.util.exception.ProjectException;

import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class ProjectService {

  private ProjectRepositoryInterface projectRepositoryInterface;

  public ProjectService(ProjectRepositoryInterface projectRepositoryInterface) {
    this.projectRepositoryInterface = projectRepositoryInterface;
  }

  public void createProject(String projectName, Employee employee) throws MissingFormatArgumentException, ProjectException {
    Project project = new Project();
    project.setEmployee(employee);
    project.setName(projectName);
    projectRepositoryInterface.createProject(project);
  }

  public ArrayList<Project> readProjects(Employee employee) throws ProjectException {
    return projectRepositoryInterface.readProjects(employee);
  }

  public Project readProject(int projectID) throws ProjectException {
    return projectRepositoryInterface.readProject(projectID);
  }

  public void deleteProject(int projectID) throws ProjectException {
    projectRepositoryInterface.deleteProject(projectID);
  }

  public void updateProject(Project project, String projectName) throws ProjectException {
    project.setName(validateProjectName(projectName));
    projectRepositoryInterface.updateProject(project);
  }

  //ER DET EN SQLEXCEPTION DER SKAL BRUGES HER???
  public String validateProjectName(String projectName) throws ProjectException {
    if (projectName != null && !projectName.isEmpty() && projectName.length() <= 45) {
      return projectName;
    } else {
      throw new ProjectException("Project name can't be null or longer then 45 characters.");
    }
  }
}
