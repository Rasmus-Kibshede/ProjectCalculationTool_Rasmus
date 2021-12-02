package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.ProjectException;

public interface SubProjectRepositoryInterface {
  void createSubProject(Project project) throws ProjectException;
  Project readSubProject(Project project) throws ProjectException;
  SubProject updateSubProject(SubProject subProject);
  void deleteSubProject(int subProjectID);
}
