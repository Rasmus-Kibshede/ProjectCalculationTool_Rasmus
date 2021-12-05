package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.util.exception.SubProjectException;
import projectCalculationTool.util.exception.ValidateException;

public class SubProjectService {
  private SubProjectRepositoryInterface subProjectRepositoryInterface;

  public SubProjectService(SubProjectRepositoryInterface subProjectRepositoryInterface) {
    this.subProjectRepositoryInterface = subProjectRepositoryInterface;
  }

  public void createSubProject(String subProjectName, int projectID, Project project) throws SubProjectException, ValidateException {
    //skal ikke laves nyt project, der skal sendes et project med??
    project = new Project();
    project.setProjectID(projectID);
    SubProject subProject = new SubProject(validateSubProjectName(subProjectName));

    project.addSubproject((subProject));

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
  public String validateSubProjectName(String subprojectName) throws ValidateException {
    if (subprojectName != null && !subprojectName.isEmpty() && subprojectName.length() <= 45) {
      return subprojectName;
    } else {
      throw new ValidateException("Project name can't be null or longer then 45 characters.");
    }
  }

  /*//bruger vi stadig denne??
  public SubProject validateSubProjectIncludesTask(SubProject subProject) throws ProjectException {
    if (subProject.getTasks() != null) {
      return subProject;
    } else {
      throw new ProjectException("You can't create SubProject without at least one Task");
    }
  }
   */
}
