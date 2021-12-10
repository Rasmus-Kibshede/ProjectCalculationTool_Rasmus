package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.SubProjectException;

public interface SubProjectRepositoryInterface {
  void createSubProject(Project project) throws SubProjectException;
  SubProject readSubProject(int subprojectID) throws SubProjectException;
  Project readAllSubProjects(Project project) throws SubProjectException;
  void updateSubProject(int subprojectID, String subprojectName) throws SubProjectException;
  void deleteSubProject(int subProjectID) throws SubProjectException;
}
