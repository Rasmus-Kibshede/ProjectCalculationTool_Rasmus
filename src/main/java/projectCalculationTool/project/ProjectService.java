package projectCalculationTool.project;

public class ProjectService {

  private ProjectRepository projectRepository;

  public ProjectService(ProjectRepository projectRepository){
    this.projectRepository = projectRepository;
  }
  public Project createProject(Project project){
    return projectRepository.create(project);
  }

  public Project readProject(int projectID){
    return projectRepository.read(projectID);
  }
}
