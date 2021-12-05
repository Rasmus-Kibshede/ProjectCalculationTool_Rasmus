package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.util.exception.ProjectException;
import projectCalculationTool.util.exception.ValidateException;

import java.util.ArrayList;

public class ProjectService {

    private ProjectRepositoryInterface projectRepositoryInterface;

    public ProjectService(ProjectRepositoryInterface projectRepositoryInterface) {
        this.projectRepositoryInterface = projectRepositoryInterface;
    }

    public void createProject(String projectName, Employee employee) throws ProjectException {
        Project project = new Project();
        project.setEmployee(employee);
        project.setName(projectName);
        projectRepositoryInterface.createProject(project);
    }

    public ArrayList<Project> readProjects(Employee employee) throws ProjectException {
        return projectRepositoryInterface.readProjects(employee);
    }

    public Project readProject(int projectID) throws ProjectException {
        Project project = projectRepositoryInterface.readProject(projectID);
        project.calculateWorkdaysDaysTotal();
        return project;
    }

    public void deleteProject(int projectID) throws ProjectException {
        projectRepositoryInterface.deleteProject(projectID);
    }

    public void updateProject(Project project, String projectName) throws ProjectException, ValidateException {
        project.setName(validateProjectName(projectName));
        projectRepositoryInterface.updateProject(project);
    }

    public String validateProjectName(String projectName) throws ValidateException {
        if (projectName != null && !projectName.isEmpty() && projectName.length() <= 45) {
            return projectName;
        } else {
            throw new ValidateException("Project name can't be null or longer then 45 characters.");
        }
    }
}
