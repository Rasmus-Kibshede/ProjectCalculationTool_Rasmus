package projectCalculationTool.subproject;

public interface SubProjectRepositoryInterface {
  SubProject create(SubProject subProject);
  SubProject read(int subProjectID);
}
