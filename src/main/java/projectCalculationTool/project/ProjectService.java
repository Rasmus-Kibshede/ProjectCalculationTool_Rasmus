package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectService {

    private ProjectRepositoryInterface projectRepositoryInterface;

    public ProjectService(ProjectRepositoryInterface projectRepositoryInterface) {
        this.projectRepositoryInterface = projectRepositoryInterface;
    }

    public void createProject(String projectName, Employee employee) throws SQLException {
        Project project = new Project();
        project.setEmployee(employee);
        project.setName(projectName);
        projectRepositoryInterface.createProject(project);
    }

    public ArrayList<Project> readProjects(Employee employee) throws SQLException {
        return projectRepositoryInterface.readProjects(employee);
    }

    public Project readProject(int projectID) throws SQLException {
        return projectRepositoryInterface.readProject(projectID);
    }

    public Project updateProject(Project project){
        return null;
    }

    public void deleteProject(int projectID){}

}
