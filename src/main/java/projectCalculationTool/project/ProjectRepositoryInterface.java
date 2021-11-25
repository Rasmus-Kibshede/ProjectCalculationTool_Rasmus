package projectCalculationTool.project;

public interface ProjectRepositoryInterface {

  Project create(Project project);

  Project read(int projectID);
}
