package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;
import projectCalculationTool.util.exception.LoginException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

public class ProjectService {

    private ProjectRepositoryInterface projectRepositoryInterface;

    public ProjectService(ProjectRepositoryInterface projectRepositoryInterface) {
        this.projectRepositoryInterface = projectRepositoryInterface;
    }

    public void createProject(String projectName, Employee employee) throws MissingFormatArgumentException, SQLException {
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

    //ER DET EN SQLEXCEPTION DER SKAL BRUGES HER???
    public String validateProjectName(String projectName) throws MissingFormatArgumentException {
        if (projectName != null && !projectName.isEmpty() && projectName.length() <= 45) {
            return projectName;
        } else {
            throw new MissingFormatArgumentException("Project name can't be null or longer then 45 characters.");
        }
    }
}
