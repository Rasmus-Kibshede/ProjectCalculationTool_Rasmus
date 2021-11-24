package projectCalculationTool.project;

public class ProjectService {

  private ProjectRepository projectRepository;

  public ProjectService(ProjectRepository projectRepository){
    this.projectRepository = projectRepository;
  }
  public void createProject(Project project){
    projectRepository.create(project);
  }

  public Project readProject(int projectID){
    return projectRepository.read(projectID);
  }
}
