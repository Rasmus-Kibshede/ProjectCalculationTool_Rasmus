package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.Task;
import projectCalculationTool.util.exception.ProjectException;

import java.sql.SQLException;

public class SubProjectService {
  private SubProjectRepositoryInterface subProjectRepositoryInterface;

  public SubProjectService(SubProjectRepositoryInterface subProjectRepositoryInterface) {
    this.subProjectRepositoryInterface = subProjectRepositoryInterface;
  }

  public void createSubProject(String subProjectName, int projectID, Project project) throws ProjectException {

    //skal ikke laves nyt project, der skal sendes et project med
    project = new Project();
    project.setProjectID(projectID);
    SubProject subProject = new SubProject(validateSubProjectName(subProjectName));
    project.addSubproject(validateSubProjectIncludesTask(subProject));

    subProjectRepositoryInterface.createSubProject(project);
  }

  //Edit method name in class diagram
  public SubProject readSubProject(int subProjectID) {
    //Return a SubProject
    return null;
  }

  public SubProject updateSubProject() {
    return null;
  }

  public void deleteSubProject() {
  }

  //ER DET DEN RIGTIGE EXCEPTION???
  public String validateSubProjectName(String subprojectName) throws ProjectException {
    if (subprojectName != null && !subprojectName.isEmpty() && subprojectName.length() <= 45) {
      return subprojectName;
    } else {
      throw new ProjectException("Project name can't be null or longer then 45 characters.");
    }
  }

  public SubProject validateSubProjectIncludesTask(SubProject subProject) throws ProjectException {
    if (subProject.getTasks() != null) {
      return subProject;
    } else {
      throw new ProjectException("You can't create SubProject without at least one Task");
    }
  }
}
