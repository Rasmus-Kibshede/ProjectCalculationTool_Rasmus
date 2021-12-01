package projectCalculationTool.subproject;

import projectCalculationTool.project.Project;
import projectCalculationTool.task.Task;

import java.sql.SQLException;

public class SubProjectService {
    private SubProjectRepositoryInterface subProjectRepositoryInterface;

    public SubProjectService(SubProjectRepositoryInterface subProjectRepositoryInterface) {
        this.subProjectRepositoryInterface = subProjectRepositoryInterface;
    }

    public void createSubProject(
            String subProjectName,
            int projectID,
            String taskName1,
            int taskTime1,
            String taskName2,
            int taskTime2,
            String taskName3,
            int taskTime3
    ) throws SQLException {

        Project project = new Project();
        project.setProjectID(projectID);
        SubProject subProject = new SubProject(validateSubProjectName(subProjectName));
        subProject.addTask(new Task(taskTime1, taskName1));
        subProject.addTask(new Task(taskTime2, taskName2));
        subProject.addTask(new Task(taskTime3, taskName3));
        project.addSubproject(validateSubProjectIncludesTask(subProject));

        subProjectRepositoryInterface.createSubProject(project);
    }

    //Edit method name in class diagram
    public SubProject readSubProject(int subProjectID) {
        //Return a SubProject
        return null;
    }

    public SubProject updateSubProject(){
        return null;
    }

    public void deleteSubProject(){}

    //ER DET DEN RIGTIGE EXCEPTION???
    public String validateSubProjectName(String subprojectName) throws SQLException{
        if (subprojectName != null && !subprojectName.isEmpty() && subprojectName.length() <= 45) {
            return subprojectName;
        } else {
            throw new SQLException("Project name can't be null or longer then 45 characters.");
        }
    }

    public SubProject validateSubProjectIncludesTask(SubProject subProject) throws SQLException{
        if(subProject.getTasks() != null){
            return subProject;
        }else {
            throw new SQLException("You can't create SubProject without at least one Task");
        }
    }
}
