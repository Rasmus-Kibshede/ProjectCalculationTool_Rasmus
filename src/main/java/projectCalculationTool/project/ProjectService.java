package projectCalculationTool.project;

public class ProjectService {

  private ProjectRepositoryInterface projectRepositoryInterface;

  public ProjectService(ProjectRepositoryInterface projectRepositoryInterface){
    this.projectRepositoryInterface = projectRepositoryInterface;
  }
  public Project createProject(Project project){
    return projectRepositoryInterface.create(project);
  }

  public Project readProject(int employeeID){
    return projectRepositoryInterface.read(employeeID);
  }

}
