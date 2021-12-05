package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.SubProjectException;

public interface SubProjectRepositoryInterface {
  void createSubProject(Project project) throws SubProjectException;
  SubProject readSubProject(int subprojectID) throws SubProjectException;
  Project readSubProjects(Project project) throws SubProjectException;
  void updateSubProject(int id, String name) throws SubProjectException;
  void deleteSubProject(int subProjectID) throws SubProjectException;
}
