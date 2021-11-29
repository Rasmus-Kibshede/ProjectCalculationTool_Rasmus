package projectCalculationTool.project;

public interface ProjectRepositoryInterface {

  void create(Project project);

  Project read(int projectID);
}
