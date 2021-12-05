package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.SubProjectException;

public interface SubProjectRepositoryInterface {
  void createSubProject(Project project) throws SubProjectException;
  Project readSubProject(Project project) throws SubProjectException;
  SubProject updateSubProject(SubProject subProject);
  void deleteSubProject(int subProjectID);
}
