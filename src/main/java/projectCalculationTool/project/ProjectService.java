package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

import java.util.ArrayList;

public class ProjectService {

    private ProjectRepositoryInterface projectRepositoryInterface;

    public ProjectService(ProjectRepositoryInterface projectRepositoryInterface) {
        this.projectRepositoryInterface = projectRepositoryInterface;
    }

    public void createProject(String projectName, Employee employee) {
        Project project = new Project();
        project.setEmployee(employee);
        project.setName(projectName);
        projectRepositoryInterface.create(project);
    }

    public ArrayList<Project> readProjects(Employee employee) {
        return projectRepositoryInterface.readProjects(employee);
    }

}
