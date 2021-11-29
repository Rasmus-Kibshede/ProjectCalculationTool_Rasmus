package projectCalculationTool.project;

import projectCalculationTool.employee.Employee;

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

    public Project readProject(int employeeID) {
        return projectRepositoryInterface.read(employeeID);
    }

}
